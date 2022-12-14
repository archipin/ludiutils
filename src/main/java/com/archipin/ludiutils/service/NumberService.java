package com.archipin.ludiutils.service;

import com.archipin.ludiutils.domain.Level;
import lombok.extern.slf4j.Slf4j;

public class NumberService {
    private final float Epsilon = 0.000001f;

    public float truncate(float v, int decimalPoint) {
        double scale = Math.pow(10, decimalPoint);
        return (float) (Math.round(v * scale) / scale);
    }

    public Level convertLevel(Float lv) {
        Integer major = lv.intValue();
        float min = (lv.floatValue() - major.floatValue()) * 10.0f;
        Integer minor = Integer.valueOf((int)min);
        return Level.builder().major(major).minor(minor).build();
    }

    public boolean equals(float a, float b) {
        return Math.abs(a - b) < Epsilon;
    }
}
