package math.leetcode;

/*
    136. Single Number
    https://leetcode.com/problems/single-number/description/

    Input: nums = [2,2,1]
    Output: 1
    Input: nums = [4,1,2,1,2]
    Output: 4
    Input: nums = [1]
    Output: 1
*/

public class P004_Single_number {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1}, nums2 = {4, 1, 2, 1, 2}, nums3 = {1};
        System.out.println("Number which appears once : " + singleNumber(nums1));
        System.out.println("Number which appears once : " + singleNumber(nums2));
        System.out.println("Number which appears once : " + singleNumber(nums3));
    }

    // SOLUTION USING MATH
    // Time complexity : O(n) | Space complexity : O(1)
    public static int singleNumber(int[] nums) {
        // Any number XOR with 0 is the number itself.
        // Any number XOR with number itself results in 0.
        // Bitwise operators follow associative property i.e. order of operation doesn't matter.
        // Hence, we can perform XOR operation with each element to find the unique number.
        int uniqueElement = 0;
        for (int i = 0; i < nums.length; i++) {
            uniqueElement = uniqueElement ^ nums[i];
        }
        return uniqueElement;
    }
}
