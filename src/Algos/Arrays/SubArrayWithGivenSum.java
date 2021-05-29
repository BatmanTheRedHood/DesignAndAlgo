package Algos.Arrays;

import models.Algorithm;

// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class SubArrayWithGivenSum extends Algorithm {
    // properties:
    private int sum;
    private int[] array; // = {1,2,3,7,5}; works when used during declaration.

    // methods:
    @Override
    protected void init(){
        this.sum = 12;
        this.array = new int[]{1,2,3,4,5,6,7,8,9,10};
    }

    @Override
    protected void run(){
        // Set
        int start = 0;
        int end = 0;
        int currSum = this.array[0];

        while (end < this.array.length && start < this.array.length){
            // Reset
            if (end < start){
                end = start;
                currSum = this.array[start];
            }

            if (currSum == this.sum){
                // Print.
                System.out.println(String.format("Sub array start at %s and ends at %d", start, end));

                break;
            } else if (currSum < this.sum){
                end++;

                if (end >= this.array.length) break;

                currSum += this.array[end];
            } else{
                currSum -= this.array[start];
                start++;
            }
        }
    }
}
