package Algos.Arrays;

public class BooleanArray {
    // Assumption: arr is not null or empty
    void booleanMatrix(int[][] matrix) {
        boolean row0 = false, col0 = false; // To avoid Row col info overlap

        if (matrix[0][0] == 1) {
            row0 = true;
            col0 = true;
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0)
                        row0 = true;
                    else if (j == 0)
                        col0 = true;
                    else {
                        matrix[i][0] = 1;
                        matrix[0][j] = 1;
                    }
                }
            }
        }

        // Traverse rows
        for (int i=1; i<matrix.length; i++) {
            if (matrix[i][0] == 1) {
                for (int j=1; j<matrix[0].length; j++)
                    matrix[i][j] = 1;
            }
        }

        // Traverse columns
        for (int j=1; j<matrix[0].length; j++) {
            if (matrix[0][j] == 1) {
                for (int i=1; i<matrix.length; i++)
                    matrix[i][j] = 1;
            }
        }

        // Traverse 0th row
        if (row0) {
            for (int j=0; j<matrix[0].length; j++)
                matrix[0][j] = 1;
        }

        // Traverse 0th col
        if (col0) {
            for (int i=0; i<matrix.length; i++)
                matrix[i][0] = 1;
        }
    }
}
