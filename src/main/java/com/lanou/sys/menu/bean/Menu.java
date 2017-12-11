package com.lanou.sys.menu.bean;
import com.lanou.sys.role.bean.Role;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */
public class Menu {
    private int id;
    private int parent_id; //父id
    private String icon; //图标
    private String name; //名称
    private String urlkey; //权限名称
    private String url; //链接地址
    private int status; //状态//radio/2,隐藏,1,显示
    private int type; //类型//select/1,根目录,2,a标签,3,a标签_blank,4,外部url
    private int sort; //排序
    private int level; //级别
    private Timestamp create_time; //创建时间
    private int create_id; //创建者id
    private Timestamp update_time; //更新时间
    private int update_id; //更新人id

    private Role role; //菜单下的角色


    private List<Role> roles;

    private String parent_name; //父名字
    private String create_name;//创建者名字

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getCreate_name() {

        return create_name;
    }

    public void setCreate_name(String create_name) {
        this.create_name = create_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu() {
    }

    public Menu(int id, int parent_id, String icon, String name, String urlkey, String url, int status, int type, int sort, int level, Timestamp create_time, int create_id, Timestamp update_time, int update_id) {
        this.id = id;
        this.parent_id = parent_id;
        this.icon = icon;
        this.name = name;
        this.urlkey = urlkey;
        this.url = url;
        this.status = status;
        this.type = type;
        this.sort = sort;
        this.level = level;
        this.create_time = create_time;
        this.create_id = create_id;
        this.update_time = update_time;
        this.update_id = update_id;
    }

    public Menu(int parent_id, String name, String url, int status, int type, int sort, int level, Timestamp create_time, int create_id) {
        this.parent_id = parent_id;
        this.name = name;
        this.url = url;
        this.status = status;
        this.type = type;
        this.sort = sort;
        this.level = level;
        this.create_time = create_time;
        this.create_id = create_id;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", urlkey='" + urlkey + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", sort=" + sort +
                ", level=" + level +
                ", create_time=" + create_time +
                ", create_id=" + create_id +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlkey() {
        return urlkey;
    }

    public void setUrlkey(String urlkey) {
        this.urlkey = urlkey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
