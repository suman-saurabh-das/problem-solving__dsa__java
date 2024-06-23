package string.leetcode;

/*
    1528. Shuffle string
    https://leetcode.com/problems/shuffle-string/description/

    Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
    Output: "leetcode"
    Input: s = "abc", indices = [0,1,2]
    Output: "abc"
*/

public class P018_Shuffle_string {
    public static void main(String[] args) {
        String s1 = "codeleet", s2 = "abc";
        int[] indices1 = {4, 5, 6, 7, 0, 2, 1, 3}, indices2 = {0, 1, 2};
        System.out.println("Shuffle string : " + restoreString(s1, indices1));
        System.out.println("Shuffle string : " + restoreString(s2, indices2));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(1)
    public static String restoreString(String s, int[] indices) {
        char[] chArr = new char[indices.length];
        // Create a new character array by populating characters,
        // from string s at positions using indices array.
        for (int i = 0; i < chArr.length; i++) {
            chArr[indices[i]] = s.charAt(i);
        }
        return new String(chArr);
    }
}
