package com.lanou.sys.user.bean;

import java.sql.Timestamp;

/**
 * Created by dllo on 17/12/6.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String realname;
    private int role_id;
    private int usertype;
    private int state;
    private String third_id;
    private Timestamp end_time;
    private String email;
    private String tel;
    private String address;
    private String title_url;
    private String remark;
    private String theme;
    private int back_site_id;
    private int create_site_id;
    private Timestamp create_time;
    private int create_id;


    public User() {
    }

    public User(int id, String username, String password, String realname, int role_id, int usertype, int state, String third_id, Timestamp end_time, String email, String tel, String address, String title_url, String remark, String theme, int back_site_id, int create_site_id, Timestamp create_time, int create_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.role_id = role_id;
        this.usertype = usertype;
        this.state = state;
        this.third_id = third_id;
        this.end_time = end_time;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.title_url = title_url;
        this.remark = remark;
        this.theme = theme;
        this.back_site_id = back_site_id;
        this.create_site_id = create_site_id;
        this.create_time = create_time;
        this.create_id = create_id;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", role_id=" + role_id +
                ", usertype=" + usertype +
                ", state=" + state +
                ", third_id='" + third_id + '\'' +
                ", end_time=" + end_time +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", title_url='" + title_url + '\'' +
                ", remark='" + remark + '\'' +
                ", theme='" + theme + '\'' +
                ", back_site_id=" + back_site_id +
                ", create_site_id=" + create_site_id +
                ", create_time=" + create_time +
                ", create_id=" + create_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getThird_id() {
        return third_id;
    }

    public void setThird_id(String third_id) {
        this.third_id = third_id;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle_url() {
        return title_url;
    }

    public void setTitle_url(String title_url) {
        this.title_url = title_url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getBack_site_id() {
        return back_site_id;
    }

    public void setBack_site_id(int back_site_id) {
        this.back_site_id = back_site_id;
    }

    public int getCreate_site_id() {
        return create_site_id;
    }

    public void setCreate_site_id(int create_site_id) {
        this.create_site_id = create_site_id;
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
}
