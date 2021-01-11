package cn.ha5fun.seckill.vo.validator.login;

import cn.ha5fun.seckill.validator.IsMobile;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description 手机号校验规则
 * @Date 2020/12/23 12:32 上午
 * @Version 1.0.0
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {
    boolean required = false;
    //初始化
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
//            return ;
        }else{
            if(StringUtils.isEmpty(value)){
                return true;
            }else {
//                return ValidatorU
            }
        }
        return false;
    }
}
