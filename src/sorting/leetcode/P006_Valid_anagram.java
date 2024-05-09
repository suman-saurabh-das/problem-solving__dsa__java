package sorting.leetcode;

/*
    242. Valid anagram
    https://leetcode.com/problems/valid-anagram/description/

    Input: s = "anagram", t = "nagaram"
    Output: true
    Input: s = "rat", t = "car"
    Output: false
*/

public class P006_Valid_anagram {
    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram", s2 = "rat", t2 = "cat";
        System.out.println("Strings are anagrams : " + isAnagram(s1, t1));
        System.out.println("Strings are anagrams : " + isAnagram(s2, t2));
    }

    // SOLUTION USING INSERTION SORT - time complexity : O(n^2)
    public static boolean isAnagram(String s, String t) {
        // Sort the 2 strings.
        s = insertionSort(s);
        t = insertionSort(t);
        // Compare the 2 strings and return boolean result.
        return s.equals(t);
    }

    // Insertion sort - time complexity : O(n^2)
    public static String insertionSort(String str) {
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (charArr[j] < charArr[j - 1]) {
                    swap(charArr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return new String(charArr);
    }

    // Swap array elements using index.
    public static void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
