package cn.shh.test.ssm;

import cn.shh.test.ssm.mapper.DeptMapper;
import cn.shh.test.ssm.mapper.EmpMapper;
import cn.shh.test.ssm.pojo.Dept;
import cn.shh.test.ssm.pojo.Emp;
import cn.shh.test.ssm.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ResourceBundle;

/**
 * 一对多、多对一、模糊匹配
 */
public class MybatisHighLevelTest {
    private SqlSession sqlSession;

    /**
     * 模糊匹配
     * <p>
     * 对于模糊匹配，mapper xml中的书写方式如下：<ol>
     *   <li> where uname like "%"#{c}"%"   （推荐）
     *   <li> where uname like '%${c}%'
     *   <li> where uname like concat('%', #{c}, '%');
     * </ul>
     */
    @Test
    public void testFuzzyMatching(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.getByLike("张");
        empList.forEach(e -> System.out.println(e.getEName()));
    }

    /**
     * 多对一、延迟加载
     */
    @Test
    public void testGetEmpById(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpById(1);
        System.out.println(emp.getEName());
    }
    @Test
    public void testGetAllEmp(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.getAllEmp();
        empList.forEach(System.out::println);
    }
    @Test
    public void testUpdateById(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int result = empMapper.updateById(new Emp(1, "张三2", 20, "男",
                new Dept(2, null, null)));
        System.out.println(1 == result ?"修改成功。" : "修改失败");
    }
    @Test
    public void testDeleteById(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int count = empMapper.deleteById(8);
        System.out.println(1 == count ? "删除成功" : "删除失败");
    }
    @Test
    public void testDeleteByIds(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int count = empMapper.deleteByIds("5, 6");
        System.out.println(0 < count ? "删除成功" : "删除失败");
    }

    /**
     * 一对多、延迟加载
     */
    @Test
    public void testGetDeptById(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptById(1);
        System.out.println(dept);
    }
    @Test
    public void testGetAllDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptList = deptMapper.getAllDept();
        deptList.forEach(System.out::println);
    }

    @BeforeEach
    public void init(){
        System.setProperty("pagehelper.banner", "false");
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        this.sqlSession =sqlSession;
    }
    @AfterEach
    public void close(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }
}