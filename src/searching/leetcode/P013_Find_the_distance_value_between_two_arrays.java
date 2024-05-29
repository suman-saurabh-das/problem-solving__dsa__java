package searching.leetcode;

/*
    1385. Find the distance value between two arrays
    https://leetcode.com/problems/find-the-distance-value-between-two-arrays/description/

    Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
    Output: 2
    Input: arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
    Output: 2
    Input: arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
    Output: 1
    Input: arr1 = [-8,-7], arr2 = [4,10,-4,5,2], d = 55
    Output: 0
*/

public class P013_Find_the_distance_value_between_two_arrays {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 8}, arr2 = {10, 9, 1, 8}, arr3 = {1, 4, 2, 3};
        int[] arr4 = {-4, -3, 6, 10, 20, 30}, arr5 = {2, 1, 100, 3}, arr6 = {-5, -2, 10, -3, 7};
        int[] arr7 = {-8, -7}, arr8 = {4, 10, -4, 5, 2};
        int d1 = 2, d2 = 3, d3 = 6, d4 = 55;
        System.out.println("Distance between 2 arrays : " + findTheDistanceValue(arr1, arr2, d1));
        System.out.println("Distance between 2 arrays : " + findTheDistanceValue(arr3, arr4, d2));
        System.out.println("Distance between 2 arrays : " + findTheDistanceValue(arr5, arr6, d3));
        System.out.println("Distance between 2 arrays : " + findTheDistanceValue(arr7, arr8, d4));
    }

    // SOLUTION USING QUICK SORT & BINARY SEARCH
    // Time complexity : O((m + n) * log(n)) | Space complexity : O(log(n))
    // where m is length of arr1 and n is length of arr2
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;

        // Sort array arr2 as we will be applying binary search on it.
        quickSort(arr2, 0, arr2.length - 1);

        // Find index of elements in arr1 closest to arr2 using binary search.
        for (int i = 0; i < arr1.length; i++) {
            // We are performing binary search m times so time complexity : O(m * log(n))
            int index = binarySearch(arr2, arr1[i], d);

            // If the difference is greater than d, then increment distance.
            if (Math.abs(arr1[i] - arr2[index]) > d) {
                distance++;
            }
        }
        return distance;
    }

    // BinarySearch
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int binarySearch(int[] arr, int target, int d) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // Edge case - If start pointer is at position arr.length, return end.
        // If end pointer is at position -1 , return start.
        if (start == arr.length) {
            return end;
        }
        if (end == -1) {
            return start;
        }

        // Check if the index of number closest to target is start or end.
        // Number will be closest if it has a lower difference.
        if (Math.abs(arr[start] - target) > Math.abs(arr[end] - target)) {
            return end;
        } else {
            return start;
        }
    }

    // Quick sort
    // Time complexity : O(n * log(n)) | Space complexity : O(log(n))
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        // low and high pointers determine which part of array we are working on.
        // start and end pointers are used for swapping the elements.
        int start = low, end = high, mid = start + (end - start) / 2;
        int pivot = arr[mid];
        // Placing pivot at correct index.
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            // If start is less than end and the above condition is violated,
            // then we swap the elements at start and end indexes.
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        // Sorting LHS and RHS of pivot.
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
