package com.DFN.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class StrToDate {

    public Date strToDate(String dateString) throws ParseException {

        String str = dateString;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }

}
