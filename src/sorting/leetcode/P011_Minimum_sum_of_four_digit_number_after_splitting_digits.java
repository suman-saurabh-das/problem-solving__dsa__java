package sorting.leetcode;

/*
    2160. Minimum sum of four digit number after splitting digits
    https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/

    Input: num = 2932
    Output: 52
    Input: num = 4009
    Output: 13
*/

public class P011_Minimum_sum_of_four_digit_number_after_splitting_digits {
    public static void main(String[] args) {
        int num1 = 2932, num2 = 4009;
        System.out.println("Minimum sum is : " + minimumSum(num1));
        System.out.println("Minimum sum is : " + minimumSum(num2));
    }

    // SOLUTION USING BUBBLE SORT & LOOP
    // Time complexity : O(n²) | Space complexity : O(n)
    public static int minimumSum(int num) {
        int[] numsArr = new int[4];
        // Create an array containing digits of the number num.
        for (int i = 0; i < 4; i++) {
            numsArr[i] = num % 10;
            num = num / 10;
        }
        // Sort the array.
        bubbleSort(numsArr);
        // Create the minimum number possible numbers from numArr.
        int num1 = numsArr[0] * 10 + numsArr[2];
        int num2 = numsArr[1] * 10 + numsArr[3];
        return num1 + num2;
    }

    // Bubble sort
    // Time complexity : O(n²) | Space complexity : O(1)
    public static void bubbleSort(int[] arr) {
        boolean isSwapped;
        for (int i = 0; i < arr.length; i++) {
            isSwapped = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
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
