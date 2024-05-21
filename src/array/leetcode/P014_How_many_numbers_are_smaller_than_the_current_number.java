package array.leetcode;

/*
    1365. How many numbers are smaller than the current number
    https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/

    Input: nums = [8,1,2,2,3]
    Output: [4,0,1,1,3]
    Input: nums = [6,5,4,8]
    Output: [2,1,0,3]
    Input: nums = [7,7,7,7]
    Output: [0,0,0,0]
*/

import java.util.Arrays;

public class P014_How_many_numbers_are_smaller_than_the_current_number {
    public static void main(String[] args) {
        int[] nums1 = {8, 1, 2, 2, 3}, nums2 = {6, 5, 4, 8}, nums3 = {7, 7, 7, 7};
        System.out.println("Count of numbers are : " + Arrays.toString(smallerNumbersThanCurrent(nums1)));
        System.out.println("Count of numbers are : " + Arrays.toString(smallerNumbersThanCurrent(nums2)));
        System.out.println("Count of numbers are : " + Arrays.toString(smallerNumbersThanCurrent(nums3)));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n²) | Space complexity : O (n)
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // Set count to 0 for every number we check.
            int count = 0;
            // Check for all elements which are smaller than
            // current element and increment count. (i != j)
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]) {
                    count++;
                }
            }
            // Add final count to result array.
            resultArr[i] = count;
        }
        return resultArr;
    }
}
