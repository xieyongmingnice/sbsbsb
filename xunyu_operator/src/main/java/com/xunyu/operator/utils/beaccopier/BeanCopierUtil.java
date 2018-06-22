package com.xunyu.operator.utils.beaccopier;

import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
/**
 * @author xym
 * @description beanCopy工具类
 * @date 2018/6/22 11:19
 */
public class BeanCopierUtil {

    public static Map<String, BeanCopier> beanCopierMap = Maps.newHashMap();

    /**
     * @Title: copyProperties
     * @param source 资源类
     * @param target  目标类
     */
    public static void copyProperties(Object source,Object target){
        String beanKey = generateKey(source.getClass(),target.getClass());
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        }else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    private static String generateKey(Class<?>class1,Class<?>class2){
        return class1.toString() + class2.toString();
    }
}
