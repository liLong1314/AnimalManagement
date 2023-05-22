package com.lijian.service.impl;

import com.github.pagehelper.PageInfo;
import com.lijian.entity.User;
import com.lijian.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lijia
 * @createTime 2023/5/22 21:16
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findByName(String userName, Integer state) {

        return null;
    }

    @Override
    public List<User> showName(String userName) {
        return null;
    }

    @Override
    public User loginuser(String userName, String password) {
        return null;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public Integer update(User user) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public PageInfo<User> allUser(String userName, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public int del(Integer id) {
        return 0;
    }
}
