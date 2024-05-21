package array.leetcode;

/*
    1313. Decompress run-length encoded list
    https://leetcode.com/problems/decompress-run-length-encoded-list/description/

    Input: nums = [1,2,3,4]
    Output: [2,4,4,4]
    Input: nums = [1,1,2,3]
    Output: [1,3,3]
*/

import java.util.Arrays;
import java.util.ArrayList;

public class P019_Decompress_run_length_encoded_list {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4}, nums2 = {1, 1, 2, 3};
        System.out.println("Decompressed list : " + Arrays.toString((decompressRLElist(nums1))));
        System.out.println("Decompressed list : " + Arrays.toString((decompressRLElist(nums2))));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n + m) | Space complexity : O(m)
    // where n - length of nums array, m - total number of elements to add.
    public static int[] decompressRLElist(int[] nums) {
        // Array list to store the values, based on the frequency.
        ArrayList<Integer> decompressedList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // Add value to Array list as many times as frequency.
            int frequency = nums[i];
            while (frequency > 0) {
                decompressedList.add(nums[i + 1]);
                frequency--;
            }
            i++;
        }
        return convertArrayListToArray(decompressedList);
    }

    // Convert integer array list to array
    // Time complexity : O(m) | Space complexity : O(m)
    public static int[] convertArrayListToArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
