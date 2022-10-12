package com.archipin.ludiutils.domain;

import lombok.*;

public class Level {
    private Integer major;
    private Integer minor;


    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Integer getMinor() {
        return minor;
    }

    public void setMinor(Integer minor) {
        this.minor = minor;
    }
}
