package cn.ha5fun.seckill.exception;

import cn.ha5fun.seckill.vo.RespBean;
import cn.ha5fun.seckill.vo.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 全局异常
 * @Date 2020/12/31 12:21 上午
 * @Version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private StatusEnum statusEnum;
}
