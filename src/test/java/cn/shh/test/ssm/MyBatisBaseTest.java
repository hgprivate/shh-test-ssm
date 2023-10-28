package cn.shh.test.ssm;

import cn.shh.test.ssm.mapper.UserMapper;
import cn.shh.test.ssm.pojo.User;
import cn.shh.test.ssm.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

/**
 * mybatis 增删改查基础测试
 */
public class MyBatisBaseTest {
    private SqlSession sqlSession;

    @Test
    public void testInsert() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUname("李四4");
        user.setPassword("123321");
        user.setAge(19);
        user.setGender("男");
        user.setEmail("lisi@qq.com");
        userMapper.insert(user);
        System.out.println("插入成功。");
    }

    @Test
    public void testGetById() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getById(1);
        System.out.println("user: " + user);
    }

    @Test
    public void testGetAll() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(9);
        user.setUname("王五");
        user.setPassword("123321");
        user.setAge(19);
        user.setGender("男");
        user.setEmail("wangwu@qq.com");
        int result = userMapper.updateById(user);
        System.out.println(1 == result ? "修改成功" : "修改失败");
    }

    @Test
    public void testDelete() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        HashSet<Integer> ids = new HashSet<>();
        ids.add(8);
        ids.add(9);
        ids.add(10);
        int result = userMapper.deleteByIds(ids);
        System.out.println(0 < result ? "删除成功" : "删除失败");
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