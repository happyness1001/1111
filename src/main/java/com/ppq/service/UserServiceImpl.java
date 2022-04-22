package com.ppq.service;

import com.ppq.dao.PpqUserMapper;
import com.ppq.pojo.User;
import org.springframework.stereotype.Service;

@Service("ppqUserServiceImpl")
public class UserServiceImpl implements UserService {
    private PpqUserMapper userMapper;

    public void setUserMapper(PpqUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String username) {
        return userMapper.login(username);
    }
}
