package searching.leetcode;

/*
    162. Find peak element
    https://leetcode.com/problems/find-peak-element/description/

    Input: nums = [1,2,3,1]
    Output: 2
    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
*/

public class P017_Find_peak_element {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1}, nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak element is at index : " + findPeakElement(nums1));
        System.out.println("Peak element is at index : " + findPeakElement(nums2));
    }

    // SOLUTION USING BINARY SEARCH
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;    // We are in the ascending part of the array.
            } else {
                end = mid;          // We are in the descending part of the array.
            }
        }
        // Here start and end are equal and we have found the index of greatest element.
        return start;
    }
}
