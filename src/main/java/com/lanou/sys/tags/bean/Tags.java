package com.lanou.sys.tags.bean;

import java.sql.Timestamp;

/**
 * Created by dllo on 17/12/14.
 */
public class Tags {
    private int id;
    private int article_id;
    private String tagname; //标签名字
    private Timestamp update_time;
    private Timestamp create_time;
    private int update_id;
    private int create_id;

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", tagname='" + tagname + '\'' +
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

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
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

    public Tags(int id, int article_id, String tagname, Timestamp update_time, Timestamp create_time, int update_id, int create_id) {

        this.id = id;
        this.article_id = article_id;
        this.tagname = tagname;
        this.update_time = update_time;
        this.create_time = create_time;
        this.update_id = update_id;
        this.create_id = create_id;
    }

    public Tags() {

    }
}
