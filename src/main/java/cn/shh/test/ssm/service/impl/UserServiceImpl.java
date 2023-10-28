package cn.shh.test.ssm.service.impl;

import cn.shh.test.ssm.common.annotations.SSMLogger;
import cn.shh.test.ssm.mapper.UserMapper;
import cn.shh.test.ssm.pojo.User;
import cn.shh.test.ssm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @SSMLogger
    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    @Override
    public List<User> getALL() {
        return userMapper.getAll();
    }
    @Override
    public List<User> getByLike(String c) {
        return userMapper.getByLike(c);
    }

    @Transactional(

    )
    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int deleteByIds(HashSet<Integer> ids) {
        return userMapper.deleteByIds(ids);
    }
}
