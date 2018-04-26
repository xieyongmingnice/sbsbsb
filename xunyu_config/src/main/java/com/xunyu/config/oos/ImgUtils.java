package com.xunyu.config.oos;

import java.util.List;

/**
 * @author dth
 * @date 2018/4/26 9:12
 **/
public class ImgUtils {

    // 对图片格式进行判断
    public static boolean isImg(String extend) {
        boolean ret = false;
        List<String> list = new java.util.ArrayList<String>();
        list.add(".jpg");
        list.add(".jpeg");
        list.add(".bmp");
        list.add(".gif");
        list.add(".png");
        list.add(".tif");
        for (String s : list) {
            if (s.equalsIgnoreCase(extend))
                ret = true;
        }
        return ret;
    }
}
