package com.lanou.sys.user.mapper;

import com.lanou.sys.user.bean.User;

import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
public interface UserMapper {


    User selectById(Integer id);

    List<User> findAll();

    int save(User user);

    User findUserById(int create_id);

    User findUserByName(String username);

    int changeState(User user);

    int deleteById(Integer id);
}
