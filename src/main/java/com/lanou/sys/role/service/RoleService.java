package com.lanou.sys.role.service;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.role.bean.Role;

import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */
public interface RoleService {
    PageInfo<Role> queryPage(Integer info,Integer pageNum, Integer pageSize);

    boolean deleteTheRole(Integer id);

    PageInfo<Role> GJqueryPage(Role role, Integer pageNum, Integer pageSize);

    boolean datadel(String del);


    List<Role> findAllRole();


    int save(Integer[] menuIds, Role role);

    Role findRoleById(Integer roleid);

    int editSave(Integer[] menuIds, Role role);
}
