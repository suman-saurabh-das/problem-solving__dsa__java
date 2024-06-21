package string.leetcode;

/*
    1816. Truncate sentence
    https://leetcode.com/problems/truncate-sentence/description/

    Input: s = "Hello how are you Contestant", k = 4
    Output: "Hello how are you"
    Input: s = "What is the solution to this problem", k = 4
    Output: "What is the solution"
    Input: s = "chopper is not a tanuki", k = 5
    Output: "chopper is not a tanuki"
 */

public class P016_Truncate_sentence {
    public static void main(String[] args) {
        String s1 = "Hello how are you Contestant", s2 = "What is the solution to this problem";
        String s3 = "chopper is not a tanuki";
        int k1 = 4, k2 = 5;
        System.out.println("Truncated sentence is : " + truncateSentence(s1, k1));
        System.out.println("Truncated sentence is : " + truncateSentence(s2, k1));
        System.out.println("Truncated sentence is : " + truncateSentence(s3, k2));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(1)
    public static String truncateSentence(String s, int k) {
        int numSpaces = 0;
        for (int i = 0; i < s.length(); i++) {
            // If character is space, increment numSpaces.
            if (s.charAt(i) == ' ') {
                numSpaces++;
                // If spaces equal to k, return the substring till index i.
                if (numSpaces == k) {
                    return s.substring(0, i);
                }
            }
        }
        // If k is geater than numSpaces return entire string.
        return s;
    }
}
