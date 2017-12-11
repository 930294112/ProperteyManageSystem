package com.lanou.sys.user.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.sys.user.bean.User;
import com.lanou.sys.user.mapper.UserMapper;
import com.lanou.sys.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    public PageInfo<User> queryPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;


    }
}
