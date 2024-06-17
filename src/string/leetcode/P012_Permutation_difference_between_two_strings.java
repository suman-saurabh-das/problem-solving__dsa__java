package string.leetcode;

/*
    3146. Permutation difference between two strings
    https://leetcode.com/problems/permutation-difference-between-two-strings/description/

    Input: s = "abc", t = "bac"
    Output: 2
    Input: s = "abcde", t = "edbac"
    Output: 12
*/

public class P012_Permutation_difference_between_two_strings {
    public static void main(String[] args) {
        String s1 = "abc", t1 = "bac", s2 = "abcde", t2 = "edbac";
        System.out.println("Permutation difference is : " + findPermutationDifference(s1, t1));
        System.out.println("Permutation difference is : " + findPermutationDifference(s2, t2));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int findPermutationDifference(String s, String t) {
        int permutationDiff = 0;
        // Find sum of absolute difference between the index of the occurrence of each
        // character in s and the index of the occurrence of the same character in t..
        for (int i = 0; i < s.length(); i++) {
            int index = 0;
            while (index < t.length()) {
                if (s.charAt(i) == t.charAt(index)) {
                    permutationDiff = permutationDiff + Math.abs(i - index);
                    break;
                }
                index++;
            }
        }
        return permutationDiff;
    }
}
