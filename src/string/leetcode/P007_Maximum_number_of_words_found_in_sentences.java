package string.leetcode;

/*
    2114. Maximum number of words found in sentences
    https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/description/

    Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
    Output: 6
    Input: sentences = ["please wait", "continue to fight", "continue to win"]
    Output: 3
*/

public class P007_Maximum_number_of_words_found_in_sentences {
    public static void main(String[] args) {
        String[] sentences1 = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        String[] sentences2 = {"please wait", "continue to fight", "continue to win"};
        System.out.println("Maximum words in sentences : " + mostWordsFound(sentences1));
        System.out.println("Maximum words in sentences : " + mostWordsFound(sentences2));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(m * n) | Space complexity : O(1)
    // where m is length of sentences array and n is length of each word.
    public static int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        // Find the sentence with maximum words.
        for (int i = 0; i < sentences.length; i++) {
            int numWords = totalWordsInString(sentences[i]);
            if (numWords > maxWords) {
                maxWords = numWords;
            }
        }
        return maxWords;
    }

    // Find total words in a sentence.
    // Time complexity : O(n) | Space complexity : O(1)
    public static int totalWordsInString(String str) {
        // Number of words = Number of spaces + 1
        int numSpaces = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                numSpaces++;
            }
        }
        return numSpaces + 1;
    }

    // ALTERNATIVE SOLUTION USING LOOP
    // Time complexity : O(m * n) | Space complexity : O(1)
    // where m is length of sentences array and n is length of each word.
    // split(), internally uses a loop to find all occurrence of delimiter.
    public static int mostWordsFound2(String[] sentences) {
        int maxWords = 0;
        for (int i = 0; i < sentences.length; i++) {
            String str = sentences[i];
            int numWords = str.split(" ").length;
            maxWords = Math.max(numWords, maxWords);
        }
        return maxWords;
    }
}
