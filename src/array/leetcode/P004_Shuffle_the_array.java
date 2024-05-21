package array.leetcode;

import java.util.Arrays;

/*
    1470. Shuffle the array
    https://leetcode.com/problems/shuffle-the-array/description/

    Input: nums = [2,5,1,3,4,7], n = 3
    Output: [2,3,5,4,1,7]
    Input: nums = [1,2,3,4,4,3,2,1], n = 4
    Output: [1,4,2,3,3,2,4,1]
    Input: nums = [1,1,2,2], n = 2
    Output: [1,2,1,2]
*/

public class P004_Shuffle_the_array {
    public static void main(String[] args) {
        int[] nums1 = {2, 5, 1, 3, 4, 7}, nums2 = {1, 2, 3, 4, 4, 3, 2, 1}, nums3 = {1, 1, 2, 2};
        int n1 = 3, n2 = 4, n3 = 2;
        System.out.println("Shuffled array : " + Arrays.toString(shuffle(nums1, n1)));
        System.out.println("Shuffled array : " + Arrays.toString(shuffle(nums2, n2)));
        System.out.println("Shuffled array : " + Arrays.toString(shuffle(nums3, n3)));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(n)
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        // Insert elements at 2*i and 2*i+1 positions.
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }
}
