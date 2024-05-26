package searching.leetcode;

/*
    2529. Maximum count of positive integer and negative integer
    https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/

    Input: nums = [-2,-1,-1,1,2,3]
    Output: 3
    Input: nums = [-3,-2,-1,0,0,1,2]
    Output: 3
    Input: nums = [5,20,66,1314]
    Output: 4
*/

public class P009_Maximum_count_of_positive_and_negative_integer {
    public static void main(String[] args) {
        int[] nums1 = {-2, -1, -1, 1, 2, 3}, nums2 = {-3, -2, -1, 0, 0, 1, 2}, nums3 = {5, 20, 66, 1314};
        System.out.println("Maximum count is : " + maximumCount(nums1));
        System.out.println("Maximum count is : " + maximumCount(nums2));
        System.out.println("Maximum count is : " + maximumCount(nums3));
    }

    // SOLUTION USING BINARY SEARCH
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int maximumCount(int[] nums) {
        int countOfPositiveNums = nums.length - indexOfMinPositiveNum(nums);
        int countOfNegativeNums = indexOfMaxNegativeNum(nums) + 1;
        // Return the max of (countOfPositiveNums, countOfNegativeNums)
        return Math.max(countOfPositiveNums, countOfNegativeNums);
    }

    // Binary search to find index of max negative number.
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int indexOfMaxNegativeNum(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If mid-element is +ve or 0, check in left half.
            // If mid-element is -ve (potential ans), check in right half.
            if (arr[mid] >= 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // end will point to index of max negative number.
        return end;
    }

    // Binary search to find index of min positive number.
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int indexOfMinPositiveNum(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If mid-element is -ve or 0, check in right half.
            // If mid-element is +ve (potential ans), check in left half.
            if (arr[mid] <= 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // start will point to index of min positive number.
        return start;
    }
}
