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
        float level = lv + (Epsilon * 100);
        int major = (int)level;
        float min = (level - major) * 10.0f;
        int minor = (int)min;
        return Level.builder().major(major).minor(minor).build();
    }

    public boolean equals(float a, float b) {
        return Math.abs(a - b) < Epsilon;
    }
}
