package array.leetcode;

/*
    2367. Number of arithmetic triplets
    https://leetcode.com/problems/number-of-arithmetic-triplets/description/

    Input: nums = [0,1,4,6,7,10], diff = 3
    Output: 2
    Input: nums = [4,5,6,7,8,9], diff = 2
    Output: 2
 */

public class P024_Number_of_arithmetic_triplets {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 4, 6, 7, 10}, nums2 = {4, 5, 6, 7, 8, 9};
        int diff1 = 3, diff2 = 2;
        System.out.println("Number of arithmetic triplets : " + arithmeticTriplets(nums1, diff1));
        System.out.println("Number of arithmetic triplets : " + arithmeticTriplets(nums2, diff2));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n³) | Space complexity : O(1)
    public static int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                // Check if element at index i and j has difference equal to diff.
                if (nums[j] - nums[i] == diff) {
                    for (int k = j + 1; k < nums.length; k++) {
                        // Check if element at index j and k has difference equal to diff.
                        if (nums[k] - nums[j] == diff) {
                            count++;
                        }
                        // If difference becomes more than diff, then break.
                        if (nums[k] - nums[j] > diff) {
                            break;
                        }
                    }
                }
                // If difference becomes more than diff, then break.
                if (nums[j] - nums[i] > diff) {
                    break;
                }
            }
        }
        return count;
    }
}
