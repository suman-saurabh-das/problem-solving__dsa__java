package math.leetcode;

/*
    2220. Minimum bit flips to convert number
    https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/

    Input: start = 10, goal = 7
    Output: 3
    Input: start = 3, goal = 4
    Output: 3
*/

public class P009_Minimum_bit_flips_to_convert_number {
    public static void main(String[] args) {
        int start1 = 10, goal1 = 7, start2 = 3, goal2 = 4;
        System.out.println("Minimum number of bit flips : " + minBitFlips(start1, goal1));
        System.out.println("Minimum number of bit flips : " + minBitFlips(start2, goal2));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(log(n)) | Space complexity : O(1)
    // where n is the number of digits in binary representation of result of start XOR goal.
    public static int minBitFlips(int start, int goal) {
        // Find the XOR of start and goal.
        int result = start ^ goal;
        // Now number of set bits in result will be equal to,
        // number of flips required to convert start to goal.
        int numFlips = 0;
        while (result > 0) {
            int lastDigit = result & 1;
            if (lastDigit == 1) {
                numFlips++;
            }
            result = result >> 1;
        }
        return numFlips;
    }
}
