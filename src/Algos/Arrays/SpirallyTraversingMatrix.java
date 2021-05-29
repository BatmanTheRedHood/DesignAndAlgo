package Algos.Arrays;

import models.Algorithm;

import java.util.ArrayList;

public class SpirallyTraversingMatrix extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {

    }

    private ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int rs = 0, re = matrix.length-1;
        int cs = 0, ce = matrix[0].length-1;

        while (rs <= re && cs <= ce) {
            // Left to right
            for (int i=rs, j=cs; j<=ce; j++) {
                result.add(matrix[i][j]);
            }

            // Top to bottom
            for (int i=rs+1, j=ce; i <= re -1; i++) {
                result.add(matrix[i][j]);
            }

            // Right to left
            if (rs < re) {
                for (int i = re, j = ce; j >= cs; j--) {
                    result.add(matrix[i][j]);
                }
            }

            // Bottom to top
            if (cs < ce) {
                for (int i = re - 1, j = cs; i >= rs + 1; i--) {
                    result.add(matrix[i][j]);
                }
            }

            rs = rs + 1;
            re = re - 1;
            cs = cs + 1;
            ce = ce - 1;
        }

        return result;
    }
}
