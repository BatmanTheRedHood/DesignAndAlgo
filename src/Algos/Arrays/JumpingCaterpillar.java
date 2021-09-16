package Algos.Arrays;

public class JumpingCaterpillar {
    long uneatenLeaves(long[] arr, int n, int k) {
        int[] leaves = new int[n];
        for (int i=0; i< leaves.length; i++) {
            leaves[i] = 0;
        }

        for (int i=0; i < k; i++) {
            long counter = 1;

            while (arr[i] * counter <= n) {
                leaves[(int) (arr[i] * counter -1)] = 1;
                counter++;
            }
        }

        long leavesCount = 0;
        for (int i=0; i< leaves.length; i++) {
            if (leaves[i] == 0)
                leavesCount++;
        }

        return leavesCount;
    }
}
