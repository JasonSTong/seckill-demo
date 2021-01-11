package cn.ha5fun.seckill.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description UUID工具类
 * @Date 2021/1/4 12:40 上午
 * @Version 1.0.0
 */
public class UUIDUtils {

    public static String getUuid(){
        return new MD5Utils().getMD5(UUID.randomUUID().toString().replaceAll("-",""));
    }
}