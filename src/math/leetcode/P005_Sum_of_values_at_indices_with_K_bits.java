package math.leetcode;

/*
    2859. Sum of values at indices with K set bits
    https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/

    Input: nums = [5,10,1,5,2], k = 1
    Output: 13
    Input: nums = [4,3,2,1], k = 2
    Output: 1
*/

import java.util.Arrays;
import java.util.ArrayList;

public class P005_Sum_of_values_at_indices_with_K_bits {
    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(5, 10, 1, 5, 2));
        ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        int k1 = 1, k2 = 2;
        System.out.println("Sum of values : " + sumIndicesWithKSetBits(nums1, k1));
        System.out.println("Sum of values : " + sumIndicesWithKSetBits(nums2, k2));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n * log(m)) | Space complexity : O(1)
    public static int sumIndicesWithKSetBits(ArrayList<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            // Find the number of set bits in the index.
            int numSetBits = findNumSetBits(i);

            // If the number of set bits in index is equal to k,
            // then add the number at that index to sum.
            if (numSetBits == k) {
                sum = sum + nums.get(i);
            }
        }
        return sum;
    }

    // Find the number of setBits in a number.
    // Time complexity : O(log(m)) | Space complexity : O(1)
    // where m is the number of digits in the binary representation of number.
    public static int findNumSetBits(int num) {
        int numSetBits = 0;
        while (num > 0) {
            // Check if last digit is a set bit.
            int lastDigit = num & 1;
            // If last digit is a setbit, increment numSetBits.
            if (lastDigit == 1) {
                numSetBits++;
            }
            // Right shift the number by 1
            num = num >> 1;
        }
        return numSetBits;
    }
}
