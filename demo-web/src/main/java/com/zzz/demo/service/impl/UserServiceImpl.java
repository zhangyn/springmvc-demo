package com.zzz.demo.service.impl;

import com.zzz.demo.dao.UserMapper;
import com.zzz.demo.model.User;
import com.zzz.demo.service.UserService;
import com.zzz.demo.vo.request.UserQueryReq;
import com.zzz.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zyn on 2015/12/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int add(UserQueryReq req) {
        User user  = new User();
        user.setId(UUIDUtil.getUUID());
        user.setUsername(req.getName());
        return userMapper.insert(user);
    }
}
