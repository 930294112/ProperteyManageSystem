package com.lanou.sys.menu.mapper;

import com.lanou.sys.menu.bean.Menu;

import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */
public interface MenuMapper {
    List<Menu> findAll();

    Menu findMenuByParent_id(int parent_id);

    Menu findMenuByName(String name);

    int findMaxSort();

    int save(Menu menu);

    int findMaxId();

    int deleteByMenuId(Integer id);

    Menu findMenuById(Integer menuid);

    int updateMenuById(Menu menu);

    List<Menu> findAllMenu();

    List<Menu> findMenuByQuery(Menu menu);
}
