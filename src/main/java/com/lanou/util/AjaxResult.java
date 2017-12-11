package com.lanou.util;

import com.lanou.sys.role.bean.Role;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/12/7.
 */
public class AjaxResult<T> {
    private int count;
    private List<T> tList;
    private Map<String,Object> map;
    private List<Role> roleList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;


    }
}
