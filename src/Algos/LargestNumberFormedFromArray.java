package Algos;

import models.Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormedFromArray extends Algorithm {
    private Integer[] numbers;

    @Override
    protected void init() {
        this.numbers = new Integer[]{3, 30, 34, 5, 9};
    }

    @Override
    protected void run() {
        Arrays.sort(this.numbers, new CompareByDigitValue());

        //System.out.println(); doesn't print full array but print full collection.
        Arrays.asList(this.numbers).forEach(n -> System.out.print(n));
    }

    // Comparator type arg cannot be primitive type. Collection APIs doesn't work
    private class CompareByDigitValue implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b) {
            return -Integer.compare(this.getABNum(a, b), this.getABNum(b, a));
        }

        private int getABNum(int a, int b){
            int base = 10;
            while ((double)(b / base) >= 1){
                base *= 10;
            }

            return a * base + b;
        }
    }
}
