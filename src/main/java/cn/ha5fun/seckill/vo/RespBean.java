package cn.ha5fun.seckill.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 返回结果
 * @Date 2020/12/16 12:12 上午
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object data;
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description 无参成功返回
     * @Date 2020/12/16 12:39 上午
     * @param
     * @Return cn.ha5fun.seckill.vo.RespBean
     */
    public static RespBean success(){
         return new RespBean(StatusEnum.SUCCESS.getCode(),StatusEnum.SUCCESS.getMessage(),null);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description 有参成功构造
     * @Date 2020/12/16 12:39 上午
     * @param object
     * @Return cn.ha5fun.seckill.vo.RespBean
     */
    public static RespBean success(Object object){
        return new RespBean(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMessage(), object);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description 无参错误返回
     * @Date 2020/12/16 12:41 上午
     * @param
     * @Return cn.ha5fun.seckill.vo.RespBean
     */
    public static RespBean error(){
        return new RespBean(StatusEnum.ERROR.getCode(),StatusEnum.ERROR.getMessage(),null);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description 有参错误返回
     * @Date 2020/12/16 12:43 上午
     * @param object
     * @Return cn.ha5fun.seckill.vo.RespBean
     */
    public static RespBean error(Object object){
         return new RespBean(StatusEnum.ERROR.getCode(), StatusEnum.ERROR.getMessage(),object);
    }

    public static RespBean validatedError(Object object){
        return new RespBean(StatusEnum.BIND_ERROR.getCode(), StatusEnum.BIND_ERROR.getMessage(),object);
    }
}
