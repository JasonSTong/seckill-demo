package cn.ha5fun.seckill.service.impl;

import cn.ha5fun.seckill.pojo.User;
import cn.ha5fun.seckill.mapper.UserMapper;
import cn.ha5fun.seckill.service.IUserService;
import cn.ha5fun.seckill.utils.CookieUtils;
import cn.ha5fun.seckill.utils.RedisUtils;
import cn.ha5fun.seckill.utils.UUIDUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chensitong
 * @since 2020-12-18
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<User> getALlUserList() {
        return userMapper.selAllWithoutPass();
    }

    @Override
    public Boolean selBeforeRegister(User user) {
        return userMapper.selBeforeRegister(user) != null;
    }

    @Override
    public Object userRegister(User user) {
        if (super.save(user))
            return user;
        else
            return "注册失败!请联系管理员";
    }

    @Override
    public Boolean loginWithPhoneOrEmail(User user, HttpServletRequest request, HttpServletResponse response) {
        User getUser = userMapper.loginWithPhoneOrEmail(user);

        if (getUser != null) {
            String ticket = UUIDUtils.getUuid();
            request.getSession().setAttribute(ticket, getUser);
            CookieUtils.setCookie(request, response, "userTicket", ticket);

            // 放入redis 更改过期时间
            redisUtils.set("ticket:" + getUser.getId(), ticket,60*15);
            redisUtils.set("user:"+getUser.getId(),getUser,60*15);
            return true;
        }
        return false;
    }
}
