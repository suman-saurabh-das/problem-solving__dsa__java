package string.leetcode;

/*
    28. Find the index of the first occurrence in a string
    https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

    Input: haystack = "sadbutsad", needle = "sad"
    Output: 0
    Input: haystack = "leetcode", needle = "leeto"
    Output: -1
*/

public class P010_Find_the_index_of_the_first_occurrence_in_a_string {
    public static void main(String[] args) {
        String haystack1 = "sadbutsad", needle1 = "sad", haystack2 = "leetcode", needle2 = "leeto";
        System.out.println("Index of first occurrence : " + strStr(haystack1, needle1));
        System.out.println("Index of first occurrence : " + strStr(haystack2, needle2));
    }

    // SOLUTION USING NESTED LOOPS - time complexity : O(m*n)
    // Where m - length of haystack, n - length of needle
    public static int strStr(String haystack, String needle) {
        // Start and end index of characters in needle string.
        int start = 0, end = needle.length() - 1;
        while (end < haystack.length()) {
            boolean isPresent = true;
            for (int i = 0; i < needle.length(); i++) {
                // Check if each character in string needle is present in haystack.
                if (haystack.charAt(i + start) != needle.charAt(i)) {
                    isPresent = false;
                    break;
                }
            }
            if (isPresent) {
                return start;
            }
            start++;
            end++;
        }
        return -1;
    }

    // SOLUTION USING BUILT-IN METHOD - time complexity : O(m*n)
    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // SOLUTION USING LOOP - time complexity - O(m*n)
    // Here time complexity is O(m*n) because substring() and equals() internally uses a loop.
    public static int strStr3(String haystack, String needle) {
        int index = 0;
        while (index + needle.length() - 1 < haystack.length()) {
            if (haystack.substring(index, index + needle.length()).equals(needle)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
