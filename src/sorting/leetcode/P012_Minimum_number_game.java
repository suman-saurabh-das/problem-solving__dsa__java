package sorting.leetcode;

/*
    2974. Minimum number game
    https://leetcode.com/problems/minimum-number-game/description/

    Input: nums = [5,4,2,3]
    Output: [3,2,5,4]
    Input: nums = [2,5]
    Output: [5,2]
*/

import java.util.Arrays;

public class P012_Minimum_number_game {
    public static void main(String[] args) {
        int[] nums1 = {5, 4, 2, 3}, nums2 = {2, 5};
        System.out.println("Minimum numbers : " + Arrays.toString(numberGame(nums1)));
        System.out.println("Minimum numbers : " + Arrays.toString(numberGame(nums2)));
    }

    // SOLUTION USING SELECTION SORT
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int[] numberGame(int[] nums) {
        selectionSort(nums);
        // Swap the elements at adjacent positions. (i & i+1)
        for (int i = 0; i < nums.length; i = i + 2) {
            swap(nums, i, i + 1);
        }
        return nums;
    }

    // Selection sort.
    // Time complexity : O(n²) | Space complexity : O(1)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lastElementIndex = arr.length - 1 - i;
            int maxElementIndex = findMaxElementIndex(arr, lastElementIndex);
            swap(arr, maxElementIndex, lastElementIndex);
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
