package Algos.Strings;

import models.Algorithm;

public class Base10ToBase62 extends Algorithm {
    private String base10To62(long n) {
        String base62Digits = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        String result = "";
        long remainder = 0;

        while (n/62 >= 1) {
            remainder =  n%62;
            n = Math.floorDiv(n, 62);

            result = base62Digits.charAt((int)remainder) + result;
            System.out.println(String.format("reminder %d and result %s", remainder, result));
        }

        remainder =  (int) n%62;
        result = base62Digits.charAt((int)remainder) + result;
        return result;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        long n = 1622650074;
        n = 10000031101L;
        System.out.println(String.format("Base62 for %d = %s", n, base10To62(n)));
    }
}
