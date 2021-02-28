package Algos;

import models.Algorithm;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
public class ChocolateDistributionProblem extends Algorithm {
    // properties
    private int size;
    private int[] arr;

    // methods:
    @Override
    protected void init(){
        this.size = 3;
        this.arr = new int[]{3, 4, 1, 9, 56, 7, 9, 12};
    }

    @Override
    protected void run(){
        // Set
        int diff = this.arr[this.arr.length - 1] - this.arr[0];
        Arrays.sort(this.arr);

        for (int end = this.size;end < this.arr.length; end++){
            int currDiff = this.arr[end - 1] - this.arr[end - size];
            if (currDiff < diff) {
                diff = currDiff;
            }
        }

        System.out.println("The min difference in chocolates: " + diff);
    }
}
