package com.lanou.sys.picture.bean;

import java.sql.Timestamp;

/**
 * Created by dllo on 17/12/13.
 */
public class Picture {
    private int id; //图片id
    private  String classify;//图片分类
    private String src;//图片路径
    private String name; //图片名称
    private  String tags;  //标签
    private int state; //状态
    private Timestamp create_time; //创建时间
    private Timestamp endTime; //结束时间
    private Timestamp update_time; //修改时间
    private String author; //作者

    public Picture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Picture(int id, String classify, String src, String name, String tags, int state, Timestamp create_time, Timestamp endTime, Timestamp update_time, String author) {

        this.id = id;
        this.classify = classify;
        this.src = src;
        this.name = name;
        this.tags = tags;
        this.state = state;
        this.create_time = create_time;
        this.endTime = endTime;
        this.update_time = update_time;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", classify='" + classify + '\'' +
                ", src='" + src + '\'' +
                ", name='" + name + '\'' +
                ", tags='" + tags + '\'' +
                ", state=" + state +
                ", create_time=" + create_time +
                ", endTime=" + endTime +
                ", update_time=" + update_time +
                ", author='" + author + '\'' +
                '}';
    }
}
