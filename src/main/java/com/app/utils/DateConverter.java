package com.app.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class DateConverter {

    private static final String MAIN_DATE_FORMAT="yyyy-MM-dd'T'hh:mm:ss.SSS'Z'";
    private static final String DATE_FORMAT1="yyyyMMdd";

    public Calendar convertDateToGregorian(Date date){
        SimpleDateFormat formatter=new SimpleDateFormat(MAIN_DATE_FORMAT);
        try{
            Date formatedDate =formatter.parse(String.valueOf(date));
            //convert date date to calendar
            Calendar calendar= GregorianCalendar.getInstance();
            calendar.setTime(date);
            System.out.println(calendar);
            return calendar;
        }
        catch(ParseException e){
            return null;
        }
    }

}
