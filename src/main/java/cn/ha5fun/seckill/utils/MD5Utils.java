package cn.ha5fun.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description MD5工具类
 * @Date 2020/12/14 12:08 上午
 * @Version 1.0.0
 */
@Component
public class MD5Utils {
    // 盐值
//    private static final String salt = "chensitong";
    public String getSalt(String salt){
        return salt;
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  获取MD5
     * @Date 12:34 上午 2020/12/14
     * @param src
     * @return 返回MD5
     */
    public String getMD5(String src){
        return DigestUtils.md5Hex(src);
    }


    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  传入密码加密
     * @Date 12:35 上午 2020/12/14
     * @param inputPass
     * @return
     */
    public String inputPassToFromPass(String inputPass,String salt){
        String src = salt.charAt(1)+salt.charAt(2)+inputPass+salt.charAt(2)+salt.charAt(8);
        return getMD5(src);
    }

    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description 二次加密->到数据库
     * @Date 12:52 上午 2020/12/14
     * @param fromPass
     * @param salt
     * @Return java.lang.String
     */
    public String fromPassToDBPass(String fromPass, String salt){
        String src = salt.charAt(1)+salt.charAt(2)+fromPass+salt.charAt(2)+salt.charAt(8);
        return getMD5(src);
    }
    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description  inputPass -> 加密 -> 加密 -> 存入数据库
     * @Date 1:00 上午 2020/12/14
     * @param inputPass
     * @param salt
     * @Return java.lang.String
     */
    public String inputPassToDBPass(String inputPass,String salt){
        String MD5InputPass = inputPassToFromPass(inputPass,salt);
        String dbPass = fromPassToDBPass(MD5InputPass, salt);
        return dbPass;
    }

    /**
     * @Author chencong
     * @Version 1.0.0
     * @Description 测试类
     * @Date 2020/12/14 10:26 上午
     * @param
     * @Return void
     */
    @Test
    public void testMD5(){

        String fromPass = inputPassToFromPass("password", getSalt("chensitong"));
        String dbPass = fromPassToDBPass(fromPass, getSalt("chensitong"));
        String dbPass1 = inputPassToDBPass("password", getSalt("chensitong"));
        System.out.println(dbPass1);
        System.out.println(fromPass);
        System.out.println(dbPass);

    }

    @Test
    public void timestampTest(){
        Timestamp timestamp = new Timestamp(1608365520);
        Date date = new Date(timestamp.getTime());

        Date date1 = new Date(1608365520);
        System.out.println(date1);
        System.out.println(date.toString());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.parse();
//        System.out.println(format);
    }


}
