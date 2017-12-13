package com.lanou.sys.user.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.sys.user.bean.User;
import com.lanou.sys.user.mapper.UserMapper;
import com.lanou.sys.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    public int save(User user) {
        return userMapper.save(user);
    }

    public int changeState(User user) {
        int state = user.getState();
        if (state==1){
            user.setState(2);
        }else {
            user.setState(1);
        }
        return userMapper.changeState(user);
    }

    public int deleteById(Integer id) {
       return userMapper.deleteById(id);

    }

    public List<Integer> deleteByIds(Integer[] deleteIds) {
        int count = 0;
        List <Integer> list = new ArrayList<Integer>();
        for (Integer deleteId : deleteIds) {
            count = userMapper.deleteById(deleteId);
            if (count>0){
                list.add(count);
            }
        }
        return list;

    }
}
