package searching.leetcode;

/*
    1346. Check if n and its double exist
    https://leetcode.com/problems/check-if-n-and-its-double-exist/description/

    Input: arr = [10,2,5,3]
    Output: true
    Input: arr = [3,1,7,11]
    Output: false
*/

public class P008_Check_if_n_and_its_double_exist {
    public static void main(String[] args) {
        int[] arr1 = {10, 2, 5, 3}, arr2 = {3, 1, 7, 11};
        System.out.println("Number and its double exists : " + checkIfExist(arr1));
        System.out.println("Number and its double exists : " + checkIfExist(arr2));
    }

    // SOLUTION USING BINARY SEARCH AND INSERTION SORT
    // Time complexity : O(n²) + O(n * log(n)) = O(n²) | Space complexity : O(1)
    public static boolean checkIfExist(int[] arr) {
        boolean doubleExists = false;
        // Sorting the array
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            // Binary search to find if double of a number exists, such that
            // arr[i] = arr[j] * 2 and i != j
            doubleExists = binarySearch(arr, arr[i] * 2, i);
            if (doubleExists) {
                break;
            }
        }
        return doubleExists;
    }

    // Binary search
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static boolean binarySearch(int[] arr, int target, int i) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Applying the check mid != i to ensure that the same element is not found.
            // e.g. in case of 0, 0 * 2 will be zero hence it will check if index is different.
            if (arr[mid] == target & mid != i) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
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

    // Swap array elements using index
    // Time complexity : O(1) | Space complexity : O(1)
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
