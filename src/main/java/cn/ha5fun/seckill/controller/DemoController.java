package cn.ha5fun.seckill.controller;

import cn.ha5fun.seckill.pojo.User;
import cn.ha5fun.seckill.utils.RedisUtils;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/test")
@Api(tags = "测试模块")
public class DemoController {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * @return org.springframework.http.ResponseEntity<java.lang.String>
     * @Author chencong
     * @Version 1.0.0
     * @Description 测试
     * @Date 11:05 下午 2020/12/13
     */
    @ApiImplicitParam(name = "a", value = "任何int类型值", required = true)
    @ApiOperation(value = "测试文档接")
    @ResponseBody()
    @GetMapping("test")
    public ResponseEntity<String> test(int a) {
        return ResponseEntity.ok("测试ok+" + a);
    }

    @ApiImplicitParam(name = "session", value = "HttpSession", required = true)
    @ApiOperation(value = "歪比歪卜")
    @PostMapping("/test")
    @ResponseBody()
    public Object toList(@ApiParam(hidden = true) @CookieValue("userTicket") String userTicket, HttpSession session) {
        // 从session 获取对象
        JSONObject jsonObject = new JSONObject();
        User attribute = (User) session.getAttribute(userTicket);
        // 判断 ticket是否过期
        if (redisUtils.get("ticket:" + attribute.getId()) != null) {
            redisUtils.expire("ticket:" + attribute.getId(), 60*15);
            redisUtils.expire("user:" + attribute.getId(), 60*15);
            jsonObject.put("user", attribute);
        } else {
            jsonObject.put("data", "由于长时间未操作,登录已过期,请重新登录");
        }

        return ResponseEntity.ok(jsonObject);
    }
}
