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

        char[] chars = S.toCharArray();
        permutationOfStringFromIndex(chars, 0, "", result);

        // G4G need sorted string list in output.. Soo...
        List<String> res = new ArrayList<>(result);
        res.sort(String::compareTo);

        return res;
    }

    private void permutationOfStringFromIndex(char[] chars, int index, String word, Set<String> result) {
        if (index == chars.length - 1) {
            word += chars[index];
            result.add(word);
            return;
        }

        for (int i=index; i<chars.length; i++) {
            swap(chars, i, index);
            permutationOfStringFromIndex(chars, index + 1, word + chars[index], result);
            swap(chars, i, index);
        }
    }

    private void swap(char[] charArr, int a, int b){
        char temp = charArr[a];
        charArr[a] = charArr[b];
        charArr[b] = temp;
    }
}
