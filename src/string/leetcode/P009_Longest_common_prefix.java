package string.leetcode;

/*
    14. Longest common prefix
    https://leetcode.com/problems/longest-common-prefix/description/

    Input: strs = ["flower","flow","flight"]
    Output: "fl"
    Input: strs = ["dog","racecar","car"]
    Output: ""
 */
public class P009_Longest_common_prefix {
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"}, strs2 = {"dog", "racecar", "car"};
        System.out.println("Longest common prefix : " + longestCommonPrefix(strs1));
        System.out.println("Longest common prefix : " + longestCommonPrefix(strs2));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(m * n) | Space complexity : O(n)
    // where m is length of strs array and n is length of each word.
    public static String longestCommonPrefix(String[] strs) {
        // StringBuilder object to create the string containing common prefixes.
        StringBuilder commonPrefixString = new StringBuilder();
        int lengthSmallestWord = findLengthSmallestWord(strs);
        int index = 0;
        boolean isSameChar = true;
        while (index < lengthSmallestWord) {
            for (int i = 0; i < strs.length; i++) {
                // Check if character at same indexes are same for all strings.
                if (strs[0].charAt(index) != strs[i].charAt(index)) {
                    isSameChar = false;
                    break;
                }
            }
            // If characters at same index are same, then append it to result.
            if (isSameChar) {
                commonPrefixString.append(strs[0].charAt(index));
            } else {
                break;
            }
            index++;
        }
        return new String(commonPrefixString);
    }

    // Find string with minimum length.
    // Time complexity : O(n) | Space complexity : O(1)
    public static int findLengthSmallestWord(String[] strs) {
        int minLength = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        return minLength;
    }
}
