package com.zxiaofan.model;

import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by xiaofan on 2017/5/6.
 */
public class UserBo {
    /**
     * id
     */
    private int id;
    /**
     * userName
     */
    private String userName;
    /**
     * age
     */
    private int age;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 修改时间
     */
    private Timestamp modifyTime;

    public UserBo() {
    }

    public UserBo(int age, String userName, Date addTime) {
        this.age = age;
        this.userName = userName;
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "UserBo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", addTime=" + addTime +
                ", modifyTime=" + modifyTime +
                ", isDelete=" + isDelete +
                '}';
    }

    /**
     * 是否被删除
     */
    private int isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
