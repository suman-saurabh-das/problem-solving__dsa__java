package array.leetcode;

/*
    2574. Left and right sum differences
    https://leetcode.com/problems/left-and-right-sum-differences/description/

    Input: nums = [10,4,8,3]
    Output: [15,1,11,22]
    Input: nums = [1]
    Output: [0]
*/

import java.util.Arrays;

public class P015_Left_and_right_sum_differences {
    public static void main(String[] args) {
        int[] nums1 = {10, 4, 8, 3}, nums2 = {1};
        System.out.println("Differences are : " + Arrays.toString(leftRightDifference(nums1)));
        System.out.println("Differences are : " + Arrays.toString(leftRightDifference(nums2)));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(n)
    public static int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        // First element of leftSum and last element of rightSum will be 0.
        leftSum[0] = 0;
        rightSum[nums.length - 1] = 0;

        // Calculate the elements in leftSum and rightSum arrays.
        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
            rightSum[j] = rightSum[j + 1] + nums[j + 1];
        }

        // Find absolute difference between elements of leftSum and rightSum,
        // then add the result to answer array.
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return ans;
    }
}
