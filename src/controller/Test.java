package controller;

import util.DateUtil;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String []args){
//        DateUtil dateUtil = new DateUtil();
        Date date = new Date();
        SimpleDateFormat adf = new SimpleDateFormat("dd-MM-yyyy HH:mm::SS");
        System.out.println(adf.format(date));

       /* String date = "2018-2-11";
        String time = "14:20:15";
        try {
            Date date1 = DateUtil.stringToUdate(date);
            Time time1 = DateUtil.stringToTime(time);
            System.out.println(date1);
            System.out.println(time1);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }
}
