package com.DFN.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "table_share", schema = "dfn", catalog = "")
public class TableShareEntity {
    private int shareId;
    private String shareName;
    private String shareContent;
    private Timestamp shareDate;
    private String shareOther;

    @Id
    @Column(name = "share_id")
    public int getShareId() {
        return shareId;
    }

    public void setShareId(int shareId) {
        this.shareId = shareId;
    }

    @Basic
    @Column(name = "share_name")
    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    @Basic
    @Column(name = "share_content")
    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    @Basic
    @Column(name = "share_date")
    public Timestamp getShareDate() {
        return shareDate;
    }

    public void setShareDate(Timestamp shareDate) {
        this.shareDate = shareDate;
    }

    @Basic
    @Column(name = "share_other")
    public String getShareOther() {
        return shareOther;
    }

    public void setShareOther(String shareOther) {
        this.shareOther = shareOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableShareEntity that = (TableShareEntity) o;
        return shareId == that.shareId &&
                Objects.equals(shareName, that.shareName) &&
                Objects.equals(shareContent, that.shareContent) &&
                Objects.equals(shareDate, that.shareDate) &&
                Objects.equals(shareOther, that.shareOther);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shareId, shareName, shareContent, shareDate, shareOther);
    }
}
