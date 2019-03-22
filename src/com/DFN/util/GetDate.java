package com.DFN.util;

import java.sql.Timestamp;

public class GetDate {

    public Timestamp getDate() {
        java.util.Date date = new java.util.Date();
        Timestamp createDate = new Timestamp(date.getTime());
        return createDate;
    }

}
