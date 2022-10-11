package com.archipin.ludiutils.service;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateService {
    public int getDayDiff(Date from, Date to) {
        return (int) TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS);
    }

    public boolean isSameDay(Date date1, Date date2) {
        if(date1 == null || date2 == null) return false;
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) &&
                calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH) &&
                calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
    }
}
