package cn.ha5fun.seckill.exception;

import cn.ha5fun.seckill.vo.RespBean;
import cn.ha5fun.seckill.vo.StatusEnum;
import cn.ha5fun.seckill.vo.exception.ExceptionRespBean;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 全局异常处理
 * @Date 2020/12/31 12:24 上午
 * @Version 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description 如果为全局异常 -> 抛出定义error
     * @Date 2020/12/31 12:44 上午
     * @param e
     * @Return cn.ha5fun.seckill.vo.RespBean
     */
    @ExceptionHandler
    public RespBean ExceptionHandler(Exception e){
        if (e instanceof GlobalException){
            GlobalException globalException = (GlobalException) e;
            return RespBean.error(globalException.getStatusEnum());
        }else if(e instanceof MethodArgumentNotValidException){
            // 如果为BindException
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            System.out.println(StatusEnum.BIND_ERROR.getCode());
            RespBean respBean = RespBean.validatedError("请检查是否填写用户名或密码");
            respBean.setMessage("参数校验异常:"+methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        return RespBean.error();
    }
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ExceptionRespBean httpMessageNotReadableException(Exception e){
        HttpMessageNotReadableException exception = (HttpMessageNotReadableException) e;

        return ExceptionRespBean.requestBodyMissing(exception.getMessage());
    }
}
