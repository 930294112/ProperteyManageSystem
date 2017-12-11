package com.lanou.sys.menu.service;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.menu.bean.Menu;
import com.lanou.sys.user.bean.User;

import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */
public interface MenuService {
    PageInfo<Menu> queryPage(Integer info,Integer pageNum, Integer pageSize);

    Menu findMenuByParent_id(int parent_id);

    Menu findMenuByName(String name);

    int findMaxSort();


    int save(Menu menu, Integer[] roleIds);

    int deleteByMenuId(Integer id);

   List<Integer> deleteByMenuIds(Integer[] deleteIds);

    Menu findByMenuId(Integer menuid);

    int editSave(Menu menu, Integer[] roleIds);
}
