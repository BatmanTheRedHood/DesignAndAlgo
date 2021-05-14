package Algos;

import models.Algorithm;

import java.util.Arrays;

public class RearrangeArrayAlternatively extends Algorithm {
    private Integer[] arr;

    @Override
    protected void init() {
        this.arr = new Integer[]{10,20,30,40,50,60,70,80,90,100,110}; //{1,2,3,4,5,6};
    }

    @Override
    protected void run() {
        this.rearrange(this.arr, 0, this.arr.length - 1);

        System.out.println(Arrays.asList(this.arr));
    }

    private void rearrange(Integer[] arr, int start, int end){
        if (start <= end) {
            int first = this.arr[start];
            int last = this.arr[end];

            rearrange(arr, start+1, end-1);

            arr[2 * start] = last;
            if (start != end) {
                arr[2 * start + 1] = first;
            }
        }
    }
}
