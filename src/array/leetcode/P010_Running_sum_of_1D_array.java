package array.leetcode;

/*
    1480. Running sum of 1D array
    https://leetcode.com/problems/running-sum-of-1d-array/description/

    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Input: nums = [1,1,1,1,1]
    Output: [1,2,3,4,5]
    Input: nums = [3,1,2,10,1]
    Output: [3,4,6,16,17]
*/

import java.util.Arrays;

public class P010_Running_sum_of_1D_array {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4}, nums2 = {1, 1, 1, 1, 1}, nums3 = {3, 1, 2, 10, 1};
        System.out.println("Running sum array : " + Arrays.toString(runningSum(nums1)));
        System.out.println("Running sum array : " + Arrays.toString(runningSum(nums2)));
        System.out.println("Running sum array : " + Arrays.toString(runningSum(nums3)));
    }

    // SOLUTION USING LOOP - time complexity - O(n)
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // To get running sum, we add the previous element with current element
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
