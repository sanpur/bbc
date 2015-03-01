package com.gumtree.addressbook.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date getDateFromString(String dateInString) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
