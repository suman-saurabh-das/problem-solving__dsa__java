package searching.leetcode;

/*
    69. Sqrt(x)
    https://leetcode.com/problems/sqrtx/description/

    Input: x = 4
    Output: 2
    Input: x = 8
    Output: 2
*/

public class P002_Find_square_root {
    public static void main(String[] args) {
        int x1 = 4, x2 = 8;
        System.out.println("Square root is : " + mySqrt(x1));
        System.out.println("Square root is : " + mySqrt(x2));
    }

    // SOLUTION USING BINARY SEARCH - time complexity : O(log(n))
    // Gives out of memory error for x = 2147395599 if we use int, so we use long then convert it into int.
    public static int mySqrt(int x) {
        long start = 0, end = x;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            // Check for numbers greater than mid.
            if (mid * mid < x) {
                start = mid + 1;
            }
            // Check for numbers smaller than mid.
            else if (mid * mid > x) {
                end = mid - 1;
            }
            // Number is a perfect square.
            else {
                return (int) mid;
            }
        }
        // If perfect square of number is not present, we return the rounded off value.
        return (int) end;
    }
}
