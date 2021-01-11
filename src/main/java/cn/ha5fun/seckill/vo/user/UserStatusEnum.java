package cn.ha5fun.seckill.vo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 用户枚举状态码  10000-11000
 * @Date 2020/12/29 10:03 下午
 * @Version 1.0.0
 */
@ToString
@AllArgsConstructor
@Getter
public enum UserStatusEnum {
    /**
     * 登录
     */
    LOGIN_SUCCESS(200,"登陆成功"),
    LOGIN_ERROR_USERNAME(10001,"请检查用户名是否正确"),
    LOGIN_ERROR_USERNAME_OR_PASS(10002,"请检查用户名或密码"),
    /**
     * 注册
     */
    REGISTER_SUCCESS(200,"注册成功"),
    REGISTER_ERROR(10100,"注册通用错误"),
    REGISTER_USERNAME_ERROR(10101,"用户名不符合规则"),
    REGISTER_USERNAME_REPEAT_ERROR(10102,"用户名已被注册,请登录"),
    REGISTER_PASSWORD_LENGTH_SHORT_ERROR(10201,"用户名密码过短"),
    REGISTER_PASSWORD_LENGTH_LONG_ERROR(10102,"用户名密码过长");
    private final Integer code;
    private final String message;
}
