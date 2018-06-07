package com.commons.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

/**
 * @author dth
 * @date 2018/6/7 16:42
 **/
public class Base64Utils {
    static Logger log = LoggerFactory.getLogger(Base64Utils.class);

    /**
     * 编码
     */
    public static String encoderX(String text){
        final Base64.Encoder encoder = Base64.getEncoder();
        String encodedPwd = "";
        try {
            final byte[] textByte = String.valueOf(text).getBytes("UTF-8");
            //编码
            encodedPwd = encoder.encodeToString(textByte);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return encodedPwd;
    }

    /**
     * 解码
     */
    public static String decoderX(String text){
        final Base64.Decoder decoder = Base64.getDecoder();
        String decoderPwd = "";
        try{
            decoderPwd = new String(decoder.decode(text), "UTF-8");
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return decoderPwd;
    }
}
