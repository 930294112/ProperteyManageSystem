package com.lanou.sys.user.service;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.user.bean.User;

/**
 * Created by dllo on 17/12/6.
 */
public interface UserService {
    PageInfo<User> queryPage(Integer pageNum, Integer pageSize);
}
