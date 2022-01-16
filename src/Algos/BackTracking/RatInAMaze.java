package Algos.BackTracking;

import models.Algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class RatInAMaze extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {

    }

    public ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> results = new ArrayList<>();
        if (m[0][0] == 0 || m[n-1][n-1] == 0)
            return results;

        findAllPath(0,0, m, n, "", results);
        Collections.sort(results);
        return results;
    }


    private void findAllPath(int r, int c, int[][] arr, int n, String path, ArrayList<String> res) {
        if (r == n-1 && c == n-1 && arr[r][c] == 1) { // Reached destination and Destination allows
            res.add(path);
            return;
        }

        if (r >= n || r < 0 ||
                c >= n || c < 0 ||
                arr[r][c] != 1) { // Out of boundary or blocked path
            return;
        }

        arr[r][c] = -1; // Ensure no cell repeat

        findAllPath(r-1, c, arr, n, path + "U", res);
        findAllPath(r+1, c, arr, n, path + "D", res);
        findAllPath(r, c-1, arr, n, path + "L", res);
        findAllPath(r, c+1, arr, n, path + "R", res);

        arr[r][c] = 1; // return to original state.
    }

}
