package string.leetcode;

/*
    1221. Split a string in balanced strings
    https://leetcode.com/problems/split-a-string-in-balanced-strings/description/

    Input: s = "RLRRLLRLRL"
    Output: 4
    Input: s = "RLRRRLLRLL"
    Output: 2
    Input: s = "LLLLRRRR"
    Output: 1
*/

public class P008_Split_a_string_balanced_strings {
    public static void main(String[] args) {
        String s1 = "RLRRLLRLRL", s2 = "RLRRRLLRLL", s3 = "LLLLRRRR";
        System.out.println("Maximum number of balanced strings : " + balancedStringSplit(s1));
        System.out.println("Maximum number of balanced strings : " + balancedStringSplit(s2));
        System.out.println("Maximum number of balanced strings : " + balancedStringSplit(s3));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(1)
    public static int balancedStringSplit(String s) {
        // Loop through the characters and find,
        // how many balanced pairs of R-L can be formed.
        int countR = 0, countL = 0, numBalancedStrings = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                countR++;
            } else {
                countL++;
            }
            if (countR == countL) {
                numBalancedStrings++;
                countR = 0;
                countL = 0;
            }
        }
        return numBalancedStrings;
    }
}
