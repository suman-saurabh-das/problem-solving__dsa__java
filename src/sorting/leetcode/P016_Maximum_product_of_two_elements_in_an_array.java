package sorting.leetcode;

/*
    1464. Maximum product of two elements in an array
    https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/

    Input: nums = [3,4,5,2]
    Output: 12
    Input: nums = [1,5,4,5]
    Output: 16
    Input: nums = [3,7]
    Output: 12
*/

public class P016_Maximum_product_of_two_elements_in_an_array {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 2}, nums2 = {1, 5, 4, 5}, nums3 = {3, 7};
        System.out.println("Maximum product is : " + maxProduct(nums1));
        System.out.println("Maximum product is : " + maxProduct(nums2));
        System.out.println("Maximum product is : " + maxProduct(nums3));
    }

    // SOLUTION USING INSERTION SORT
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int maxProduct(int[] nums) {
        // Sort the array.
        insertionSort(nums);
        // Required maximum value.
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    // Insertion sort.
    // Time complexity : O(n²) | Space complexity : O(1)
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1 + i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    // Swap array elements using index.
    // Time complexity : O(1) | Space complexity : O(1)
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
