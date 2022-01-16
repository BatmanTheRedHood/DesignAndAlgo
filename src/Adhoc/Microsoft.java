package Adhoc;

import java.util.Arrays;

public class Microsoft {
    public void printHello() {
        System.out.println("Hello MS");

        System.out.println(solution(6, 1, 1));
        System.out.println(solution(1, 3, 1));
        System.out.println(solution(0, 0, 2));
        System.out.println(solution(0, 1, 8));
    }

    public String solution(int A, int B, int C) {
        // write your code in Java SE 8
        return getMaxWord(A, B, C, "");
    }

    private String getMaxWord(int A, int B, int C, String word) {
        String aWord = "", bWord= "", cWord = "";

        if (A>0 && isValid(word+ 'a')) {
            aWord = getMaxWord(A-1, B, C, word+'a');
        }

        if (B>0 && isValid(word + 'b')) {
            bWord = getMaxWord(A, B-1, C, word + 'b');
        }

        if (C>0 && isValid(word + 'c')) {
            cWord = getMaxWord(A,B, C-1, word + 'c');
        }

        String maxLenString = getMaxLenString(aWord, bWord);
        maxLenString = getMaxLenString(maxLenString, cWord);

        return maxLenString.length() > 0? maxLenString : word;
    }

    private boolean isValid(String str) {
        if (str.contains("aaa") || str.contains("bbb") || str.contains("ccc"))
            return false;

        return true;
    }

    private String getMaxLenString(String s1, String s2) {
        if (s1.length() > s2.length())
            return s1;

        return s2;
    }
}
