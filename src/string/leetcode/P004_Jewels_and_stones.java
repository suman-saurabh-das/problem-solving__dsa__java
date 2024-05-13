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

    // SOLUTION USING LOOP - time complexity : O(n^2)
    // Here time complexity is O(n^2) because indexOf() method,
    // uses an internal loop to check for elements.
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
