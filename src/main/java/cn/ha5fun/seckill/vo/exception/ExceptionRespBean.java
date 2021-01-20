package cn.ha5fun.seckill.vo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class ExceptionRespBean {
    private long code;
    private String message;
    private Object data;
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description 请求参数异常
     * @Date 2021/1/19 11:33 上午
     * @param data
     * @Return 返回exception 统一处理
     */
    public static ExceptionRespBean requestBodyMissing(Object data){
       return new ExceptionRespBean(ExceptionStatusBean.RESPONSE_BODY_MISSING.getCode(), ExceptionStatusBean.RESPONSE_BODY_MISSING.getMessage(), data);
    }
}
