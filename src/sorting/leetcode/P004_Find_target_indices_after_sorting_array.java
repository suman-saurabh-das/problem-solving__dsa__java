package sorting.leetcode;

/*
    2089. Find target indices after sorting array
    https://leetcode.com/problems/find-target-indices-after-sorting-array/description/

    Input: nums = [1,2,5,2,3], target = 2
    Output: [1,2]
    Input: nums = [1,2,5,2,3], target = 3
    Output: [3]
    Input: nums = [1,2,5,2,3], target = 5
    Output: [4]
*/

import java.util.ArrayList;

public class P004_Find_target_indices_after_sorting_array {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2, 3};
        int target1 = 2, target2 = 3, target3 = 5;
        System.out.println("Indices are : " + targetIndices(nums, target1));
        System.out.println("Indices are : " + targetIndices(nums, target2));
        System.out.println("Indices are : " + targetIndices(nums, target3));
    }

    // SOLUTION USING BUBBLE SORT
    // Time complexity : O(n²) | Space complexity : O(n)
    public static ArrayList<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer> indicesArr = new ArrayList<>();
        // Sort the elements in array.
        bubbleSort(nums);
        // Find the indexes of target in sorted array and add it to ArrayList.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indicesArr.add(i);
            }
        }
        return indicesArr;
    }

    // Bubble Sort.
    // Time complexity : O(n²) | Space complexity : O(1)
    public static void bubbleSort(int[] arr) {
        boolean isSwapped;
        for (int i = 0; i < arr.length; i++) {
            isSwapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
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
