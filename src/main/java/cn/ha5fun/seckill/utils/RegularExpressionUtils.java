package cn.ha5fun.seckill.utils;

import lombok.Getter;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 正则表达式工具类
 * @Date 2020/12/19 9:56 下午
 * @Version 1.0.0
 */
@Getter
public final class RegularExpressionUtils {
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  邮箱正则表达式
     * @Date 2020/12/19 9:58 下午
     */
    public static final String EMAil = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  手机号码正则
     * @Date 2020/12/19 9:59 下午
     */
    public static final String PHONE = "^1[3|4|5|7|8][0-9]{9}$";
}
