package Algos.StackQueue;

import models.Algorithm;

import java.util.Stack;

/**
 * Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.
 *
 * Example 1:
 *
 * Input:
 * {([])}
 * Output:
 * true
 * Explanation:
 * { ( [ ] ) }. Same colored brackets can form
 * balaced pairs, with 0 number of
 * unbalanced bracket.
 * Example 2:
 *
 * Input:
 * ()
 * Output:
 * true
 * Explanation:
 * (). Same bracket can form balanced pairs,
 * and here only 1 type of bracket is
 * present and in balanced way.
 * Example 3:
 *
 * Input:
 * ([]
 * Output:
 * false
 * Explanation:
 * ([]. Here square bracket is balanced but
 * the small bracket is not balanced and
 * Hence , the output will be unbalanced.
 * Your Task:
 * This is a function problem. You only need to complete the function ispar() that takes a string as a parameter and returns a boolean value true if brackets are balanced else returns false. The printing is done automatically by the driver code.
 *
 * Expected Time Complexity: O(|x|)
 * Expected Auixilliary Space: O(|x|)
 *
 * Constraints:
 * 1 ≤ |x| ≤ 32000
 *
 * Note: The drive code prints "balanced" if function return true, otherwise it prints "not balanced".
 */
public class ParenthesisChecker extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(ispar("{([])}"));
        System.out.println(ispar("[(])"));
    }


    // Assumption String is not null
    //Function to check if brackets are balanced or not.
    private boolean ispar(String x)
    {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<x.length(); i++) {
            if (isStartingBracket(x.charAt(i))) { // Push starting bracket
                stack.push(x.charAt(i));
            } else { // Pop and match
                if (stack.isEmpty() || stack.pop() != getMatchingBracket(x.charAt(i)))
                    return false;
            }
        }

        // String should be over and stack should be empty to balance
        return stack.isEmpty();
    }

    private boolean isStartingBracket(char c) {
        return c == '[' || c == '{' || c == '(';
    }

    private char getMatchingBracket(char c) {
        switch (c){
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
            default:
                return '-';
        }
    }
}
