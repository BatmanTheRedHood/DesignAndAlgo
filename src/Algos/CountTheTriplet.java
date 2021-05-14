package Algos;

import models.Algorithm;

import java.util.Arrays;

public class CountTheTriplet extends Algorithm {
    private Integer[] arr;
    @Override
    protected void init() {
        //this.arr = new Integer[]{1, 2, 3, 4, 5};
        this.arr = new Integer[]{1, 1, 1, 2, 2};
    }

    @Override
    protected void run() {
        System.out.println(Arrays.asList(this.arr));
        bruteForce();
        binarySearch();
    }

    // Order : n^2*logn
    private void binarySearch(){
        //Arrays.sort(this.arr);
        MergeSort.sort(this.arr, Integer::compare);
        System.out.println(Arrays.asList(this.arr));

        for (int i=0; i < this.arr.length; i++) {
            for (int j=i+1; j < this.arr.length; j++) {
                int searchResult = BinarySearch.search(
                        this.arr, this.arr[i] + this.arr[j], j + 1, this.arr.length - 1, Integer::compare);

                if (searchResult >= 0) {
                    System.out.println(String.format(
                            "%d + %d = %d", this.arr[i], this.arr[j], this.arr[searchResult]));
                }
            }
        }
    }

    // Order is n^3
    private void bruteForce(){
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = i+1; j < this.arr.length; j++) {
                for (int k = 0; k < this.arr.length; k++) {
                    if (i == j || j == k)
                        continue;

                    if (this.arr[i] + this.arr[j] == this.arr[k]) {
                        System.out.println(String.format("%d + %d = %d", this.arr[i], this.arr[j], this.arr[k]));
                    }
                }
            }
        }
    }
}
