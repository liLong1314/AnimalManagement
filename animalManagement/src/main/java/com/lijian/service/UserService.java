package com.lijian.service;

import com.github.pagehelper.PageInfo;
import com.lijian.entity.User;

import java.util.List;

/**
 * @Author lijia
 * @createTime 2023/5/22 21:14
 */
public interface UserService {
    List<User> findByName(String userName, Integer state);
    List<User> showName(String userName);
    //登录
    User loginuser(String userName,String password);
    //注册
    int add(User user);
    //修改
    Integer update(User user);
    User findById(Integer id);
    PageInfo<User> allUser(String userName, Integer pageNum, Integer pageSize);
    int del(Integer id);
}
