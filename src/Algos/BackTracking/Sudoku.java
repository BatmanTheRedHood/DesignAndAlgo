package Algos.BackTracking;

public class Sudoku {
    //Function to find a solved Sudoku.
    boolean SolveSudoku(int grid[][])
    {
        // add your code here
        return sudoku(0, grid);
    }

    //Function to print grids of the Sudoku.
    void printGrid (int[][] grid)
    {
        // add your code here
        for (int i=0; i< grid.length; i++) {
            for (int j=0; j< grid[0].length; j++)
                System.out.print(grid[i][i] + " ");

            System.out.println();
        }
    }

    boolean sudoku(int cell, int[][] grid) {
        int r = Math.floorDiv(cell, grid.length);
        int c = cell % grid[0].length;

        // Continue for pre-filled cells
        while (cell < grid.length * grid[0].length && grid[r][c] != 0 ) {
            cell++;
            r = Math.floorDiv(cell, grid.length);
            c = cell % grid[0].length;
        }

        // Cell out of boundary and no problem found so far means sudoku is solved
        if (cell >= grid.length * grid[0].length)
            return true;

        // Processing for empty cell
        for (int i = 1; i< 10; i++) {
            if (!checkFill(i, r, c, grid))
                continue;

            // Set new value and check
            grid[r][c] = i;
            if (sudoku(cell + 1, grid))
                return true;

            // Reset to original value
            grid[r][c] = 0;
        }

        // No num b/w 1-9 found that fits this cell. No solution possible
        return false;
    }

    // given grid[r][c] == 0;
    boolean checkFill(int num, int r, int c, int[][] grid) {
        // Check row
        for (int col=0; col < grid[0].length; col++) {
            if (grid[r][col] == num)
                return false;
        }

        // Check col
        for (int row=0; row < grid.length; row++) {
            if (grid[row][c] == num)
                return false;
        }

        //corresponding square has unique number (box-clash).
        int sqrt = (int) Math.sqrt(grid.length);
        int boxRowStart = r - r % sqrt;
        int boxColStart = c - c % sqrt;

        for (int row = boxRowStart; row < boxRowStart + sqrt; row++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (grid[row][d] == num) {
                    return false;
                }
            }
        }

/*
        // Check for up left
        if (r>0 && c > 0 && grid[r-1][c-1] == num)
            return false;

        // Check for up right
        if (r>0 && c < grid[0].length -1 && grid[r-1][c+1] == num)
            return false;

        // Check for down left
        if (r < grid.length - 1 && c > 0 && grid[r+1][c-1] == num)
            return false;

        // Check for down right
        if (r < grid.length - 1 && c < grid[0].length -1 && grid[r+1][c+1] == num)
            return false;


            3 0 6 5 0 8 4 0 0
            5 2 0 0 0 0 0 0 0
            0 8 7 0 0 0 0 3 1
            0 0 3 0 1 0 0 8 0
            9 0 0 8 6 3 0 0 5
            0 5 0 0 9 0 6 0 0
            1 3 0 0 0 0 2 5 0
            0 0 0 0 0 0 0 7 4
            0 0 5 2 0 6 3 0 0

            3 1 6 5 7 8 4 9 2
            5 2 9 1 3 4 7 6 8
            4 8 7 6 2 9 5 3 1
            2 6 3 4 1 5 9 8 7
            9 7 4 8 6 3 1 2 5
            8 5 1 7 9 2 6 4 3
            1 3 8 9 4 7 2 5 6
            6 9 2 3 5 1 8 7 4
            7 4 5 2 8 6 3 1 9

            3 3 3 3 3 3 3 3 3
            2 2 2 2 2 2 2 2 2
            7 7 7 7 7 7 7 7 7
            4 4 4 4 4 4 4 4 4
            6 6 6 6 6 6 6 6 6
            2 2 2 2 2 2 2 2 2
            2 2 2 2 2 2 2 2 2
            7 7 7 7 7 7 7 7 7
            9 9 9 9 9 9 9 9 9

            1 3 0 0 0 0 4 2 0
            0 8 0 0 1 0 0 0 6
            7 0 0 5 8 0 3 0 0
            0 0 0 0 9 0 8 0 3
            0 0 0 1 6 8 0 0 0
            9 0 8 0 3 0 0 0 0
            0 0 6 0 4 9 0 0 2
            2 0 0 0 5 0 0 8 0
            0 9 1 0 0 0 0 7 4

            1 3 5 9 7 6 4 2 8
            4 8 9 3 1 2 7 5 6
            7 6 2 5 8 4 3 9 1
            6 5 4 2 9 7 8 1 3
            3 2 7 1 6 8 9 4 5
            9 1 8 4 3 5 2 6 7
            5 7 6 8 4 9 1 3 2
            2 4 3 7 5 1 6 8 9
            8 9 1 6 2 3 5 7 4
*/
        return true;
    }
}
