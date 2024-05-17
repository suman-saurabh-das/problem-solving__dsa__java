package array.leetcode;

/*
    1295. Find numbers with even number of digits
    https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/

    Input: nums = [12,345,2,6,7896]
    Output: 2
    Input: nums = [555,901,482,1771]
    Output: 1
*/

public class P012_Find_numbers_with_even_number_of_digits {
    public static void main(String[] args) {
        int[] nums1 = {12, 345, 2, 6, 7896}, nums2 = {555, 901, 482, 1771};
        System.out.println("Numbers with even number of digits : " + findNumbers(nums1));
        System.out.println("Numbers with even number of digits : " + findNumbers(nums2));
    }

    // SOLUTION USING LOOP - time complexity : O(n)
    // Using optimized method to find number of digits in a number.
    public static int findNumbers(int[] nums) {
        // Check for every element in nums. If it has even number,
        // of digits, then increment numsWithEvenNumOfDigits.
        int numsWithEvenNumOfDigits = 0;
        for (int i = 0; i < nums.length; i++) {
            int numOfDigits = findNumOfDigits2(nums[i]);
            if (checkNumIsEven(numOfDigits)) {
                numsWithEvenNumOfDigits++;
            }
        }
        return numsWithEvenNumOfDigits;
    }

    // Check if number is even - time complexity : O(1)
    public static boolean checkNumIsEven(int num) {
        return num % 2 == 0;
    }

    // Find number of digits in a number - time complexity : O(n)
    public static int findNumOfDigits(int num) {
        if (num == 0) {
            return 1;
        }
        int numOfDigits = 0;
        while (num > 0) {
            num = num / 10;
            numOfDigits++;
        }
        return numOfDigits;
    }

    // Optimized method : Find number of digits in a number - time complexity : O(1)
    public static int findNumOfDigits2(int num) {
        if (num < 0) {
            num = num * -1;
        }
        return (int) Math.log10(num) + 1;
    }
}
