package cn.ha5fun.seckill.vo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 异常返回枚举
 * @Date 2020/12/31 5:55 下午
 * @Version 1.0.0
 */
@ToString
@AllArgsConstructor
@Getter
public enum ExceptionStatusBean {
    /**
     * HttpMessageNotReadableException 异常
     */
    RESPONSE_BODY_MISSING(60001,"未获取到指定参数");
    private final int code;
    private final String message;
}
