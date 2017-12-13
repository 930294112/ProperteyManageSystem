package com.lanou.sys.menu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.sys.menu.bean.Menu;
import com.lanou.sys.menu.bean.RoleMenu;
import com.lanou.sys.menu.mapper.MenuMapper;
import com.lanou.sys.menu.mapper.RoleMenuMapper;
import com.lanou.sys.menu.service.MenuService;
import com.lanou.sys.role.bean.Role;
import com.lanou.sys.role.mapper.RoleMapper;
import com.lanou.sys.user.bean.User;
import com.lanou.sys.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService{
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserMapper userMapper;
    private int count;

    public PageInfo<Menu> queryPage(Integer info,Integer pageNum, Integer pageSize) {
        pageNum = pageNum ==null ? 1 : pageNum;
        pageSize = pageSize ==null ? 3: pageSize;
        if(info==0){
            PageHelper.startPage(pageNum,pageSize);
        }
        if (info==1){
            PageHelper.startPage(pageNum,pageSize,"sort desc");
        }
        if (info==2){
            PageHelper.startPage(pageNum,pageSize,"sort asc");
        }
        List<Menu> menus = menuMapper.findAll();
        //找到创建人
        for (Menu menu : menus) {
            int create_id = menu.getCreate_id();
            User user = userMapper.findUserById(create_id);
           menu.setCreate_name(user.getUsername());
        }
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(menus);
        return pageInfo;
    }

    public Menu findMenuByParent_id(int parent_id) {
        return menuMapper.findMenuByParent_id(parent_id);

    }

    public Menu findMenuByName(String name) {
       return menuMapper.findMenuByName(name);

    }

    public int findMaxSort() {
        return menuMapper.findMaxSort();
    }

    public int save(Menu menu) {
        int count = menuMapper.save(menu);
       // int menuid = menuMapper.findMaxId();

//        List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
//        if (roleIds!=null && roleIds.length>0){
//            for (int i = 0; i < roleIds.length; i++) {
//                RoleMenu roleMenu = new RoleMenu(roleIds[i],menuid);
//                roleMenuList.add(roleMenu);
//            }
//            roleMenuMapper.saveRoleMenuBath(roleMenuList);
//        }
        return count;
    }

    public int deleteByMenuId(Integer id) {
        roleMenuMapper.deleteByMenuId(id);
       return menuMapper.deleteByMenuId(id);

    }

    public List<Integer> deleteByMenuIds(Integer[] deleteIds) {
        int count = 0;
       List <Integer> list = new ArrayList<Integer>();
        for (Integer deleteId : deleteIds) {
            roleMenuMapper.deleteByMenuId(deleteId);
            count = menuMapper.deleteByMenuId(deleteId);
            if (count>0){

                list.add(count);
            }
        }
        return list;


    }

    public Menu findByMenuId(Integer menuid) {
        Menu menu = menuMapper.findMenuById(menuid);
        Menu menuByParent_id = menuMapper.findMenuByParent_id(menu.getParent_id());
        menu.setParent_name(menuByParent_id.getName());

//        List<RoleMenu> roleMenuByMenuId = roleMenuMapper.findRoleMenuByMenuId(menuid);
//        List<Role> roles = new ArrayList<Role>();
//        for (RoleMenu roleMenu : roleMenuByMenuId) {
//            int roleid = roleMenu.getRoleid();
//            Role role = roleMapper.findRoleById(roleid);
//            roles.add(role);
//        }
//        menu.setRoles(roles);
        return menu;
    }

    public int editSave(Menu menu) {
        int count = menuMapper.updateMenuById(menu);
//        //先删除menuId对应的角色
//        roleMenuMapper.deleteByMenuId(menu.getId());
//        //在增加
//        List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
//        if (roleIds!=null && roleIds.length>0){
//            for (int i = 0; i < roleIds.length; i++) {
//                RoleMenu roleMenu = new RoleMenu(roleIds[i],menu.getId());
//                roleMenuList.add(roleMenu);
//            }
//            roleMenuMapper.saveRoleMenuBath(roleMenuList);
//        }
        return count;
    }

    public List<Menu> findAllMenu() {
       return menuMapper.findAllMenu();
    }

    public PageInfo<Menu> pageMenuQuery(Menu menu, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);

        List<Menu> menus= menuMapper.findMenuByQuery(menu);
        for (Menu menu1: menus) {
            int create_id = menu1.getCreate_id();
            User user = userMapper.findUserById(create_id);
            menu.setCreate_name(user.getUsername());
        }
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(menus);

        return pageInfo;
    }
}
