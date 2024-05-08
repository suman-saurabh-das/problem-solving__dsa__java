package sorting.leetcode;

/*
    217. Contains duplicate
    https://leetcode.com/problems/contains-duplicate/description/
    NOTE - This solution gives time limit exceeded error for large arrays.

    Input: nums = [1,2,3,1]
    Output: true
    Input: nums = [1,2,3,4]
    Output: false
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true
*/

public class P002_Contains_duplicate {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1}, nums2 = {1, 2, 3, 4}, nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Array contains duplicate : " + containsDuplicate(nums1));
        System.out.println("Array contains duplicate : " + containsDuplicate(nums2));
        System.out.println("Array contains duplicate : " + containsDuplicate(nums3));
    }

    // SOLUTION USING SELECTION SORT - time complexity : O(n^2)
    public static boolean containsDuplicate(int[] nums) {
        selectionSort(nums);    // Time limit exceeded error
        // Check if 2 consecutive elements are equal
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // Selection sort - time complexity : O(n^2)
    public static void selectionSort(int[] arr) {
        // External loop will run n-1 times.
        for (int i = 0; i < arr.length; i++) {
            // Find last index
            int lastElementIndex = arr.length - i - 1;
            // Find index of maximum element.
            int maxElementIndex = findMaxElementIndex(arr, lastElementIndex);
            // Swap max element with last element.
            swap(arr, maxElementIndex, lastElementIndex);
        }
    }

    // Find index of max element in array.
    public static int findMaxElementIndex(int[] arr, int end) {
        int maxElementIndex = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > arr[maxElementIndex]) {
                maxElementIndex = i;
            }
        }
        return maxElementIndex;
    }

    // Swap array elements using index.
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
