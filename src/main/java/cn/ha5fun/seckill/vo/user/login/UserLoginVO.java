package cn.ha5fun.seckill.vo.user.login;

import cn.ha5fun.seckill.pojo.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "用户登录Model")
public class UserLoginVO{
        @ApiModelProperty(value = "username" ,required = true , example = "18090909090")
        @NotBlank(message = "用户名不能为空")
        private String username;

        @ApiModelProperty(value = "password" , required = true ,example = "MD5PASSWORD")
        @NotBlank(message = "密码不能为空")
        private String password;
    }