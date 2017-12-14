package com.lanou.sys.album.bean;

import java.sql.Timestamp;

/**
 * Created by dllo on 17/12/14.
 */
public class Album {
    private int id;
    private int parent_id;
    private String name;
    private String remark;
    private int sort;
    private int status;
    private Timestamp update_time;
    private Timestamp create_time;
    private int update_id;
    private int create_id;

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", sort=" + sort +
                ", status=" + status +
                ", update_time=" + update_time +
                ", create_time=" + create_time +
                ", update_id=" + update_id +
                ", create_id=" + create_id +
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

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public int getCreate_id() {

        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public Album(int id, int parent_id, String name, String remark, int sort, int status, Timestamp update_time, Timestamp create_time, int update_id, int create_id) {

        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
        this.remark = remark;
        this.sort = sort;
        this.status = status;
        this.update_time = update_time;
        this.create_time = create_time;
        this.update_id = update_id;
        this.create_id = create_id;
    }

    public Album() {

    }
}
