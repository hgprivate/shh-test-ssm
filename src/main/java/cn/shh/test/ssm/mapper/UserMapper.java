package cn.shh.test.ssm.mapper;

import cn.shh.test.ssm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Mapper
public interface UserMapper {
    public void insert(User user);
    public User getById(@Param("id") int id);
    public List<User> getAll();
    List<User> getByLike(@Param("mohu") String mohu);
    public int updateById(@Param("user") User user);
    public int deleteById(@Param("id") int id);
    public int deleteByIds(@Param("ids") HashSet<Integer> ids);
}