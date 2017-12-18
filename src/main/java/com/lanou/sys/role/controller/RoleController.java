package com.lanou.sys.role.controller;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/12/5.
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Resource
    private RoleService roleService;
    @Resource
    private MenuService menuService;

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
    public PageInfo<Role> pageAll(@RequestParam("info")Integer info,@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,HttpSession session) {
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
    @RequestMapping(value = "/admin-role-add")
    public String add() {
        return "admin/admin-role-add";
    }

    @ResponseBody
    @RequestMapping(value = "/admin-role-save")
    public AjaxResult<Role> admin_role_save(@RequestParam("menuIds[]") Integer[] menuIds,Role role) {
        AjaxResult<Role> result = new AjaxResult<Role>();
        role.setCreate_time(new Timestamp(System.currentTimeMillis()));
        role.setUpdate_time(new Timestamp(System.currentTimeMillis()));
        role.setCreate_id(1);
        int count = roleService.save(menuIds,role);
        result.setCount(count);
        return result;
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/deleteTheRole")
    public boolean deleteTheRole(@RequestParam("id") Integer id) {
        return roleService.deleteTheRole(id);
    }


    //批量删除
    @ResponseBody
    @RequestMapping(value = "/datadel")
    public boolean del(@RequestParam("del") String del) {
//          1,2,3
        System.out.println("del=======>" + del);
        return roleService.datadel(del);

    }

    //调到编辑的页面
    @RequestMapping(value = "/admin-role-edit")
    public String admin_role_edit(@RequestParam("roleid") Integer roleid,HttpSession session){
        Role role = roleService.findRoleById(roleid);
        System.out.println(role.getMenus());
        session.setAttribute("role",role);
        return "admin/admin-role-edit";
    }

    /**
     * 编辑前表单回显
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findEditRole")
    public AjaxResult<Role> findEditRole(HttpSession session){
        AjaxResult<Role> result = new AjaxResult<Role>();
        Map<String,Object> map = new HashMap<String,Object>();
        Role role = (Role) session.getAttribute("role");
        map.put("role",role);
        result.setMap(map);
        List<Menu> allMenu = menuService.findAllMenu();
        result.setMenuList(allMenu);
        return result;

    }

    /**
     * 查询所有的菜单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findAllMenu")
    public List<Menu> findAllMenu(){
        List<Menu> menus = menuService.findAllMenu();
        return menus;
    }

    /**
     * 编辑保存
     * @param menuIds 编辑的id
     * @param role
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin-role-editSave")
    public AjaxResult<Role> admin_role_editSave(@RequestParam("menuIds[]") Integer[] menuIds,Role role,HttpSession session){
        AjaxResult<Role> result = new AjaxResult<Role>();
        Role editRole = (Role) session.getAttribute("role");
        role.setId(editRole.getId());
        role.setUpdate_time(new Timestamp(System.currentTimeMillis()));
        int count = roleService.editSave(menuIds, role);
        result.setCount(count);
        return result;
    }


}
