package com.lanou.sys.role.bean;

import com.lanou.sys.menu.bean.Menu;
import com.lanou.sys.user.bean.User;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */
public class Role {


    private int create_id;
    private Timestamp create_time;
    private int id;
    private String name;
    private String remark;
    private int sort;
    private int status; //状态//radio/2,隐藏,1,显示
    private int update_id;
    private Timestamp update_time;

   // private User user;

    private String create_name;//创建者名字

    private List<Menu> menus;//角色下的菜单

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getCreate_name() {
        return create_name;
    }

    public void setCreate_name(String create_name) {
        this.create_name = create_name;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Role() {
    }

    public Role(int create_id, Timestamp create_time, int id, String name, String remark, int sort, int status, int update_id, Timestamp update_time) {
        this.create_id = create_id;
        this.create_time = create_time;
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.sort = sort;
        this.status = status;
        this.update_id = update_id;
        this.update_time = update_time;
    }


    @Override
    public String toString() {
        return "Role{" +
                "create_id=" + create_id +
                ", create_time=" + create_time +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", sort=" + sort +
                ", status=" + status +
                ", update_id=" + update_id +
                ", update_time=" + update_time +
                '}';
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }


}
