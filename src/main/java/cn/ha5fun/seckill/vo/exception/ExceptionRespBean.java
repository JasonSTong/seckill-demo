package cn.ha5fun.seckill.vo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 异常返回信息
 * @Date 2020/12/31 5:52 下午
 * @Version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionRespBean {
    private long code;
    private String message;
    private Object data;
    public static ExceptionRespBean requestBodyMissing(Object data){
       return new ExceptionRespBean(ExceptionStatusBean.RESPONSE_BODY_MISSING.getCode(), ExceptionStatusBean.RESPONSE_BODY_MISSING.getMessage(), data);
    }
}
