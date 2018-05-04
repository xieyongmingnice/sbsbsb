package com.xunyu.config.oos;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.ServiceException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 阿里云OSS上传文件工具
 * <p>
 * 支持普通文件上传，限制大小文件上传,限制大小图片上传
 *
 * @version1.0
 */
@Configuration
public class AliyunOssUtil {

    private final Logger logger = LoggerFactory.getLogger(AliyunOssUtil.class);
    /**
     * 阿里云API的内或外网域名
     */
    //@Value("${oss.endPoint}")
    private String ENDPOINT = "http://oss-cn-qingdao.aliyuncs.com";

    /**
     * OSS签名key
     */
    //@Value("${oss.accessKeyId}")
    private String ACCESS_KEY_ID = "LTAIxfWn1qhejCJ8";

    /**
     * OSS签名密钥
     */
    //@Value("${oss.accessKeySecret}")
    private String ACCESS_KEY_SECRET = "HEvipWVkRkQBiaSX237kuHnRFF59KO";

    /**
     * 存储空间名称
     */
    //@Value("${oss.bucketName}")
    private String BUCKETNAME = "xunyu-ossfile";

    private  OSSClient ossClient = null;

     Map<String, Object> resultMap = new HashMap<String, Object>();


    /**
     * 判断bucket存储空间是否已建立
     * 若未建立，先创建一个Bucket
     */
    public void ensureBucket() throws OSSException, ClientException {

        try {
            //判断bucket是否存在
            boolean exists = ossClient.doesBucketExist(BUCKETNAME);
            if (!exists) {

                logger.error("bucket不存在，新建当前bucket:{}", BUCKETNAME);

                ossClient.createBucket(BUCKETNAME);
            }

        } catch (ServiceException e) {
            logger.error(e.getErrorCode() + "  " + e.getErrorMessage());
            throw e;
        }

    }


