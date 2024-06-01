package searching.leetcode;

/*
    852. Peak index in a mountain array
    https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

    Input: arr = [0,1,0]
    Output: 1
    Input: arr = [0,2,1,0]
    Output: 1
    Input: arr = [0,10,5,2]
    Output: 1
*/

public class P016_Peak_index_in_a_mountain_array {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0}, arr2 = {0, 2, 1, 0}, arr3 = {0, 10, 5, 2};
        System.out.println("Peak index is : " + peakIndexInMountainArray(arr1));
        System.out.println("Peak index is : " + peakIndexInMountainArray(arr2));
        System.out.println("Peak index is : " + peakIndexInMountainArray(arr3));
    }

    // SOLUTION USING BINARY SEARCH
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // We are in descending part of the array.
            // This might be the possible answer, but we need to check in the left part of the array.
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            }
            // We are in ascending part of the array.
            // We need to check in the right part of the.
            else {
                start = mid + 1;
            }
        }
        // At the end, start and end will be same and point to the largest number.
        // start and end pointers are always trying to find the max element in above 2 checks
        // hence when they are pointing to same element, i.e. the maximum one.
        return start;
    }
}
