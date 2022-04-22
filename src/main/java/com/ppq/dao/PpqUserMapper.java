package com.ppq.dao;

import com.ppq.pojo.User;

public interface PpqUserMapper {
    User login(String username);
}
