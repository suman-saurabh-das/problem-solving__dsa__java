package array.leetcode;

/*
    2535. Difference between element sum and digit sum of an array
    https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/

    Input: nums = [1,15,6,3]
    Output: 9
    Input: nums = [1,2,3,4]
    Output: 0
*/

public class P021_Difference_between_element_sum_and_digit_sum_of_an_array {
    public static void main(String[] args) {
        int[] nums1 = {1, 15, 6, 3}, nums2 = {1, 2, 3, 4};
        System.out.println("Difference between element sum and digit sum is : " + differenceOfSum(nums1));
        System.out.println("Difference between element sum and digit sum is : " + differenceOfSum(nums2));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int differenceOfSum(int[] nums) {
        int elementSum = 0, digitSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Calculate sum of all numbers in array.
            elementSum = elementSum + nums[i];
            // Calculate sum of digits of all numbers in array.
            digitSum = digitSum + findDigitSum(nums[i]);
        }
        return Math.abs(elementSum - digitSum);
    }

    // Find sum of digit in a number
    // Time complexity : O(n) | Space complexity : O(1)
    public static int findDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }
}
