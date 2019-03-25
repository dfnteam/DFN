package com.DFN.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        Date date = new Date(d.getTime());
        return date;
    }
    public Timestamp strToTimestamp(String dateString) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date= format.parse(dateString);
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

}
