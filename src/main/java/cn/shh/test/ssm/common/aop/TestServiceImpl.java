package cn.shh.test.ssm.common.aop;

import cn.shh.test.ssm.common.annotations.SSMLogger;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
    @SSMLogger
    @Override
    public void doing() {
        System.out.println("张三正在学习Java。");
        int n = 1 / 0;
    }
}