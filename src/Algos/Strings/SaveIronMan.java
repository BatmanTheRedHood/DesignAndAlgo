package Algos.Strings;

public class SaveIronMan {
    boolean save(String s) {
        int i = 0;
        int j = s.length() -1;

        while (i< j) {
            char f = getCleanChar(s.charAt(i));
            if (f == '#') {
                i++;
                continue;
            }

            char l = getCleanChar(s.charAt(j));
            if (l == '#') {
                j--;
                continue;
            }

            if (f != l)
                return false;

            i++;
            j--;
        }

        return true;
    }

    boolean saveIronMan(String s) {
        String cleanWord = "";
        for (int i=0; i<s.length(); i++) {
            char c = getCleanChar(s.charAt(i));

            if (c != '#')
                cleanWord += c;
        }

        // Assumption: s has a valid character
        int i=0, j= cleanWord.length() -1;
        while (i < j) {
            if (cleanWord.charAt(i) != cleanWord.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    private char getCleanChar(char c) {
        if (c >= 'A' && c <= 'Z')
            return (char) ('a' + c -'A');

        if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
            return c;

        return '#';
    }
}
