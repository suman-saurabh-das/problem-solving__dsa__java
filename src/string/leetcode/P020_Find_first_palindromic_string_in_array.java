package string.leetcode;

/*
    2108. Find first palindromic string in the array
    https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/

    Input: words = ["abc","car","ada","racecar","cool"]
    Output: "ada"
    Input: words = ["notapalindrome","racecar"]
    Output: "racecar"
    Input: words = ["def","ghi"]
    Output: ""
*/

public class P020_Find_first_palindromic_string_in_array {
    public static void main(String[] args) {
        String[] words1 = {"abc", "car", "ada", "racecar", "cool"}, words2 = {"notapalindrome", "racecar"};
        String[] words3 = {"def", "ghi"};
        System.out.println("First palindrome : " + firstPalindrome(words1));
        System.out.println("First palindrome : " + firstPalindrome(words2));
        System.out.println("First palindrome : " + firstPalindrome(words3));
    }

    // SOLUTION USING 2 POINTERS AND LOOP
    // Time complexity : O(n²) | Space complexity :O(1)
    public static String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            // Check if current word is a palindrome.
            if (isPalindrome(words[i])) {
                return words[i];
            }
        }
        return "";
    }

    // Check if number is a palindrome.
    // Time complexity : O(n) | Space complexity :O(1)
    public static boolean isPalindrome(String str) {
        boolean isBoolean = true;
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                isBoolean = false;
                break;
            }
        }
        return isBoolean;
    }
}
