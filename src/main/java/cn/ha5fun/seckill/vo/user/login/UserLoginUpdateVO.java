package cn.ha5fun.seckill.vo.user.login;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 用户登录自动更新
 * @Date 2021/1/17 3:43 下午
 * @Version 1.0.0
 */
@Data
@Accessors(chain = true)
public class UserLoginUpdateVO {
    private Integer id;
    private Date lastLoginDate;
    private Integer loginCount ;
}
