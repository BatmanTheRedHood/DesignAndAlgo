package Algos.Strings;

import models.Algorithm;

/**
 * Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.
 *
 * Example 1:
 *
 * Input:
 * a = amazon
 * b = azonam
 * Output: 1
 * Explanation: amazon can be rotated anti
 * clockwise by two places, which will make
 * it as azonam.
 * Example 2:
 *
 * Input:
 * a = geeksforgeeks
 * b = geeksgeeksfor
 * Output: 0
 * Explanation: If we rotate geeksforgeeks by
 * two place in any direction , we won't get
 * geeksgeeksfor.
 * Your Task:
 * The task is to complete the function isRotated() which takes two strings as input parameters and checks if given strings can be formed by rotations. The function returns true if string 1 can be obtained by rotating string 2 by two places, else it returns false.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxilary Complexity: O(N).
 * Challenge: Try doing it in O(1) space complexity.
 *
 * Constraints:
 * 1 <= length of a, b < 100
 */
public class StringRotatedBy2Place extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(isRotated("amazon", "azonam"));
    }

    protected boolean isRotated(String str1, String str2)
    {
        // Your code here
        if (str1.length() != str2.length())
            return false;

        return rotatedAB(str1, str2) || rotatedAB(str2, str1);
    }

    private boolean rotatedAB(String a, String b) {
        int j;
        for (int i=0; i<a.length(); i++) {
            j = (i + 2) % b.length();

            if (a.charAt(i) != b.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
