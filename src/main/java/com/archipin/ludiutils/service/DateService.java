package com.archipin.ludiutils.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateService {
    public int getDayDiff(Date from, Date to) {
        return (int) TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS);
    }
}
