package Algos.Recursion;

public class FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        runFloodFill(image, sr, sc, newColor);

        // To handle newColor == image[sr][sc] ...handling
        for (int i=0; i<image.length;i++) {
            for (int j=0;j<image[0].length;j++) {
                if (image[i][j] < 0)
                    image[i][j] = -image[i][j];
            }
        }

        return image;
    }

    private void runFloodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int maxRow = image.length;
        int maxCol = image[0].length;
        int oldColor = image[sr][sc];
        image[sr][sc] = -newColor; // To handle newColor == image[sr][sc]

        // Up
        if (sr - 1 >= 0 && image[sr-1][sc] == oldColor)
            runFloodFill(image,sr-1, sc, newColor);

        // Down
        if (sr + 1 < maxRow && image[sr+1][sc] == oldColor)
            runFloodFill(image,sr+1, sc, newColor);

        // left
        if (sc-1 >= 0 && image[sr][sc -1] == oldColor)
            runFloodFill(image,sr, sc-1, newColor);

        // right
        if (sc+1 < maxCol && image[sr][sc+1] == oldColor)
            runFloodFill(image,sr, sc+1, newColor);
    }
}
