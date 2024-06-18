package string.leetcode;

/*
    2000. Reverse prefix of word
    https://leetcode.com/problems/reverse-prefix-of-word/description/

    Input: word = "abcdefd", ch = "d"
    Output: "dcbaefd"
    Input: word = "xyxzxe", ch = "z"
    Output: "zxyxxe"
    Input: word = "abcd", ch = "z"
    Output: "abcd"
*/

public class P013_Reverse_prefix_of_word {
    public static void main(String[] args) {
        String word1 = "abcdefd", word2 = "xyxzxe", word3 = "abcd";
        char ch1 = 'd', ch2 = 'z';
        System.out.println("Reversed prefix word is : " + reversePrefix(word1, ch1));
        System.out.println("Reversed prefix word is : " + reversePrefix(word2, ch2));
        System.out.println("Reversed prefix word is : " + reversePrefix(word3, ch2));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : o(1)
    public static String reversePrefix(String word, char ch) {
        StringBuilder str = new StringBuilder(word);
        int indexOfCh = -1;
        // Find the index of character ch.
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                indexOfCh = i;
                break;
            }
        }
        // If ch is not found in word, return word.
        if (indexOfCh == -1) {
            return word;
        }
        // Swap the characters before the index of given ch.
        int start = 0, end = indexOfCh;
        while (start < end) {
            char temp = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, temp);
            start++;
            end--;
        }
        return new String(str);
    }
}
