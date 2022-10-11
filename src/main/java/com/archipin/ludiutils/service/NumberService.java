package com.archipin.ludiutils.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberService {
    private final float Epsilon = 0.000001f;

    public float truncate(float v, int decimalPoint) {
//        log.info("== v before truncated={}", v);
        double scale = Math.pow(10, decimalPoint);
        return (float) (Math.round(v * scale) / scale);
    }

    public boolean equals(float a, float b) {
        return Math.abs(a - b) < Epsilon;
    }
}
