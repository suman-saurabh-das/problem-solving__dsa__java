package sorting.leetcode;

/*
    2785. Sort vowels in a string
    https://leetcode.com/problems/sort-vowels-in-a-string/description/
    NOTE - This solution gives time limit exceeded error for large arrays.

    Input: s = "lEetcOde"
    Output: "lEOtcede"
    Input: s = "lYmpH"
    Output: "lYmpH"
*/

import java.util.ArrayList;

public class P019_Sort_vowels_in_a_string {
    public static void main(String[] args) {
        String s1 = "lEetcOde", s2 = "lYmpH";
        System.out.println("String after sorting vowels : " + sortVowels(s1));
        System.out.println("String after sorting vowels : " + sortVowels(s2));
    }

    // SOLUTION USING INSERTION SORT
    // Time complexity : O(n²) | Space complexity : O(n)
    public static String sortVowels(String s) {
        ArrayList<Character> vowelsList = new ArrayList<>();
        // Identify all the vowels and store them in a list.
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowelsList.add(s.charAt(i));
            }
        }

        // Sort the list.
        insertionSort(vowelsList);

        // Use StringBuilder class to create a copy of string.
        // Replace the vowels in string from the list.
        StringBuilder str = new StringBuilder(s);
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                str.setCharAt(i, vowelsList.get(j));
                j++;
            }
        }
        return new String(str);
    }

    // Check if character is vowel or consonant.
    // Time complexity : O(1) | Space complexity : O(1)
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    // Insertion Sort.
    // Time complexity : O(n²) | Space complexity : O(1)
    public static void insertionSort(ArrayList<Character> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 1 + i; j > 0; j--) {
                if (list.get(j) < list.get(j - 1)) {
                    swap(list, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    // Swap array elements using index.
    // Time complexity : O(1) | Space complexity : O(1)
    public static void swap(ArrayList<Character> list, int index1, int index2) {
        char temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
