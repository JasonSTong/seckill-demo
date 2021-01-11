package cn.ha5fun.seckill.vo.user;

import cn.ha5fun.seckill.pojo.User;
import cn.ha5fun.seckill.utils.MD5Utils;
import cn.ha5fun.seckill.utils.RegularExpressionUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 通用校验方法
 * @Date 2020/12/29 7:31 下午
 * @Version 1.0.0
 */
@Component
public class GeneralVo {

    MD5Utils md5Utils = new MD5Utils();

    public Map checkLoginOrRegisterUserVo(String username, String password){
        HashMap<String, Object> map = new HashMap<>();
        User user = new User();
        String dbPass = md5Utils.fromPassToDBPass(password, "chensitong");
        if(Pattern.matches(RegularExpressionUtils.PHONE,username)) {
            user.setPhone(username).setPassword(dbPass);
        }else if(Pattern.matches(RegularExpressionUtils.EMAil,username))
            user.setEmail(username).setPassword(dbPass);
        else{
            map.put("boolean","false");
            map.put("data","用户名不正确");
            return map;
        }
        map.put("boolean","true");
        map.put("user",user);
        return map;
    }
}
