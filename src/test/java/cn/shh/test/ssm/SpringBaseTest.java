package cn.shh.test.ssm;

import cn.shh.test.ssm.common.aop.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * AOP功能测试
 * <p>
 * 正常通知打印顺序：<ol>
 *   <li> ==================环绕通知前==================
 *   <li> ==================前置通知===================
 *   <li> 张三正在学习Java。
 *   <li> ==================返回通知===================
 *   <li> ==================后置通知===================
 *   <li> ==================环绕通知后==================
 * </ol>
 *
 * 有异常时通知打印顺序：<ol>
 *   <li> ==================环绕通知前==================
 *   <li> ==================前置通知===================
 *   <li> 张三正在学习Java。
 *   <li> ==================异常通知===================
 *   <li> ==================后置通知===================
 *   <li> ==================环绕通知后==================
 * </ol>
 */
@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class SpringBaseTest {
    @Autowired
    private TestService testService;

    @Test
    public void testAop(){
        testService.doing();
    }
}
