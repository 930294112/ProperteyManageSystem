package com.lanou.sys.menu.bean;

/**
 * Created by dllo on 17/12/8.
 */
public class RoleMenu {
    private int id;
    private int roleid;
    private int menuid;

    public RoleMenu() {
    }

    public RoleMenu(int id, int roleid, int menuid) {
        this.id = id;
        this.roleid = roleid;
        this.menuid = menuid;
    }

    public RoleMenu(int roleid, int menuid) {
        this.roleid = roleid;
        this.menuid = menuid;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }
}
