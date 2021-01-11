package cn.ha5fun.seckill.utils.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author chen
 * @Company ha5fun.com
 * @Description AOP测试
 * @Date 2020/12/31 8:01 下午
 * @Version 1.0.0
 */
@Aspect
@Component
public class AOPTest {
    @Pointcut("execution()")
    private void testAop(){};
}
