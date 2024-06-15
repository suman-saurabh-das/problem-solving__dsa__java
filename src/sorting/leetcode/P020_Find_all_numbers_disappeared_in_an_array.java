package sorting.leetcode;

/*
    448. Find all numbers disappeared in an array
    https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

    Input: nums = [4,3,2,7,8,2,3,1]
    Output: [5,6]
    Input: nums = [1,1]
    Output: [2]
*/

import java.util.ArrayList;

public class P020_Find_all_numbers_disappeared_in_an_array {
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1}, nums2 = {1, 1};
        System.out.println("Disappeared numbers are : " + findDisappearedNumbers(nums1));
        System.out.println("Disappeared numbers are : " + findDisappearedNumbers(nums2));
    }

    // SOLUTION USING CYCLIC SORT
    // Time complexity : O(n) | Space complexity : O(1)
    public static ArrayList<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> disappearedNumbers = new ArrayList<>();
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            // Looping through the array and adding numbers which disappeared.
            if (nums[i] != i + 1) {
                disappearedNumbers.add(i + 1);
            }
        }
        return disappearedNumbers;
    }

    // Cyclic sort.
    // Time complexity : O(n) | Space complexity : O(1)
    public static void cyclicSort(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            // Since array ranges from [1,n], correct index will be element - 1
            int correctIndex = arr[index] - 1;
            // If element is not at correct index then swap,
            // else increment counter and check for next element.
            if (arr[index] != arr[correctIndex]) {
                int temp = arr[index];
                arr[index] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                index++;
            }
        }
    }
}
