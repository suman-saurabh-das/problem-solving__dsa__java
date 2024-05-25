package string.leetcode;

/*
    771. Jewels and stones
    https://leetcode.com/problems/jewels-and-stones/description/

    Input: jewels = "aA", stones = "aAAbbbb"
    Output: 3
    Input: jewels = "z", stones = "ZZ"
    Output: 0
*/

public class P004_Jewels_and_stones {
    public static void main(String[] args) {
        String jewels1 = "aA", stones1 = "aAAbbbb", jewels2 = "z", stones2 = "ZZ";
        System.out.println("Number of jewels : " + numJewelsInStones(jewels1, stones1));
        System.out.println("Number of jewels : " + numJewelsInStones(jewels2, stones2));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(m * n) | Space complexity : O(1)
    // where m is length of stones array and n is length of jewels array.
    // Here time complexity is O(m * n) because indexOf() method, uses an internal loop to check for elements.
    public static int numJewelsInStones(String jewels, String stones) {
        int numJewels = 0;
        for (int i = 0; i < stones.length(); i++) {
            // If jewels string has the char at index i, increment numJewels.
            if (jewels.indexOf(stones.charAt(i)) != -1) {
                numJewels++;
            }
        }
        return numJewels;
    }
}
