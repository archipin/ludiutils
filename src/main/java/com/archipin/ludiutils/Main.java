package com.archipin.ludiutils;

import com.archipin.ludiutils.service.NumberService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        NumberService numberService = new NumberService();
        numberService.truncate(3.123f, 2);
    }
}