package com.DFN.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "table_famaliy", schema = "dfn", catalog = "")
public class TableFamaliyEntity {
    private int famaliyId;
    private String famaliyName;
    private String famaliyInfo;
    private String famaliyOther;

    @Id
    @Column(name = "famaliy_id")
    public int getFamaliyId() {
        return famaliyId;
    }

    public void setFamaliyId(int famaliyId) {
        this.famaliyId = famaliyId;
    }

    @Basic
    @Column(name = "famaliy_name")
    public String getFamaliyName() {
        return famaliyName;
    }

    public void setFamaliyName(String famaliyName) {
        this.famaliyName = famaliyName;
    }

    @Basic
    @Column(name = "famaliy_info")
    public String getFamaliyInfo() {
        return famaliyInfo;
    }

    public void setFamaliyInfo(String famaliyInfo) {
        this.famaliyInfo = famaliyInfo;
    }

    @Basic
    @Column(name = "famaliy_other")
    public String getFamaliyOther() {
        return famaliyOther;
    }

    public void setFamaliyOther(String famaliyOther) {
        this.famaliyOther = famaliyOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableFamaliyEntity that = (TableFamaliyEntity) o;
        return famaliyId == that.famaliyId &&
                Objects.equals(famaliyName, that.famaliyName) &&
                Objects.equals(famaliyInfo, that.famaliyInfo) &&
                Objects.equals(famaliyOther, that.famaliyOther);
    }

    @Override
    public int hashCode() {

        return Objects.hash(famaliyId, famaliyName, famaliyInfo, famaliyOther);
    }
}
