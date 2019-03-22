package com.DFN.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "table_wish", schema = "dfn", catalog = "")
public class TableWishEntity {
    private int wishId;
    private String wishName;
    private int wishPublic;
    private int wishState;
    private String wishOther;

    @Id
    @Column(name = "wish_id")
    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    @Basic
    @Column(name = "wish_name")
    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    @Basic
    @Column(name = "wish_public")
    public int getWishPublic() {
        return wishPublic;
    }

    public void setWishPublic(int wishPublic) {
        this.wishPublic = wishPublic;
    }

    @Basic
    @Column(name = "wish_state")
    public int getWishState() {
        return wishState;
    }

    public void setWishState(int wishState) {
        this.wishState = wishState;
    }

    @Basic
    @Column(name = "wish_other")
    public String getWishOther() {
        return wishOther;
    }

    public void setWishOther(String wishOther) {
        this.wishOther = wishOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableWishEntity that = (TableWishEntity) o;
        return wishId == that.wishId &&
                wishPublic == that.wishPublic &&
                wishState == that.wishState &&
                Objects.equals(wishName, that.wishName) &&
                Objects.equals(wishOther, that.wishOther);
    }

    @Override
    public int hashCode() {

        return Objects.hash(wishId, wishName, wishPublic, wishState, wishOther);
    }
}
