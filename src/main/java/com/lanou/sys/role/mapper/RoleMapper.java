package com.lanou.sys.role.mapper;

import com.lanou.sys.role.bean.Role;

import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */

public interface RoleMapper {


    List<Role> findAll();

    int deleteByRoleId(Integer id);

    //int deleteForU_RoleId(Integer id);

    List<Role> findAllGJ(Role role);

    Role findRoleById(int roleid);

    int findMaxSort();

    int save(Role role);

    int findMaxRoleId();

    int updateRoleById(Role role);
}
