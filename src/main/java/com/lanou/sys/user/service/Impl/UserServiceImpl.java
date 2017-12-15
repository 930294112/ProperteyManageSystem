package com.lanou.sys.user.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.sys.user.bean.User;
import com.lanou.sys.user.bean.ext.ExtUser;
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

    /**
     * 分页 + 高级查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<User> queryPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;


    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    public int save(User user) {
        return userMapper.save(user);
    }

    /**
     * 更改状态
     * @param user
     * @return
     */
    public int changeState(User user) {
        int state = user.getState();
        if (state==1){
            user.setState(2);
        }else {
            user.setState(1);
        }
        return userMapper.changeState(user);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public int deleteById(Integer id) {
       return userMapper.deleteById(id);

    }

    /**
     * 根据id批量删除
     * @param deleteIds
     * @return
     */
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

    /**
     * 高级查询 + 分页
     * @param extUser
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<User> fuzzyQueryPage(ExtUser extUser, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<User> all = userMapper.fuzzyFindAll(extUser);

        PageInfo<User> rolePageInfo = new PageInfo<User>(all);

        return rolePageInfo;

    }
}
