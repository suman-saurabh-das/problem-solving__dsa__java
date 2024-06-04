package searching.leetcode;

/*
    33. Search in rotated sorted array
    https://leetcode.com/problems/search-in-rotated-sorted-array/description/

    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
    Input: nums = [1], target = 0
    Output: -1
*/

public class P019_Search_in_rotated_sorted_array {
    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2}, nums2 = {1};
        int target1 = 0, target2 = 3;
        System.out.println("Element is at index : " + search(nums1, target1));
        System.out.println("Element is at index : " + search(nums1, target2));
        System.out.println("Element is at index : " + search(nums2, target1));
    }

    // SOLUTION USING BINARY SEARCH
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int search(int[] nums, int target) {
        int pivotElementIndex = findPivotIndex(nums);
        // If pivotElementIndex is -1, array is not rotated.
        if (pivotElementIndex == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        // If pivotElementIndex is equal to target, return pivotElementIndex.
        else if (nums[pivotElementIndex] == target) {
            return pivotElementIndex;
        }
        // Target element lies in second half.
        else if (nums[0] > target) {
            return binarySearch(nums, pivotElementIndex + 1, nums.length - 1, target);
        }
        // Target element lies in first half.
        else {
            return binarySearch(nums, 0, pivotElementIndex, target);
        }
    }

    // Find pivot element.
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int findPivotIndex(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Case 1 - We have found the pivot element in array.
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // Case 2 - We have found the pivot element in array.
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }
            // Case 3 - pivot element will lie between start and mid-1
            if (arr[start] > arr[mid]) {
                end = mid - 1;
            }
            // Case 4 - pivot element will lie between mid+1 and end.
            else {
                start = mid + 1;
            }
        }
        // If we have not found pivot then it means array is not rotated.
        return -1;
    }

    // Binary search.
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
