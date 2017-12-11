package com.lanou.sys.menu.mapper;

import com.lanou.sys.menu.bean.RoleMenu;

import java.util.List;

/**
 * Created by dllo on 17/12/8.
 */
public interface RoleMenuMapper {
    int saveRoleMenuBath(List<RoleMenu> roleMenuList);

    int deleteByMenuId(Integer id);

    List<RoleMenu> findRoleMenuByMenuId(Integer menuid);
}
