package Algos.Recursion;

public class NumberOfPaths {
    long numberOfPaths(int m, int n) {
        int[][] nop = new int[m][n];
        int sum = 0;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++)
                nop[i][j] = -1;
        }

        return nop[0][0];
    }

    private int nop(int[][] nop, int r, int c) {
        int maxRow = nop.length;
        int maxCol = nop[0].length;

        if (r == maxRow -1 && c == maxCol -1) {// base condition
            return 1;
        }

        if (nop[r][c] >=0) {
            return nop[r][c];
        }

        int down = 0, right = 0;
        if (r+1 < maxRow)
            down = nop[r+1][c] = nop(nop, r+1, c);

        if (c+1 < maxCol)
            right = nop[r][c+1] = nop(nop, r, c+1);

        nop[r][c] = down + right;
        return nop[r][c];
    }
}
