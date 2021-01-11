package cn.ha5fun.seckill.service;

import cn.ha5fun.seckill.pojo.User;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chensitong 
 * @since 2020-12-18
 */
public interface IUserService extends IService<User> {
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  查询所有User
     * @Date 2020/12/20 12:49 上午
     * @Return List<User>
     */
    List<User> getALlUserList();
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户登录模块
     * @Date 2020/12/29 2:50 下午
     * @param user
     * @Return boolean 是否登陆成功
     */
    Boolean loginWithPhoneOrEmail(User user, HttpServletRequest request, HttpServletResponse response);
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户完成注册前查询
     * @Date 2020/12/30 2:34 下午
     * @param user
     * @Return Boolean
     */
    Boolean selBeforeRegister(User user);
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户注册
     * @Date 2020/12/29 2:51 下午
     * @param user
     * @Return 返回json注册信息
     */
    Object userRegister(User user);


}
