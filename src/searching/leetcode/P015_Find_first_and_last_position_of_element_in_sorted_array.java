package searching.leetcode;

/*
    34. Find first and last position of element in sorted array
    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]
    Input: nums = [], target = 0
    Output: [-1,-1]
*/

import java.util.Arrays;

public class P015_Find_first_and_last_position_of_element_in_sorted_array {
    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10}, nums2 = {};
        int target1 = 8, target2 = 6, target3 = 0;
        System.out.println("First and last position are : " + Arrays.toString(searchRange(nums1, target1)));
        System.out.println("First and last position are : " + Arrays.toString(searchRange(nums1, target2)));
        System.out.println("First and last position are : " + Arrays.toString(searchRange(nums2, target3)));
    }

    // SOLUTION USING BINARY SEARCH
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = binarySearch(nums, target, true);
        int lastPosition = binarySearch(nums, target, false);
        return new int[]{firstPosition, lastPosition};
    }

    // Binary search.
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int binarySearch(int[] arr, int target, boolean isFirstElement) {
        int start = 0, end = arr.length - 1, index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                // If element is found at mid, then assign it to mid.
                index = mid;
                // If we are finding the first element,
                // then check further for target in LHS.
                if (isFirstElement) {
                    end = mid - 1;
                }
                // If we are finding the last element,
                // then check further for target in RHS.
                else {
                    start = mid + 1;
                }
            }
        }
        // At the end, index will point to the
        return index;
    }
}
