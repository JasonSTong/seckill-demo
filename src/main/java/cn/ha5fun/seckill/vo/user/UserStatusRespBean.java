package cn.ha5fun.seckill.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 用户的状态码
 * @Date 2020/12/29 9:49 下午
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusRespBean {
    private long code;
    private String message;
    private Object data;
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户登录成功 返回给客户端 (无返回值)
     * @Date 2020/12/30 11:27 上午 
     * @Return UserStatusRespBean
     */
    public UserStatusRespBean loginSuccess(){
        return new UserStatusRespBean(UserStatusEnum.LOGIN_SUCCESS.getCode(),UserStatusEnum.LOGIN_SUCCESS.getMessage(),null);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description   用户登录成功 返回给客户端
     * @Date 2020/12/30 11:28 上午 
     * @param data
     * @Return UserStatusRespBean
     */
    public UserStatusRespBean loginSuccess(Object data){
        return new UserStatusRespBean(UserStatusEnum.LOGIN_SUCCESS.getCode(),UserStatusEnum.LOGIN_SUCCESS.getMessage(),data);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户名错误返回信息
     * @Date 2020/12/30 2:10 下午
     * @Return UserStatusRespBean
     */
    public UserStatusRespBean loginErrorUsername(Object data){
        return new UserStatusRespBean(UserStatusEnum.LOGIN_ERROR_USERNAME.getCode(), UserStatusEnum.LOGIN_ERROR_USERNAME.getMessage(), data);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  登录账号或密码错误
     * @Date 2020/12/30 2:11 下午
     * @Return UserStatusRespBean
     */
    public UserStatusRespBean loginErrorUsernameOrPass(Object data){
        return new UserStatusRespBean(UserStatusEnum.LOGIN_ERROR_USERNAME_OR_PASS.getCode(),UserStatusEnum.LOGIN_ERROR_USERNAME_OR_PASS.getMessage(), data);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  注册成功
     * @Date 2020/12/30 2:16 下午
     * @Return UserStatusRespBean
     */
    public UserStatusRespBean registerSuccess(Object data){
        return new UserStatusRespBean(UserStatusEnum.REGISTER_SUCCESS.getCode(),UserStatusEnum.REGISTER_SUCCESS.getMessage(), data);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户名重复错误
     * @Date 2020/12/30 2:16 下午
     * @Return UserStatusRespBean
     */
    public UserStatusRespBean registerUsernameRepeatError(Object data){
        return new UserStatusRespBean(UserStatusEnum.REGISTER_USERNAME_REPEAT_ERROR.getCode(),UserStatusEnum.REGISTER_USERNAME_REPEAT_ERROR.getMessage(), data);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  密码长度过短错误
     * @Date 2020/12/30 2:17 下午
     * @Return UserStatusRespBean
     */
    public UserStatusRespBean registerPasswordLengthShortError(Object data){
        return new UserStatusRespBean(UserStatusEnum.REGISTER_PASSWORD_LENGTH_SHORT_ERROR.getCode(),UserStatusEnum.REGISTER_PASSWORD_LENGTH_SHORT_ERROR.getMessage(), data);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  密码长度过长错误
     * @Date 2020/12/30 2:17 下午
     * @Return
     */
    public UserStatusRespBean registerPasswordLengthLongError(Object data){
        return new UserStatusRespBean(UserStatusEnum.REGISTER_PASSWORD_LENGTH_LONG_ERROR.getCode(),UserStatusEnum.REGISTER_PASSWORD_LENGTH_LONG_ERROR.getMessage(), data);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户名不符合规则
     * @Date 2020/12/30 5:41 下午
     * @Return UserStatusRespBean
     */
    public UserStatusRespBean registerUsernameError(Object data){
        return new UserStatusRespBean(UserStatusEnum.REGISTER_USERNAME_ERROR.getCode(),UserStatusEnum.REGISTER_USERNAME_ERROR.getMessage(), data);
    }

}
