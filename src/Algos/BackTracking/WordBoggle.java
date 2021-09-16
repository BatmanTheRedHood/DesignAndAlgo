package Algos.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class WordBoggle {
    public String[] wordBoggle(char[][] board, String[] dictionary) {
        List<String> foundWords = new ArrayList<>();

        for (String word: dictionary) {
            if (processWord(board, word))
                foundWords.add(word);
        }

        return foundWords.toArray(new String[0]);
    }

    private boolean processWord(char[][] board, String word) {
        for (int i=0; i < board.length; i++){
            for (int j=0; j< board[0].length; j++){
                if (board[i][j] == word.charAt(0)) {
                    if (foo(board, word, 0, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    // Assumption: All given chars are capital letters
    private boolean foo(char[][] board, String word, int i, int r, int c) {
        // Check word match
        if (i >= word.length())
            return true;

        // Check out of boundary
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return false;

        // Neighbour didn't match
        if (board[r][c] != word.charAt(i))
            return false;

        // Neighbour matched, so change to small case so that didn't match again
        board[r][c] = (char) ('a' + board[r][c] - 'A');

        boolean isMatch = foo(board, word, i + 1, r - 1, c) || // top
                foo(board, word, i + 1, r + 1, c) || // Bottom
                foo(board, word, i + 1, r, c - 1) || // Left
                foo(board, word, i + 1, r, c + 1) || // Right
                foo(board, word, i + 1, r - 1, c - 1) || // LeftTop
                foo(board, word, i + 1, r - 1, c + 1) || // RightTop
                foo(board, word, i + 1, r + 1, c - 1) || // Left Bottom
                foo(board, word, i + 1, r + 1, c + 1); // Right Bottom

        // revert back to original char for others comparison
        board[r][c] = (char) ('A' + board[r][c] - 'a');

        return isMatch;
    }
}
