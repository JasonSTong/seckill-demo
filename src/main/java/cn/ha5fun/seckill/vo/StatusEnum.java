package cn.ha5fun.seckill.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 状态码
 * @Date 2020/12/15 11:31 上午
 * @Version 1.0.0
 */
@ToString
@AllArgsConstructor
@Getter
public enum StatusEnum {

    SUCCESS(200,"success"),
    ERROR(400,"false"),
    BIND_ERROR(50000,"参数校验异常");
    private final Integer code;
    private final String message;
}
