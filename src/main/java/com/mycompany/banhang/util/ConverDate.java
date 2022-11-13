/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author vinhnv
 */
public class ConverDate {

    public Date conver(String sDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
        return date;
    }

    public long dateToLong(String date, String fomat) {
        long milliseconds = -1;
        SimpleDateFormat f = new SimpleDateFormat(fomat);
        f.setTimeZone(TimeZone.getDefault());
        try {
            Date d = f.parse(date);
            milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return milliseconds;
    }

    public String longToDate(long data, String format) {
        Date date = new Date(data);
        SimpleDateFormat df2 = new SimpleDateFormat(format);
        return df2.format(date);
    }

    public static void main(String[] args) throws ParseException {
        String sDate = "2017/07/17";
        long date = new ConverDate().dateToLong(sDate, "yyyy/MM/dd");
        System.out.println(date);
        System.out.println(new ConverDate().longToDate(date, "yyyy/MM/dd"));
    }
}
