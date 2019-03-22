package com.DFN.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "table_bill", schema = "dfn", catalog = "")
public class TableBillEntity {
    private int billId;
    private String billGoods;
    private int billPrice;
    private Timestamp billDate;
    private String billOther;

    @Id
    @Column(name = "bill_id")
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    @Basic
    @Column(name = "bill_goods")
    public String getBillGoods() {
        return billGoods;
    }

    public void setBillGoods(String billGoods) {
        this.billGoods = billGoods;
    }

    @Basic
    @Column(name = "bill_price")
    public int getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(int billPrice) {
        this.billPrice = billPrice;
    }

    @Basic
    @Column(name = "bill_date")
    public Timestamp getBillDate() {
        return billDate;
    }

    public void setBillDate(Timestamp billDate) {
        this.billDate = billDate;
    }

    @Basic
    @Column(name = "bill_other")
    public String getBillOther() {
        return billOther;
    }

    public void setBillOther(String billOther) {
        this.billOther = billOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableBillEntity that = (TableBillEntity) o;
        return billId == that.billId &&
                billPrice == that.billPrice &&
                Objects.equals(billGoods, that.billGoods) &&
                Objects.equals(billDate, that.billDate) &&
                Objects.equals(billOther, that.billOther);
    }

    @Override
    public int hashCode() {

        return Objects.hash(billId, billGoods, billPrice, billDate, billOther);
    }
}
