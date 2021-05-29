package Algos.Strings;

import models.Algorithm;

public class StringToInteger extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(atoi("-12"));
    }

    private int atoi(String str) {
        int num = 0, base = 1;

        for (int i=str.length() - 1; i>=0; i--) {
            if (str.charAt(i) == '-' && i != 0)
                return -1;

            if (str.charAt(i) != '-' && (str.charAt(i) < '0' || str.charAt(i) > '9'))
                return -1;

            if (str.charAt(i) == '-')
                return -num;

            int currentCharInt = str.charAt(i) - '0';
            num += currentCharInt * base;
            base *= 10;
        }

        return num;
    }
}
