package cn.shh.test.ssm;

import cn.shh.test.ssm.mapper.DynamicSQLMapper;
import cn.shh.test.ssm.pojo.Dept;
import cn.shh.test.ssm.pojo.Emp;
import cn.shh.test.ssm.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MyBatisDynamicSQLTest {
    @Test
    public void testInsertBatch(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
            Emp emp = new Emp(null, "test01", 30, "男", new Dept(2, null, null));
            Emp emp2 = new Emp(null, "test02", 30, "女", new Dept(2, null, null));
            List<Emp> emps = Arrays.asList(emp, emp2);
            int result = dynamicSQLMapper.insertBatch(emps);
            System.out.println(0 < result ? "插入成功" : "插入失败");
        }
    }

    @Test
    public void testGetByCondition(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
            //Emp emp = dynamicSQLMapper.getEmp(Emp.builder().eName("张三").build());
            //Emp emp = dynamicSQLMapper.getEmp(Emp.builder().eName("张三").build());
            Emp emp = dynamicSQLMapper.getEmpByChoose(Emp.builder().eName("张三").build());
            //Emp emp = dynamicSQLMapper.getEmpByChoose(Emp.builder().eName("张三").build());
            System.out.println(emp);
        }
    }
}