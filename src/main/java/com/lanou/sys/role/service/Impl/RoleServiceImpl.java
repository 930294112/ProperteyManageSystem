package com.lanou.sys.role.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.sys.menu.bean.Menu;
import com.lanou.sys.menu.bean.RoleMenu;
import com.lanou.sys.menu.mapper.MenuMapper;
import com.lanou.sys.menu.mapper.RoleMenuMapper;
import com.lanou.sys.role.bean.Role;
import com.lanou.sys.role.mapper.RoleMapper;
import com.lanou.sys.role.service.RoleService;
import com.lanou.sys.user.bean.User;
import com.lanou.sys.user.mapper.UserMapper;
import com.lanou.util.Index;
import com.lanou.util.Search;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;


    /**
     * 分页 + 查询所有 + 排序
     * @param info 条件
     * @param pageNum 起始页
     * @param pageSize 条数
     * @return
     */
    public PageInfo<Role> queryPage(Integer info,Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);

        //判断是升序还是降序
        if(info==0){
            PageHelper.startPage(pageNum,pageSize);
        }
        if (info==1){
            PageHelper.startPage(pageNum,pageSize,"sort desc");
        }
        if (info==2){
            PageHelper.startPage(pageNum,pageSize,"sort asc");
        }

        //查询所有的角色
        List<Role> all = roleMapper.findAll();
        for (Role role : all) {
            int create_id = role.getCreate_id();
            User user = userMapper.findUserById(create_id);
            role.setCreate_name(user.getUsername());
        }

        PageInfo<Role> rolePageInfo = new PageInfo<Role>(all);

        return rolePageInfo;
    }

    /**
     * 单个删除 + 批量删除
     * @param id
     * @return
     */
    public boolean deleteTheRole(Integer id) {
        try {
            roleMapper.deleteByRoleId(id);
            roleMenuMapper.deleteByRoleId(id);
           // roleMapper.deleteForU_RoleId(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }


    //高级搜索
    public PageInfo<Role> GJqueryPage(Role role, Integer pageNum, Integer pageSize,HttpSession session) {

        //先调索引 和搜索

        Index index = new Index();
        try {
            index.index();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Search search = new Search();
        search.search(role.getName(),session);


        //根据id查询 再char转为integer
        List roleIds = (List) session.getAttribute("roleId");
        System.out.println("roleIds"+roleIds);

        List<Integer> list1 = new ArrayList<Integer>();


        for (int i = 0; i < roleIds.size(); i++) {
            String s = String.valueOf(roleIds.get(i));
            Integer roleId = Integer.valueOf(s);

            list1.add(roleId);


        }

        //再调分页 变成page 集合
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);

//        List<Role> all = roleMapper.findAllGJ(role);

        List<Role> byRoleIds = roleMapper.findByRoleIds(list1);



        PageInfo<Role> rolePageInfo = new PageInfo<Role>(byRoleIds);

        return rolePageInfo;
    }

    /**
     * 批量删除
     * @param del
     * @return
     */
    public boolean datadel(String del) {
        String[] split = del.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                int i1 = Integer.parseInt(split[i]);
                roleMapper.deleteByRoleId(i1);
                roleMenuMapper.deleteByRoleId(i1);
                //roleMapper.deleteForU_RoleId(i1);
            }
        } catch (Exception e) {
            return false;
        }


        return true;
    }

    public List<Role> findAllRole() {
        return roleMapper.findAll();
    }


    /**
     * 保存
     * @param menuIds
     * @param role
     * @return
     */
    public int save(Integer[]menuIds,Role role) {
        int sort = roleMapper.findMaxSort() + 1;
        role.setSort(sort);
        int count = roleMapper.save(role);

        int roleid = roleMapper.findMaxRoleId();
        List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
        if (menuIds!=null && menuIds.length>0){
            for (int i = 0; i < menuIds.length; i++) {
                RoleMenu roleMenu = new RoleMenu(roleid,menuIds[i]);
                roleMenuList.add(roleMenu);
            }
            roleMenuMapper.saveRoleMenuBath(roleMenuList);
        }

        return count;

    }

    /**
     * 根据id找到角色
     * @param roleid
     * @return
     */
    public Role findRoleById(Integer roleid) {
        Role role = roleMapper.findRoleById(roleid);
        List<RoleMenu> roleMenuByRoleId = roleMenuMapper.findRoleMenuByRoleId(roleid);
        List<Menu> menus = new ArrayList<Menu>();
        for (RoleMenu roleMenu : roleMenuByRoleId) {
            int menuid = roleMenu.getMenuid();
            Menu menu = menuMapper.findMenuById(menuid);
            menus.add(menu);
        }
        role.setMenus(menus);

        return role;
    }

    /**
     * 保存编辑
     * @param menuIds
     * @param role
     * @return
     */
    public int editSave(Integer[] menuIds, Role role) {
        int count = roleMapper.updateRoleById(role);
        roleMenuMapper.deleteByRoleId(role.getId());
        //在增加
        List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
        if (menuIds!=null && menuIds.length>0){
            for (int i = 0; i < menuIds.length; i++) {
                RoleMenu roleMenu = new RoleMenu(role.getId(),menuIds[i]);
                roleMenuList.add(roleMenu);
            }
            roleMenuMapper.saveRoleMenuBath(roleMenuList);
        }
        return count;
    }

}
