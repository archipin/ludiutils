package com.archipin.ludiutils.service;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class DateService {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

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

    public String getWeekCardinal(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        final long count = IntStream.range(1, calendar.get(Calendar.DAY_OF_MONTH))
                .filter(day -> {
                    calendar.set(Calendar.DAY_OF_MONTH, day);
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) return true;
                    else return false;
                }).count();
        return String.format("%02d", calendar.get(Calendar.MONTH)+1) + count;
    }

    public String getWeekCardinal(String cardinal, int plus) {
        int month = Integer.parseInt(cardinal.substring(0, 2));
        int week = Integer.parseInt(cardinal.substring(2, 3));
        final int quotient  = plus / 4;
        final int remainder = plus % 4;
        month += quotient;
        week += remainder;
        if(week > 4) {
            month += 1;
            week -= 4;
        }
        while (month > 12) {
            month -= 12;
        }
        return String.format("%02d", month) + week;
    }

    public int getDiffWeekCardinal(String from, String to) {
        final int fromMonth = Integer.parseInt(from.substring(0, 2));
        final int fromWeek = Integer.parseInt(from.substring(2, 3));
        final int toMonth = Integer.parseInt(to.substring(0, 2));
        final int toWeek = Integer.parseInt(to.substring(2, 3));
        int diffMonth = fromMonth - toMonth;
        int diffWeek = fromWeek - toWeek;
        if(diffWeek < 0) {
            diffWeek += 4;
            diffMonth -= 1;
        }
        if(diffMonth < 0) diffMonth += 12;
        return diffMonth * 4 + diffWeek;
    }

    public boolean isBetween(Calendar from, Calendar to, Date time) {
        return time.equals(from.getTime()) || (time.after(from.getTime()) && time.before(to.getTime()));
    }

    public Long calcMinuteSpan(Date from, Date to) {
        if(Objects.isNull(from) || Objects.isNull(to)) return 0l;
        return (to.getTime() - from.getTime()) / (1000 * 60);
    }

    public Long calcSecondSpan(Date from, Date to) {
        if(Objects.isNull(from) || Objects.isNull(to)) return 0l;
        return (to.getTime() - from.getTime()) / (1000);
    }

    public int getDayOfWeek(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public int getDayDiff(Date from, Date to) {
        return (int) TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS);
    }

    public int getHourDiff(Date from, Date to) {
        long diff = to.getTime() - from.getTime();
        return (int) TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public int getSecondDiff(Date from, Date to) {
        long diff = to.getTime() - from.getTime();
        return (int) TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public Calendar getCalendarByDayOfWeek(Calendar date, int weekOffset, int dayOfWeek) {
        Calendar clone = (Calendar) date.clone();
        clone.add(Calendar.WEEK_OF_YEAR, weekOffset);
        clone.set(Calendar.DAY_OF_WEEK, dayOfWeek);

        return clone;
    }

    public Calendar getCalendarByDayOfMonth(Calendar date, int dayOffset, int hourOfDay) {
        Calendar clone = (Calendar) date.clone();
        clone.add(Calendar.DAY_OF_MONTH, dayOffset);
        clone.set(Calendar.HOUR_OF_DAY, hourOfDay);

        return clone;
    }

    public static synchronized Calendar getCalendar(String strDate) {
        Date date = null;
        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        assert date != null;
        calendar.setTime(date);
        return calendar;
    }
}
