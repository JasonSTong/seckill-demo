package cn.ha5fun.seckill.controller;


import cn.ha5fun.seckill.pojo.User;
import cn.ha5fun.seckill.service.IUserService;
import cn.ha5fun.seckill.utils.RedisUtils;
import cn.ha5fun.seckill.vo.RespBean;
import cn.ha5fun.seckill.vo.user.UserStatusRespBean;
import cn.ha5fun.seckill.vo.user.GeneralVo;
import cn.ha5fun.seckill.vo.user.login.UserLoginVO;
import cn.ha5fun.seckill.vo.user.register.UserRegisterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chensitong 
 * @since 2020-12-18
 */
@Controller
@RequestMapping("/user")
@Api(tags = "用户接口")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private GeneralVo generalVol;

    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description 查询所有的用户信息
     * @Date 2020/12/18 7:07 下午
     * @Return org.springframework.http.ResponseEntity<java.lang.String>
     */
    @ApiOperation(value = "获取所有用户")
    @PostMapping(value = "/getAll" , consumes = "application/json")
    @ResponseBody
    public ResponseEntity<RespBean> getUserList(){

        List<User> aLlUserList = userService.getALlUserList();
        if(aLlUserList != null){

            return ResponseEntity.ok(new RespBean().success(aLlUserList));
        }
        return ResponseEntity.ok(new RespBean().error());
    }
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login" , consumes = "application/json")
    public ResponseEntity<Object> userLogin(@RequestBody @Validated UserLoginVO userLoginVO, HttpServletRequest request,
                                                        HttpServletResponse response){
        Map map = generalVol.checkLoginOrRegisterUserVo(userLoginVO.getUsername(), userLoginVO.getPassword());
        // 判断用户名是否为手机号码或者邮箱
        if (map.get("boolean") == "false")
            return ResponseEntity.ok(new UserStatusRespBean().loginErrorUsername(map.get("data")));
        // TODO 以后可能会添加用户名登录
        // TODO 以后添加返回状态枚举,规范返回 final
        // TODO 登录之后修改User的count,最后登录时间
        // TODO 重复登录覆盖ticket
        if (userService.loginWithPhoneOrEmail((User) map.get("user") , request ,response))

            return ResponseEntity.ok(new UserStatusRespBean().loginSuccess());
        else
            return ResponseEntity.ok(new UserStatusRespBean().loginErrorUsernameOrPass(null));
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "用户注册")
    public ResponseEntity<UserStatusRespBean> userRegister(@RequestBody @Validated UserRegisterVO userRegisterVO){

        // 获取用户名和密码
        Map map = generalVol.checkLoginOrRegisterUserVo(userRegisterVO.getUsername(), userRegisterVO.getPassword());
        // 判断用户名是否复合规则
        if (map.get("boolean") == "false")
            return ResponseEntity.ok(new UserStatusRespBean().registerUsernameError(map.get("data")));
        // 注册前查询用户名是否存在
        if (userService.selBeforeRegister((User) map.get("user")))
            return ResponseEntity.ok(new UserStatusRespBean().registerUsernameRepeatError("用户名'"+userRegisterVO.getUsername()+"'已存在"));
        // 判断是否注册成功
        if (map.get("boolean") == "false")
            return ResponseEntity.ok(new UserStatusRespBean().registerUsernameRepeatError("注册失败:请联系管理员"));

        return ResponseEntity.ok(new UserStatusRespBean().registerSuccess(userService.userRegister((User) map.get("user"))));
    }

}
