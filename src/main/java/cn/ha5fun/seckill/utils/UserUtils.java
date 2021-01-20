package cn.ha5fun.seckill.utils;

import cn.ha5fun.seckill.mapper.UserMapper;
import cn.ha5fun.seckill.pojo.User;
import cn.ha5fun.seckill.vo.user.login.UserLoginUpdateVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.Query;
import java.sql.Wrapper;
import java.util.Date;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 用户通用工具
 * @Date 2021/1/17 2:57 下午
 * @Version 1.0.0
 */
@Slf4j
public class UserUtils {
    @Resource
    private UserMapper userMapper;

}
