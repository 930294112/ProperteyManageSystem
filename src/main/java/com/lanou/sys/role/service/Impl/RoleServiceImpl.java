package com.lanou.sys.role.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.sys.role.bean.Role;
import com.lanou.sys.role.mapper.RoleMapper;
import com.lanou.sys.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Resource
    private RoleMapper roleMapper;


    public PageInfo<Role> queryPage(Integer info,Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);
        if(info==0){
            PageHelper.startPage(pageNum,pageSize);
        }
        if (info==1){
            PageHelper.startPage(pageNum,pageSize,"sort desc");
        }
        if (info==2){
            PageHelper.startPage(pageNum,pageSize,"sort asc");
        }
        List<Role> all = roleMapper.findAll();
        System.out.println(all);

        PageInfo<Role> rolePageInfo = new PageInfo<Role>(all);

        return rolePageInfo;
    }

    public boolean deleteTheRole(Integer id) {
        try {
            roleMapper.deleteByRoleId(id);
            roleMapper.deleteForU_RoleId(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //高级搜索
    public PageInfo<Role> GJqueryPage(Role role, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);

        List<Role> all = roleMapper.findAllGJ(role);

        PageInfo<Role> rolePageInfo = new PageInfo<Role>(all);

        return rolePageInfo;
    }

    public boolean datadel(String del) {
        String[] split = del.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                int i1 = Integer.parseInt(split[i]);
                roleMapper.deleteByRoleId(i1);
                roleMapper.deleteForU_RoleId(i1);
            }
        } catch (Exception e) {
            return false;
        }


        return true;
    }

    public List<Role> findAllRole() {
        return roleMapper.findAll();
    }

    public int save(Role role) {
        int sort = roleMapper.findMaxSort() + 1;
        role.setSort(sort);

       return roleMapper.save(role);

    }

}
