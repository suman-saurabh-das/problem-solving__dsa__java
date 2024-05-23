package math.leetcode;

/*
    268. Missing number
    https://leetcode.com/problems/missing-number/description/

    Input: nums = [3,0,1]
    Output: 2
    Input: nums = [0,1]
    Output: 2
    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
*/

public class P003_Missing_number {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 3}, nums2 = {0, 1}, nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing number is : " + missingNumber(nums1));
        System.out.println("Missing number is : " + missingNumber(nums2));
        System.out.println("Missing number is : " + missingNumber(nums3));
    }

    // SOLUTION USING MATH
    // Time complexity : O(n) | Space complexity : O(1)
    public static int missingNumber(int[] nums) {
        // Since we know that the numbers are distinct and are in the range 0 to n
        // So, we find the sum of all numbers in range (s1) and find the sum of all elements (s2)
        // The missing element will be the result of  (s1 - s2)
        // as it will be the only number not present in array.
        int n = nums.length, sumOfElementsInArray = 0;
        int sumOfRange = (n * (n + 1)) / 2;
        for (int i = 0; i < nums.length; i++) {
            sumOfElementsInArray = sumOfElementsInArray + nums[i];
        }
        return sumOfRange - sumOfElementsInArray;
    }
}
