package cn.ha5fun.seckill.mapper;

import cn.ha5fun.seckill.pojo.User;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chensitong 
 * @since 2020-12-18
 */
@Component(value = "userMapper")
public interface UserMapper extends BaseMapper<User> {
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  查询所有用户
     * @Date 2020/12/19 10:00 下午
     * @Return List<User>
     */
    List<User> selAllWithoutPass();
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户(账号)/邮箱/手机  密码登录
     * @Date 2020/12/29 2:40 下午
     * @Return User
     */
    User loginWithPhoneOrEmail(User user);

    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户注册(邮箱/手机/用户名)
     * @Date 2020/12/29 2:46 下午
     * @Return JSON字符串
     */
    Integer userRegister(User user);

    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  用户完成注册前查询
     * @Date 2020/12/30 2:34 下午
     * @param user
     * @Return Boolean
     */
    User selBeforeRegister(User user);
}