    /**
     * 上传文件到OSS服务器
     * 如果同名文件会覆盖服务器上的
     *
     * @param //CommonsMultipartFile file 上传文件
     * @param //String               dirName 文件目录名称  （在oss中不存在目录一说，只是用于形象的区分文件种类）
     * @param //String               fileName 文件名
     * @return Map<String   ,       Object> map
     * stauts :true 上传成功   。 false  上传失败
     * msg :成功，返回文件路径。失败，返回失败信息
     */
    public Map<String, Object> uploadFileOSS(MultipartFile file, String dirName, String fileName) {

        String ret = "";//上传完成返回签名
        String uploadDir = "";//目录名
        String uploadPath = "";//保存文件路径名称

        InputStream uploadInputStrem = null;


        if (!"".equals(dirName) && dirName != null) {
            uploadDir = dirName.substring(0, dirName.length()).replaceAll("\\\\", "/");
        }

        try {

            //判断bucket是否存在
            ensureBucket();

            //获取上传文件后缀名
            String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            uploadPath = uploadDir + fileName;

            //创建上传Object的Metadata。ObjectMetaData是用户对该object的描述
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setContentEncoding("utf-8");
            objectMetadata.setContentType(getcontentType(file, fileSuffix));//获取文件类型
            objectMetadata.setContentDisposition("attachment;filename=" + fileName);

            uploadInputStrem = file.getInputStream();   //文件输入流


            //上传文件
            logger.debug("正在上传文件到OSS...");
            PutObjectResult putResult = ossClient.putObject(BUCKETNAME, uploadPath, uploadInputStrem, objectMetadata);
            logger.debug("上传文件完成...");
            ret = putResult.getETag();
            logger.debug("上传后的文件MD5数字唯一签名:{}", ret);

        } catch (IOException e) {
            resultMap.put("code", 500);
            resultMap.put("message", "上传失败!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code", 500);
            resultMap.put("message", "上传失败!");
            return resultMap;
        } finally {

            try {
                if (uploadInputStrem != null) {
                    uploadInputStrem.close();//关闭文件流
                }
                if (ossClient != null) {
                    destory();//销毁oss对象
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!"".equals(ret) && ret != null) {
            resultMap.put("code", 200);
            resultMap.put("url", getUrl(uploadPath));
            resultMap.put("message","上传成功");
            return resultMap;
        } else {
            resultMap.put("code", 500);
            resultMap.put("message", "上传失败!");
            return resultMap;
        }
    }


    /**
     * 上传文件到OSS服务器
     * 如果同名文件会覆盖服务器上已存在文件
     *
     * @param //CommonsMultipartFile file  上传文件
     * @param //String               dirName 文件目录名称  （在oss中不存在目录一说，只是用于形象的区分文件种类）
     * @param //String               fileName   文件名
     * @param //int                  limitSize     上传大小
     * @return Map<String   ,       Object> map
     * stauts :true 上传成功   。 false  上传失败
     * msg :成功，返回文件路径。失败，返回失败信息
     */
    public Map<String, Object> UploadLimitSizeOSS(MultipartFile file,
                                                  String dirName, String fileName, int limitSize) {

        if (file == null) {
            resultMap.put("status", false);
            resultMap.put("message", "未选择文件");
            destory();
            return resultMap;
        }
        long limitSizeBytes = limitSize * 1024 * 1024;// 把单位M转换为bytes
        if (file.getSize() > limitSizeBytes) {
            resultMap.put("code", "413");
            resultMap.put("message", "您上传的文件超出限制大小。" + limitSize + "M");
            destory();
            return resultMap;
        }

        return uploadFileOSS(file, dirName, fileName);
    }


    /**
     * 上传图片到到OSS服务器
     * 如果同名文件会覆盖服务器上已存在文件
     *
     * @param //CommonsMultipartFile file  上传文件
     * @param //String               dirName 文件目录名称  （在oss中不存在目录一说，只是用于形象的区分文件种类）
     * @param //String               fileName   文件名
     * @param //int                  limitSize     上传大小
     * @return Map<String   ,       Object> map
     * stauts :true 上传成功   。 false  上传失败
     * msg :成功，返回文件路径。失败，返回失败信息
     */
    public Map<String, Object> ImgUploadLimitSizeOSS(MultipartFile file,
                                                     String dirName, String fileName, int limitSize) {

        if (file == null) {
            resultMap.put("code", "413");
            resultMap.put("message", "未选择文件。");
            destory();
            return resultMap;
        }
    
       /* if (!ImageUtil.fileIsImage(file)) {
            resultMap.put("status", false);
            resultMap.put("message", "请选择上传图片文件!");
            destory();
            return resultMap;
        }*/

        long limitSizeBytes = limitSize * 1024 * 1024;// 把单位M转换为bytes

        if (file.getSize() > limitSizeBytes) {
            resultMap.put("code", "413");
            resultMap.put("message", "您上传的文件超出限制大小" + limitSize + "M");
            destory();
            return resultMap;
        }

        return uploadFileOSS(file, dirName, fileName);
    }


    /**
     * 判断OSS服务文件上传时文件的contentType
     *
     * @param //CommonsMultipartFile file 上传文件
     * @param FilenameExtension      文件后缀
     * @return String
     */
    public String getcontentType(MultipartFile file, String FilenameExtension) {

        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png") ||
                FilenameExtension.equalsIgnoreCase(".jpz")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html") ||
                FilenameExtension.equalsIgnoreCase(".htm") ||
                FilenameExtension.equalsIgnoreCase(".hts")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        if (FilenameExtension.equalsIgnoreCase(".xls")) {
            return "application/vnd.ms-excel";
        }
        if (FilenameExtension.equalsIgnoreCase(".xlsx")) {
            return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        }
        if (FilenameExtension.equalsIgnoreCase(".zip")) {
            return "application/zip";
        }
        return file.getContentType();
    }


    /**
     * 销毁阿里云OSS客户端对象
     */
    public void destory() {
        ossClient.shutdown();
    }


    /**
     * 获取阿里云远程OSS指定文件.并转为输出流
     *
     * @param //String       ossPrefix  访问阿里云oss文件路径 （http://ygzb.oss-cn-beijing.aliyuncs.com/）
     * @param //String       fileUrl 文件保存路径 （如：upload/a.png）
     * @param //OutputStream oputstream  输出流
     * @throws IOException
     */
    public void downFile(String ossPrefix, String fileUrl, OutputStream oputstream) throws IOException {

        InputStream iputstream = null;

        try {

            String ossFilePath = ossPrefix + fileUrl;//阿里云网络文件地址
            URL url = new URL(ossFilePath);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
            uc.connect();
            iputstream = uc.getInputStream();
            byte[] buffer = new byte[4 * 1024];
            int byteRead = -1;
            while ((byteRead = (iputstream.read(buffer))) != -1) {
                oputstream.write(buffer, 0, byteRead);
            }
            oputstream.flush();

        } catch (Exception e) {
            System.out.println("读取失败！");
            e.printStackTrace();
        } finally {
            if (iputstream != null) {
                iputstream.close();
            }
        }
    }


    public AliyunOssUtil(){
        try {
        // 初始化一个OSSClient
            ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10

        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(BUCKETNAME, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

}