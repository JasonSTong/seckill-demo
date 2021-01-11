package cn.ha5fun.seckill.vo.user.register;

import cn.ha5fun.seckill.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 用户注册
 * @Date 2020/12/29 2:47 下午
 * @Version 1.0.0
 */
@Data
@ApiModel(value = "用户注册Model")
public class UserRegisterVO{
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "username",required = true,example = "建议/邮箱或者手机号")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "password",required = true,example = "密码")
    private String password;
}
