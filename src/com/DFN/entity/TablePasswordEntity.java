package com.DFN.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "table_password", schema = "dfn", catalog = "")
public class TablePasswordEntity {
    private int passwordId;
    private String passwordName;
    private String passwordContent;
    private String passwordOther;

    @Id
    @Column(name = "password_id")
    public int getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(int passwordId) {
        this.passwordId = passwordId;
    }

    @Basic
    @Column(name = "password_name")
    public String getPasswordName() {
        return passwordName;
    }

    public void setPasswordName(String passwordName) {
        this.passwordName = passwordName;
    }

    @Basic
    @Column(name = "password_content")
    public String getPasswordContent() {
        return passwordContent;
    }

    public void setPasswordContent(String passwordContent) {
        this.passwordContent = passwordContent;
    }

    @Basic
    @Column(name = "password_other")
    public String getPasswordOther() {
        return passwordOther;
    }

    public void setPasswordOther(String passwordOther) {
        this.passwordOther = passwordOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablePasswordEntity that = (TablePasswordEntity) o;
        return passwordId == that.passwordId &&
                Objects.equals(passwordName, that.passwordName) &&
                Objects.equals(passwordContent, that.passwordContent) &&
                Objects.equals(passwordOther, that.passwordOther);
    }

    @Override
    public int hashCode() {

        return Objects.hash(passwordId, passwordName, passwordContent, passwordOther);
    }
}
