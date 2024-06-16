package string.leetcode;

/*
    3110. Score of a string
    https://leetcode.com/problems/score-of-a-string/description/

    Input: s = "hello"
    Output: 13
    Input: s = "zaz"
    Output: 50
*/

public class P011_Score_of_a_string {
    public static void main(String[] args) {
        String s1 = "hello", s2 = "zaz";
        System.out.println("Score is : " + scoreOfString(s1));
        System.out.println("Score is : " + scoreOfString(s2));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(1)
    public static int scoreOfString(String s) {
        int score = 0;
        // Find the sum of absolute difference between ascii values of adjacent characters.
        for (int i = 0; i < s.length() - 1; i++) {
            score = score + Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
}
