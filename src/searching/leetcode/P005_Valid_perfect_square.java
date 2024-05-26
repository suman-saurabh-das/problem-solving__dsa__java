package searching.leetcode;

/*
    367. Valid perfect square
    https://leetcode.com/problems/valid-perfect-square/description/

    Input: num = 16
    Output: true
    Input: num = 14
    Output: false
*/

public class P005_Valid_perfect_square {
    public static void main(String[] args) {
        int num1 = 16, num2 = 14;
        System.out.println("Number is prefect : " + isPerfectSquare(num1));
        System.out.println("Number is prefect : " + isPerfectSquare(num2));
    }

    // SOLUTION USING BINARY SEARCH
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static boolean isPerfectSquare(int num) {
        long start = 1, end = num;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            // If (current number)² is greater than num, reduce the number.
            if (mid * mid > num) {
                end = mid - 1;
            }
            // If (current number)² is lesser than num, reduce the number.
            else if (mid * mid < num) {
                start = mid + 1;
            }
            // Number is perfect square.
            else {
                return true;
            }
        }
        // Number is not a perfect square.
        return false;
    }
}
