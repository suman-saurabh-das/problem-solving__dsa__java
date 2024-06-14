package sorting.leetcode;

/*
    1877. Minimize maximum pair sum in array
    https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
    NOTE - This solution gives time limit exceeded error for large arrays.

    Input: nums = [3,5,2,3]
    Output: 7
    Input: nums = [3,5,4,2,4,6]
    Output: 8
*/

public class P018_Minimize_maximum_pair_sum_in_array {
    public static void main(String[] args) {
        int[] nums1 = {3, 5, 2, 3}, nums2 = {3, 5, 4, 2, 4, 6};
        System.out.println("Minimized maximum pair sum : " + minPairSum(nums1));
        System.out.println("Minimized maximum pair sum : " + minPairSum(nums2));
    }

    // SOLUTION USING SELECTION SORT
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int minPairSum(int[] nums) {
        // Sort the array.
        selectionSort(nums);
        // In order to minimize the sum of pairs,
        // we can create pairs like (1st, nth), (2nd, n-1th)...
        // Now find the maximum sum in these pairs.
        // In 2nd e.g. pairs will be : (2,6), (3,5), (4,4)
        int minimizedMaxSum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[i] + nums[nums.length - 1 - i] > minimizedMaxSum) {
                minimizedMaxSum = nums[i] + nums[nums.length - 1 - i];
            }
        }
        return minimizedMaxSum;
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
