package searching.leetcode;

/*
    1095. Find in mountain array
    https://leetcode.com/problems/find-in-mountain-array/description/

    Input: array = [1,2,3,4,5,3,1], target = 3
    Output: 2
    Input: array = [0,1,2,4,2,1], target = 3
    Output: -1
*/

public class P018_Find_in_mountain_array {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,3,1}, array2 = {0,1,2,4,2,1};
        int target = 3;
        System.out.println("Element is at index : "+findInMountainArray(array1, target));
        System.out.println("Element is at index : "+findInMountainArray(array2, target));
    }

    public static int findInMountainArray(int[] arr, int target) {
        // Find the peak element.
        int peakElementIndex = findPeakElement(arr);
        // Check if target element lies in ascending part of array.
        int result = orderAgnosticBS(arr, 0, peakElementIndex, target);
        if (result == -1) {
            // Check if target element lies in descending part of array.
            result = orderAgnosticBS(arr, peakElementIndex, arr.length - 1, target);
        }
        return result;
    }

    // Binary search to find peak element.
// Time complexity : O(log(n)) | Space complexity : O(1)
    public static int findPeakElement(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;    // We are in the ascending part of the array.
            } else {
                end = mid;          // We are in the descending part of the array.
            }
        }
        // Here start and end are equal, and we have found the index of greatest element.
        return start;
    }

    // Order agnostic binary search
// Time complexity : O(log(n)) | Space complexity : O(1)
    public static int orderAgnosticBS(int[] arr, int start, int end, int target) {
        boolean isAscending = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            // Finding the element in ascending part of array.
            if (isAscending) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Finding the element in descending part of array.
            else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

// SOLUTION USING MOUNTAIN ARRAY API
/*
public int findInMountainArray(int target, MountainArray mountainArr) {
    // Find the peak element.
    int peakElementIndex = findPeakElement(mountainArr);
    System.out.println(peakElementIndex);
    // Check if target element lies in ascending part of array.
    int result = orderAgnosticBS(mountainArr, 0, peakElementIndex, target);
    if (result == -1) {
        // Check if target element lies in descending part of array.
        result = orderAgnosticBS(mountainArr, peakElementIndex, mountainArr.length() - 1, target);
    }
    return result;
}

// Binary search to find peak element.
// Time complexity : O(log(n)) | Space complexity : O(1)
public int findPeakElement(MountainArray arr) {
    int start = 0, end = arr.length() - 1;

    while (start < end) {
        int mid = start + (end - start) / 2;
        if (arr.get(mid) < arr.get(mid + 1)) {
            start = mid + 1;    // We are in the ascending part of the array.
        } else {
            end = mid;          // We are in the descending part of the array.
        }
    }
    // Here start and end are equal and we have found the index of greatest element.
    return start;
}

// Order agnostic binary search
// Time complexity : O(log(n)) | Space complexity : O(1)
public static int orderAgnosticBS(MountainArray arr, int start, int end, int target) {
    boolean isAscending = arr.get(start) < arr.get(end);
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (arr.get(mid) == target) {
            return mid;
        }
        // Finding the element in ascending part of array.
        if (isAscending) {
            if (arr.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // Finding the element in descending part of array.
        else {
            if (arr.get(mid) > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    return -1;
}
*/