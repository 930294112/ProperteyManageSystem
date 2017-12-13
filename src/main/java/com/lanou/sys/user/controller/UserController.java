package com.lanou.sys.user.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.menu.bean.Menu;
import com.lanou.sys.menu.service.MenuService;
import com.lanou.sys.role.bean.Role;
import com.lanou.sys.role.service.RoleService;
import com.lanou.sys.user.bean.User;
import com.lanou.sys.user.service.UserService;
import com.lanou.util.AjaxResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;

    @RequestMapping(value = "/admin-list")
    public String admin_permission() {
        return "admin/admin-list";
    }

    //分页 + 查询所有
    @ResponseBody
    @RequestMapping(value = "/pageAllUser")
    public PageInfo<User> pageAllUser( @RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, HttpSession session){
        PageInfo<User> pageInfo = userService.queryPage(pageNum, pageSize);
        return pageInfo;
    }

    @RequestMapping(value = "admin/admin-add")
    public String admin_add(){
        return "/admin/admin-add";
    }

    @ResponseBody
    @RequestMapping(value = "/findAllAdminRole")
    public List<Role> findAllRole(){
        List<Role> roles = roleService.findAllRole();
        return roles;
    }

    @ResponseBody
    @RequestMapping(value = "admin/admin-save")
    public AjaxResult<User> admin_save(User user,String password2){
        AjaxResult<User> result = new AjaxResult<User>();
        if(user.getPassword().equals(password2)){
            String newPassword = new Md5Hash(user.getPassword()).toString();
            user.setPassword(newPassword);
            System.out.println(user);
            user.setState(1);
            user.setCreate_id(1);
            user.setCreate_time(new Timestamp(System.currentTimeMillis()));
            user.setUpdate_time(new Timestamp(System.currentTimeMillis()));
            int count = userService.save(user);
            result.setCount(count);
        }else {
            result.setCount(0);
        }

        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/findAllMenu")
    public List<Menu> findAllMenu(){
        List<Menu> menus = menuService.findAllMenu();
        return menus;
    }

    @ResponseBody
    @RequestMapping(value = "/admin_changeState")
    public AjaxResult<User> admin_changeState(User user){
        AjaxResult<User> result = new AjaxResult<User>();
        user.setUpdate_time(new Timestamp(System.currentTimeMillis()));
        int count = userService.changeState(user);
        result.setCount(count);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "admin/admin_del")
    public AjaxResult<User> admin_del(@RequestParam("id") Integer id){
        AjaxResult<User> result = new AjaxResult<User>();
        int count = userService.deleteById(id);
        result.setCount(count);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/databath")
    public AjaxResult<User> databath(@RequestParam("deleteIds[]") Integer[] deleteIds ){
        AjaxResult<User> result = new AjaxResult<User>();
        List<Integer> list = userService.deleteByIds(deleteIds);
        if (list.size() == deleteIds.length){
            result.setCount(1);
        }
        return result;
    }

}
