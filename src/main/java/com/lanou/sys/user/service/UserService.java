package com.lanou.sys.user.service;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.role.mapper.RoleMapper;
import com.lanou.sys.user.bean.User;

import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
public interface UserService {
    PageInfo<User> queryPage(Integer pageNum, Integer pageSize);

    int save(User user);

    int changeState(User user);

    int deleteById(Integer id);

    List<Integer> deleteByIds(Integer[] deleteIds);
}
