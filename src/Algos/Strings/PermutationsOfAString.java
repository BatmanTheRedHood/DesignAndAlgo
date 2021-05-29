package Algos.Strings;

import models.Algorithm;

import java.util.*;

/**
 * Given a string S. The task is to print all permutations of a given string.
 *
 *
 *
 * Example 1:
 *
 * Input: ABC
 * Output:
 * ABC ACB BAC BCA CAB CBA
 * Explanation:
 * Given string ABC has permutations in 6
 * forms as ABC, ACB, BAC, BCA, CAB and CBA .
 * Example 2:
 *
 * Input: ABSG
 * Output:
 * ABGS ABSG AGBS AGSB ASBG ASGB BAGS
 * BASG BGAS BGSA BSAG BSGA GABS GASB
 * GBAS GBSA GSAB GSBA SABG SAGB SBAG
 * SBGA SGAB SGBA
 * Explanation:
 * Given string ABSG has 24 permutations.
 *
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function find_permutaion() which takes the string S as input parameter and returns a vector of string in lexicographical order.
 *
 *
 *
 * Expected Time Complexity: O(n! * n)
 *
 * Expected Space Complexity: O(n)
 *
 *
 *
 * Constraints:
 * 1 <= length of string <= 5
 */
public class PermutationsOfAString extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(find_permutation("AABC"));
    }

    private List<String> find_permutation(String S) {
        Set<String> result = new HashSet<String>();
        permutationOfStringFromIndex(S, 0, "", result);

        // G4G need sorted string list in output.. Soo...
        List<String> res = new ArrayList<>(result);
        res.sort(String::compareTo);

        return res;
    }

    private void permutationOfStringFromIndex(String str, int index, String word, Set<String> result) {
        if (index == str.length() - 1) {
            word += str.charAt(index);
            result.add(word);
            return;
        }

        for (int i=index; i<str.length(); i++) {
            str = swap(str, i, index);
            permutationOfStringFromIndex(str, index + 1, word + str.charAt(index), result);
        }
    }

    private void permutationOfStringFromIndex2(String str, int index, String word, List<String> result) {
        if (index == str.length() - 1) {
            word += str.charAt(index);
            result.add(word);
            return;
        }

        for (int i=index; i<str.length(); i++) {
            str = swap(str, i, index);
            permutationOfStringFromIndex2(str, index + 1, word + str.charAt(index), result);
        }
    }

    private String swap(String str, int a, int b){
        char[] charArr = str.toCharArray();
        char temp = charArr[a];
        charArr[a] = charArr[b];
        charArr[b] = temp;

        return String.copyValueOf(charArr);
    }
}
