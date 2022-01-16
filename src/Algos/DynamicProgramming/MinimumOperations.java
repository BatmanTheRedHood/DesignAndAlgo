package Algos.DynamicProgramming;

import java.util.Arrays;

// There is NO DP.
public class MinimumOperations {
    public int minOperation(int n) {
        int[] res = new int[n+1];
        Arrays.fill(res, -1);
        res[0] = 0;

        return minOp2(n);
        //return minOp(n, res);
    }

    int minOp(int n, int[] res) {
        if (res[n] != -1)
            return res[n];

        if (n%2 == 0)
            res[n] = 1+ minOp(n/2, res);
        else
            res[n] = 1 + minOp(n-1, res);

        return res[n];
    }

    int minOp2(int n){
        if(n == 0)
            return 0;

        int opCount = 0;
        while (n > 0) {
            if (n%2 == 0)
                n = n/2;
            else
                n = n -1;

            opCount++;
        }

        return opCount;
    }
}
