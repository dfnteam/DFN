package com.DFN.entity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "table_user", schema = "dfn", catalog = "")
public class TableUserEntity {
    private int userId;
    private String userName;
    private String userNickname;
    private String userPassword;
    private int userQq;
    private String userMail;
    private int userType;
    private Integer userFamaliyId;
    private String userOther;
    private String userSex;
    private Timestamp userBirthday;


    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_nickname")
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_QQ")
    public int getUserQq() {
        return userQq;
    }

    public void setUserQq(int userQq) {
        this.userQq = userQq;
    }

    @Basic
    @Column(name = "user_mail")
    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    @Basic
    @Column(name = "user_type")
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "user_famaliy_id")
    public Integer getUserFamaliyId() {
        return userFamaliyId;
    }

    public void setUserFamaliyId(Integer userFamaliyId) {
        this.userFamaliyId = userFamaliyId;
    }

    @Basic
    @Column(name = "user_other")
    public String getUserOther() {
        return userOther;
    }

    public void setUserOther(String userOther) {
        this.userOther = userOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableUserEntity that = (TableUserEntity) o;
        return userId == that.userId &&
                userQq == that.userQq &&
                userType == that.userType &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userNickname, that.userNickname) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(userMail, that.userMail) &&
                Objects.equals(userFamaliyId, that.userFamaliyId) &&
                Objects.equals(userOther, that.userOther);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, userName, userNickname, userPassword, userQq, userMail, userType, userFamaliyId, userOther);
    }

    @Basic
    @Column(name = "user_sex")
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_birthday")
    public Timestamp getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Timestamp userBirthday) {
        this.userBirthday = userBirthday;
    }
}
