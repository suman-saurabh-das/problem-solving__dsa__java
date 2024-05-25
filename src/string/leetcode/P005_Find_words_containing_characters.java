package string.leetcode;

/*
    2942. Find words containing character
    https://leetcode.com/problems/find-words-containing-character/description/

    Input: words = ["leet","code"], x = "e"
    Output: [0,1]
    Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
    Output: [0,2]
    Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
    Output: []
*/

import java.util.ArrayList;

public class P005_Find_words_containing_characters {
    public static void main(String[] args) {
        String[] words1 = {"leet", "code"}, words2 = {"abc", "bcd", "aaaa", "cbc"};
        char x1 = 'e', x2 = 'a', x3 = 'z';
        System.out.println("Words containing characters are at index : " + findWordsContaining(words1, x1));
        System.out.println("Words containing characters are at index : " + findWordsContaining(words2, x2));
        System.out.println("Words containing characters are at index : " + findWordsContaining(words2, x3));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(m * n) | Space complexity : O(m)
    // where m is length of words array and n is length of each word.
    // Here time complexity is O(m * n) because indexOf() method, uses an internal loop to check for elements.
    public static ArrayList<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> listOfWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            // If word has the character x then, add index of word to listOfWords.
            if (words[i].indexOf(x) != -1) {
                listOfWords.add(i);
            }
        }
        return listOfWords;
    }
}
