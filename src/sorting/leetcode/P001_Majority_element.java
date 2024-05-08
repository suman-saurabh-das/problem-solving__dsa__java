package sorting.leetcode;

/*
    169. Majority element
    https://leetcode.com/problems/majority-element/description/

    Input: nums = [3,2,3]
    Output: 3
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2
*/

public class P001_Majority_element {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3}, nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority element is : " + majorityElement(nums1));
        System.out.println("Majority element is : " + majorityElement(nums2));
    }

    // SOLUTION USING BUBBLE SORT - time complexity - O(n^2)
    public static int majorityElement(int[] nums) {
        // Since the majority element occurs more than n/2 times.
        // Hence, the majority element can always be found at mid-position after sorting.
        bubbleSort(nums);
        return nums[nums.length / 2];
    }

    // Bubble sort - time complexity O(n^2)
    public static void bubbleSort(int[] arr) {
        // External loop will run for n-1 times.
        // It will count the number of passes.
        boolean isSwapped;
        for (int i = 0; i < arr.length; i++) {
            isSwapped = false;
            // Internal loop will run for n-i-1 times.
            // It will compare the elements and after complete iteration, the largest element will be at end.
            for (int j = 0; j < arr.length - i - 1; j++) {
                // Swap if current element is smaller than previous element.
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }
            // Array is sorted, so break out of loop, no need to check further.
            if (!isSwapped) {
                break;
            }
        }
    }

    // Swap array elements using index.
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
