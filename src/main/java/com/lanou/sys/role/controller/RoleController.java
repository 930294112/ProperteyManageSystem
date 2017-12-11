package com.lanou.sys.role.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.role.bean.Role;
import com.lanou.sys.role.service.RoleService;
import com.lanou.util.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * Created by dllo on 17/12/5.
 */
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/admin-role")
    public String admin_role() {
        return "admin/admin-role";
    }

    //分页 +高级查询
    @ResponseBody
    @RequestMapping(value = "/pageAll")
    public PageInfo<Role> pageAll(Role role, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, HttpSession session) {
        PageInfo<Role> roleGJ = null;

        if (!role.getName().equals("5")) {
            session.setAttribute("role", role);
            roleGJ = roleService.GJqueryPage(role, pageNum, pageSize);
        } else {
            Role role1 = (Role) session.getAttribute("role");
            roleGJ = roleService.GJqueryPage(role1, pageNum, pageSize);
        }
        return roleGJ;
    }

    //分页+普通查询 findpageAll
    @ResponseBody
    @RequestMapping(value = "/findpageAll")
    public PageInfo<Role> pageAll(@RequestParam("info") Integer info,@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,HttpSession session) {
        PageInfo<Role> pageInfo = null;
        if (info!=6){
            pageInfo = roleService.queryPage(info,pageNum, pageSize);
            session.setAttribute("info",info);

        }else {
            Integer info1 = (Integer) session.getAttribute("info");
            pageInfo = roleService.queryPage(info1,pageNum,pageSize);
        }

        return pageInfo;
    }


    //角色添加
    @RequestMapping(value = "admin/admin-role-add")
    public String add() {
        return "admin/admin-role-add";
    }

    @ResponseBody
    @RequestMapping(value = "admin/admin-role-save")
    public AjaxResult<Role> admin_role_save(Role role) {
        AjaxResult<Role> result = new AjaxResult<Role>();
        System.out.println(role);
        role.setCreate_time(new Timestamp(System.currentTimeMillis()));
        role.setUpdate_time(new Timestamp(System.currentTimeMillis()));
        role.setCreate_id(1);
        int count = roleService.save(role);
        result.setCount(count);
        return result;
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "admin/deleteTheRole")
    public boolean deleteTheRole(@RequestParam("id") Integer id) {
        return roleService.deleteTheRole(id);
    }


    //批量删除
    @ResponseBody
    @RequestMapping(value = "admin/datadel")
    public boolean del(@RequestParam("del") String del) {
//          1,2,3
        System.out.println("del=======>" + del);
        return roleService.datadel(del);

    }


}
