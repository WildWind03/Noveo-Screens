package com.noveogroup.screens.utils;

import android.widget.DatePicker;

import com.noveogroup.screens.models.MyDate;

import org.joda.time.DateTime;
import org.joda.time.Years;

import java.util.Date;

public class DateUtil {

    private DateUtil() {

    }

    public static MyDate getDate(DatePicker datePicker) {
        return new MyDate(datePicker.getDayOfMonth(), datePicker.getMonth() + 1, datePicker.getYear());
    }

    public static int getAge(MyDate date1) {
        DateTime dateTime1 = new DateTime(date1.getYear(), date1.getMonth(), date1.getDay(), 0, 0);
        DateTime dateTime2 = DateTime.now();
        return Years.yearsBetween(dateTime1, dateTime2).getYears();
    }

    public static long getCurrentTimeInMillis() {
        return DateTime.now().getMillis();
    }
}
