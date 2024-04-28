package array.leetcode;

/*
    1929. Concatenation of array
    https://leetcode.com/problems/concatenation-of-array/description/

    Input: nums = [1,2,1]
    Output: [1,2,1,1,2,1]
    Input: nums = [1,3,2,1]
    Output: [1,3,2,1,1,3,2,1]
*/

import java.util.Arrays;

public class P001_Concatenation_of_array {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1}, nums2 = {1, 3, 2, 1};
        System.out.println("Concatenated array : " + Arrays.toString(getConcatenation(nums1)));
        System.out.println("Concatenated array : " + Arrays.toString(getConcatenation(nums2)));
    }

    // SOLUTION USING LOOP - time complexity : O(n)
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        // Array of length double the size of nums
        int[] resultArray = new int[n * 2];
        // Loop to insert elements at i and n+i positions
        for (int i = 0; i < nums.length; i++) {
            resultArray[i] = nums[i];
            resultArray[i + n] = nums[i];
        }
        return resultArray;
    }
}
