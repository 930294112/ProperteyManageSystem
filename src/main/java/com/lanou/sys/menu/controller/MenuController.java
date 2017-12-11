package com.lanou.sys.menu.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.menu.bean.Menu;
import com.lanou.sys.menu.service.MenuService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/12/5.
 */
@Controller

public class MenuController {

    @Resource
    private MenuService menuService;
    @Resource
    private RoleService roleService;


    @RequestMapping(value = "/admin-permission")
    public String admin_permission() {
        return "admin/admin-permission";
    }

    //分页 + 查询所有
    @ResponseBody
    @RequestMapping(value = "/pageAllMenu")
    public PageInfo<Menu> pageAllMenu(@RequestParam("info")Integer info, @RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, HttpSession session){
        PageInfo<Menu> pageInfo = null;
        if (info!=6){
          pageInfo = menuService.queryPage(info,pageNum, pageSize);
            session.setAttribute("info",info);

       }else {
           Integer info1 = (Integer) session.getAttribute("info");
            pageInfo = menuService.queryPage(info1,pageNum,pageSize);
        }

        List<Menu> menus = pageInfo.getList();
        List<Menu> list = new ArrayList<Menu>();
        for (Menu menu : menus) {
            if (menu.getParent_id()==0){
                menu.setParent_name("");
                list.add(menu);
            }else {
                int parent_id = menu.getParent_id();
                Menu menuByParent_id = menuService.findMenuByParent_id(parent_id);
                menu.setParent_name(menuByParent_id.getName());
                list.add(menu);
            }
        }
        pageInfo.setList(list);
        return pageInfo;
    }

    @RequestMapping(value = "admin/admin-permission-add")
    public String admin_permission_add(){
        return "admin/admin-permission-add";
    }

    @ResponseBody
    @RequestMapping(value = "/findAllRole")
    public List<Role> findAllRole(){
        List<Role> roles = roleService.findAllRole();
        return roles;
    }

    @ResponseBody
    @RequestMapping(value = "admin/admin-permission-save")
    public AjaxResult<Menu> admin_permission_save(@RequestParam("roleIds[]") Integer[] roleIds,Menu menu){
        System.out.println(roleIds);
        System.out.println(menu);
        AjaxResult<Menu> result = new AjaxResult<Menu>();
        //通过parentName找到id = parent_id
        Menu menuByName = menuService.findMenuByName(menu.getParent_name());
        menu.setParent_id(menuByName.getId());
        menu.setCreate_time(new Timestamp(System.currentTimeMillis()));
        menu.setUpdate_time(new Timestamp(System.currentTimeMillis()));
        menu.setLevel(1);
        menu.setCreate_id(1);
        //得到sort
        int sort = menuService.findMaxSort() + 1;
        menu.setSort(sort);
        int count = menuService.save(menu,roleIds);
        result.setCount(count);
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "admin/admin_permission_del")
    public AjaxResult admin_permission_del(@RequestParam("id") Integer id){
        AjaxResult<Menu> result = new AjaxResult<Menu>();
        int count = menuService.deleteByMenuId(id);
        result.setCount(count);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "admin/datadelMenu")
    public AjaxResult datadelMenu(@RequestParam("deleteIds[]") Integer[] deleteIds ){
        System.out.println(deleteIds);
        AjaxResult<Menu> result = new AjaxResult<Menu>();
        List<Integer> list = menuService.deleteByMenuIds(deleteIds);
        if (list.size() == deleteIds.length){
            result.setCount(1);
        }
        return result;
    }

    @RequestMapping(value = "admin/admin_permission_edie")
    public String admin_permission_edie(@RequestParam("menuid") Integer menuid,HttpSession session){
        Menu menu = menuService.findByMenuId(menuid);
        session.setAttribute("menu",menu);
        return "admin/admin-permission-edit";
    }
    @ResponseBody
    @RequestMapping(value = "/findMenu")
    public AjaxResult<Menu> findMenu(HttpSession session){
        AjaxResult<Menu> result = new AjaxResult<Menu>();
        Map<String,Object> map = new HashMap<String,Object>();
        Menu menu = (Menu) session.getAttribute("menu");
        map.put("menu",menu);
        result.setMap(map);
        List<Role> allRole = roleService.findAllRole();
        result.setRoleList(allRole);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/admin/admin-permission-editSave")
    public AjaxResult<Menu> admin_permission_editSave(@RequestParam("roleIds[]") Integer[] roleIds,Menu menu,HttpSession session){
        Menu menuEdit = (Menu) session.getAttribute("menu");
        AjaxResult<Menu> result = new AjaxResult<Menu>();
        menu.setId(menuEdit.getId());
        menu.setUpdate_time(new Timestamp(System.currentTimeMillis()));
        menu.setUpdate_id(1);
        int count = menuService.editSave(menu,roleIds);
        result.setCount(count);
        return result;
    }

}
