package Algos.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueen {
    ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        int[][] grid = new int[n][n];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int[] row : grid)
            Arrays.fill(row, 0);

        placeQueens(0, grid, res);

        return res;
    }

    private void placeQueens(int row, int[][] grid, ArrayList<ArrayList<Integer>> res) {
        if (row >= grid.length) { // Grid completed without issue. Store queen placement
            res.add(getQueenPlacement(grid));
            return;
        }

        for (int j = 0; j<grid[0].length; j++) {
            if (isValidPlacement(row, j, grid)) {
                grid[row][j] = 1; // Set place for queen
                placeQueens(row + 1, grid, res);

                grid[row][j] = 0; // Reset for other solutions
            }
        }
    }

    private boolean isValidPlacement(int row, int col, int[][] grid) {
        if (row == 0) // All col placements are valid
            return true;

        // Diagonal check left
        int r = row-1, c=col-1;
        while (r>=0 && c>= 0) {
            if (grid[r][c] == 1)
                return false;
            r--;
            c--;
        }


        // Diagonal check left
        r = row-1;
        c = col + 1;
        while (r>=0 && c < grid[0].length) {
            if (grid[r][c] == 1)
                return false;

            r--;
            c++;
        }

        // no queen in the line
        for (r=0; r< row; r++){
            if (grid[r][col] == 1)
                return false;
        }

        return true;
    }

    private ArrayList<Integer> getQueenPlacement(int[][] grid) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res.add(j +1);
                    break;
                }
            }
        }

        return res;
    }
}
