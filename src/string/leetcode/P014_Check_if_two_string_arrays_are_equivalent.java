package string.leetcode;

/*
    1662. Check if two string arrays are equivalent
    https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/

    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
    Output: true
    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
    Output: false
    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
    Output: true
*/

public class P014_Check_if_two_string_arrays_are_equivalent {
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        String[] word3 = {"a", "cb"}, word4 = {"ab", "c"};
        String[] word5 = {"abc", "d", "defg"}, word6 = {"abcddefg"};
        System.out.println("Strings are equal : " + arrayStringsAreEqual(word1, word2));
        System.out.println("Strings are equal : " + arrayStringsAreEqual(word3, word4));
        System.out.println("Strings are equal : " + arrayStringsAreEqual(word5, word6));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(1)
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = createStringFromArr(word1);
        String s2 = createStringFromArr(word2);
        return s1.equals(s2);
    }

    // Time complexity : O(n) | Space complexity : O(1)
    public static String createStringFromArr(String[] word) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            str.append(word[i]);
        }
        return new String(str);
    }
}
