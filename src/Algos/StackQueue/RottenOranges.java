package Algos.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    //Function to find minimum time required to rot all oranges.
    private int orangesRotting(int[][] grid) {
        // Initialize
        Queue<Orange> q1 = new LinkedList<>();
        Queue<Orange> q2 = new LinkedList<>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q1.add(new Orange(i, j));
                }
            }
        }

        // Start processing
        int time = 0;
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) {
                processQueue(grid, q2, q1);
            } else {
                processQueue(grid, q1, q2);
            }

            time++; // return time - 1 as empty queue takes a cycle
        }

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time - 1;
    }

    private void processQueue(int[][] grid, Queue<Orange> q1, Queue<Orange> q2) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        while (!q1.isEmpty()) {
            Orange orange = q1.remove();

            // Check left
            if (orange.col -1 >= 0 && grid[orange.row][orange.col-1] == 1) {
                grid[orange.row][orange.col-1] = 2;
                q2.add(new Orange(orange.row, orange.col-1));
            }

            // check right
            if (orange.col + 1 < maxCol && grid[orange.row][orange.col+1] == 1) {
                grid[orange.row][orange.col+1] = 2;
                q2.add(new Orange(orange.row, orange.col+1));
            }

            // check up
            if (orange.row -1 >= 0 && grid[orange.row-1][orange.col] == 1) {
                grid[orange.row-1][orange.col] = 2;
                q2.add(new Orange(orange.row-1, orange.col));
            }

            // check down
            if (orange.row + 1 < maxRow && grid[orange.row+1][orange.col] == 1) {
                grid[orange.row+1][orange.col] = 2;
                q2.add(new Orange(orange.row+1, orange.col));
            }
        }
    }
}

class Orange {
    public int row, col;

    public Orange(int r, int c) {
        row = r;
        col = c;
    }
}