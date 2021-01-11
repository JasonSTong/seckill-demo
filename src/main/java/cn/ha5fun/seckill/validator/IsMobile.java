package cn.ha5fun.seckill.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 自定义手机校验
 * @Date 2020/12/23 12:26 上午
 * @Version 1.0.0
 */
@Documented
@Constraint(
        validatedBy = {}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsMobile {
    
     boolean required() default true;
    
    String message() default "手机或邮箱错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
