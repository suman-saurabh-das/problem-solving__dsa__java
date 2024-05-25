package sorting.leetcode;

/*
    1630. Arithmetic subarrays
    https://leetcode.com/problems/arithmetic-subarrays/description/

    Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
    Output: [true,false,true]
    Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
    Output: [false,true,false,false,true,true]
 */

import java.util.ArrayList;
import java.util.Arrays;

public class P009_Arithmetic_subarrays {
    public static void main(String[] args) {
        int[] nums1 = {4, 6, 5, 9, 3, 7}, nums2 = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
        int[] l1 = {0, 0, 2}, l2 = {0, 1, 6, 4, 8, 7};
        int[] r1 = {2, 3, 5}, r2 = {4, 4, 9, 7, 9, 10};
        System.out.println("Arithmetic subarrays : " + checkArithmeticSubarrays(nums1, l1, r1));
        System.out.println("Arithmetic subarrays : " + checkArithmeticSubarrays(nums2, l2, r2));
    }

    // SOLUTION USING INSERTION SORT
    // Time complexity : O(m * n²) | Space complexity : O(n)
    // where m is the length of l array, n is the length of subArray.
    public static ArrayList<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> listOfArithmeticSubarrays = new ArrayList<>();
        // Number of sub-arrays to be checked will be equal to length of l or r
        for (int i = 0; i < l.length; i++) {
            // Create a sub-array from nums with elements starting at index l[i] to index r[i]
            int[] subArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            // Sort the elements in sub-array
            insertionSort(subArray);
            // Check if sub-array is arithmetic and add result to ArrayList
            listOfArithmeticSubarrays.add(isArithmeticSubarray(subArray));
        }
        return listOfArithmeticSubarrays;
    }

    // Check if array is arithmetic.
    // Time complexity : O(n) | Space complexity : O(1)
    public static boolean isArithmeticSubarray(int[] arr) {
        // An array is arithmetic, if it consists of at least two elements,
        // and the difference between every two consecutive elements is the same.
        boolean isArithmetic = true;
        int difference = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != difference) {
                isArithmetic = false;
                break;
            }
        }
        return isArithmetic;
    }

    // Insertion sort
    // Time complexity : O(n²) | Space complexity : O(1)
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
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
