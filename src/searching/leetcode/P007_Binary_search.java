package searching.leetcode;

/*
    704. Binary search
    https://leetcode.com/problems/binary-search/description/

    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
*/

public class P007_Binary_search {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 3, 5, 9, 12}, nums2 = {5};
        int target1 = 9, target2 = 2, target3 = 5;
        System.out.println("Element is at index : " + search(nums1, target1));
        System.out.println("Element is at index : " + search(nums1, target2));
        System.out.println("Element is at index : " + search(nums2, target3));
    }

    // SOLUTION USING BINARY SEARCH - time complexity : O(log(n))
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If mid-element is greater than target, search in left half.
            if (nums[mid] > target) {
                end = mid - 1;
            }
            // If mid-element is lesser than target, search in right half.
            else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid; // target is found.
            }
        }
        return -1;  // target is not found.
    }
}
