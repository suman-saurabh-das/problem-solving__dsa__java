package sorting.leetcode;

/*
    1913. Maximum product difference between two pairs
    https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/

    Input: nums = [5,6,2,7,4]
    Output: 34
    Input: nums = [4,2,5,9,7,4,8]
    Output: 64
*/

public class P015_Maximum_product_difference_between_two_pairs {
    public static void main(String[] args) {
        int[] nums1 = {5, 6, 2, 7, 4}, nums2 = {4, 2, 5, 9, 7, 4, 8};
        System.out.println("Maximum product difference is : " + maxProductDifference(nums1));
        System.out.println("Maximum product difference is : " + maxProductDifference(nums2));
    }

    // SOLUTION USING SELECTION SORT
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int maxProductDifference(int[] nums) {
        // Sort the array
        selectionSort(nums);
        // Maximum product difference between 2 pairs
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }

    // Selection sort.
    // Time complexity : O(n²) | Space complexity : O(1)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lastElementIndex = arr.length - 1 - i;
            int maxElementIndex = findMaxElementIndex(arr, lastElementIndex);
            swap(arr, lastElementIndex, maxElementIndex);
        }
    }

    // Find index of max element in array.
    // Time complexity : O(n) | Space complexity : O(1)
    public static int findMaxElementIndex(int[] arr, int end) {
        int maxElementIndex = 0;
        for (int i = 1; i <= end; i++) {
            if (arr[i] > arr[maxElementIndex]) {
                maxElementIndex = i;
            }
        }
        return maxElementIndex;
    }

    // Swap array elements using index.
    // Time complexity : O(1) | Space complexity : O(1)
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
