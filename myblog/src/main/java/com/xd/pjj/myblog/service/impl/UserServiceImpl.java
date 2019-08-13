package com.xd.pjj.myblog.service.impl;

import com.xd.pjj.myblog.bean.User;
import com.xd.pjj.myblog.mapper.UserMapper;
import com.xd.pjj.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
