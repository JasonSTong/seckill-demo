package cn.ha5fun.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chensitong 
 * @since 2020-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id ;
    /**
     * 用户名
     */
    private String username;

    private String nickname;

    /**
     * MD5(MD5(pass明文+固定salt))
     */
    private String password;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 邮箱号
     */
    private String email;
    /**
     * 软删除
     */
    private Integer deleted = 0;
    /**
     * 暂时为固定盐值
     */
    private String slat;

    /**
     * 头像
     */
    private String head;
    /**
     * token
     */
    private String token;

    /**
     * 注册时间
     * !!仅注册时调用
     */
    private Date registerDate  = new Date();

    /**
     * 最后一次登录时间
     * !!仅登录时需要该参数
     */
    private Date lastLoginDate = new Date();

    /**
     * 登陆次数
     */
    private Integer loginCount = 0;


}
