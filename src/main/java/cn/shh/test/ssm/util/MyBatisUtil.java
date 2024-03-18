package cn.shh.test.ssm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类
 */
public class MyBatisUtil {
    private static final String RESOURCE = "mybatis-config.xml";

    public static SqlSessionFactory getSqlSessionFactory(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(RESOURCE);
            return new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static SqlSession getSqlSession(){
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        return sessionFactory.openSession(true);
    }
}