package Algos.StackQueue;

import models.Algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an input stream of A of n characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream. If there is no such character then append '#' to the answer.
 *
 *
 * Example 1:
 *
 * Input: A = "aabc"
 * Output: "a#bb"
 * Explanation: For every character first non
 * repeating character is as follow-
 * "a" - first non-repeating character is 'a'
 * "aa" - no non-repeating character so '#'
 * "aab" - first non-repeating character is 'b'
 * "aabc" - first non-repeating character is 'b'
 * Example 2:
 *
 * Input: A = "zz"
 * Output: "z#"
 * Explanation: For every character first non
 * repeating character is as follow-
 * "z" - first non-repeating character is 'z'
 * "zz" - no non-repeating character so '#'
 *
 *
 * Your Task:
 * You don't need to read or print anything. Your task is to complete the function FirstNonRepeating() which takes A as input parameter and returns a string after processing the input stream.
 *
 *
 * Expected Time Complexity: O(26 * n)
 * Expected Space Complexity: O(26)
 *
 *
 * Constraints:
 * 1 <= n <= 105
 */
public class FirstNonRepeatingCharacterInStream extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        String str = "Indian Creators through OTT Platform had Started taking Risk to Create World Class Content";
        str = str.toLowerCase();
        str = str.replaceAll(" ", "");

        System.out.println(str);
        System.out.println(FirstNonRepeating(str));
        System.out.println(FirstNonRepeating("zz"));
    }

    private String FirstNonRepeating(String str) {
        // Initialize
        String result = "";
        CharArrQueue queue = new CharArrQueue(new char[26]);
        int[] charCount = new int[26];
        for (int i=0; i<26; i++)
            charCount[i] = 0;

        for (int i=0; i<str.length(); i++) {
            // Check for unique char
            int charIndex = str.charAt(i) - 'a';
            charCount[charIndex]++;
            if (charCount[charIndex] == 1) {
                queue.insert(str.charAt(i));
            } else {
                // Duplicate is in front of queue
                while (!queue.isEmpty() && charCount[queue.peek() - 'a'] > 1) {
                    queue.remove();
                }
            }

            if (queue.isEmpty()) { // No unique char left
                result += "#";
            } else {
                result += queue.peek();
            }
        }

        return result;
    }
}

class CharArrQueue{
    char[] queue;
    int front;
    int rear;

    public CharArrQueue(char[] q) {
        queue = q;
        front = 0; // Front is always 1 step ahead. meaning points to index where new element will be added
        rear = -1; // Rear point to 1st element in queue
    }

    public void insert(char item){
        if (isFull())
            return;

        queue[front%queue.length] = item;
        front++;

        if (rear < 0) // Initialize for empty queue
            rear++;
    }

    public int remove(){
        // Check for empty queue
        if (rear < 0) {
            // Queue is empty
            return -1;
        }

        int temp = queue[rear%queue.length];
        rear++;

        if (isFull()) { // Rear reached front while removing item. Means queue is empty. Reset
            rear = -1;
            front = 0;
        }

        return temp;
    }

    public boolean isFull() {
        return front% queue.length == rear%queue.length;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public char peek() {
        return queue[rear % queue.length];
    }
}

