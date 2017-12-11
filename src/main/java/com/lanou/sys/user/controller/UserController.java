package com.lanou.sys.user.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.user.bean.User;
import com.lanou.sys.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/admin-list")
    public String admin_permission() {
        return "admin/admin-list";
    }

    //分页 + 查询所有
    @ResponseBody
    @RequestMapping(value = "/pageAllUser")
    public PageInfo<User> pageAllUser( @RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, HttpSession session){
        System.out.println(111);
        PageInfo<User> pageInfo = userService.queryPage(pageNum, pageSize);
        System.out.println(pageInfo);
        return pageInfo;
    }

}
