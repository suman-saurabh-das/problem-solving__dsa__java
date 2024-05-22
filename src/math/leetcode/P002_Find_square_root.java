package math.leetcode;

/*
    69. Sqrt(x)
    https://leetcode.com/problems/sqrtx/description/

    Input: x = 4
    Output: 2
    Input: x = 8
    Output: 2
*/

/*
    As per newton raphson method, the root of any number n is :
        n^(½) = (x + n/x)/2   where x : assumed square root.
        This can be proved by putting x = n^(½), then LHS = RHS
        error = | n - x |

        Step 1 - Initially assign x to n itself.
        Step 2 - We will find answer when error is less than 0.5
        Step 3 - Update the value of x.
*/

public class P002_Find_square_root {
    public static void main(String[] args) {
        System.out.println("Square root is : " + mySqrt(4));
        System.out.println("Square root is : " + mySqrt(8));
        System.out.println("Square root is : " + mySqrt(0));
        System.out.println("Square root is : " + mySqrt(Integer.MAX_VALUE));
    }

    // SOLUTION USING NEWTON RAPHSON METHOD
    // Time complexity : O(log(n) * F(n)) | Space complexity : O(1)
    // where F(n) is cost of calculating f(x)/f'(x) with n digit precision.
    public static int mySqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }
        double assumedRoot = x, root;
        while (true) {
            root = 0.5 * (assumedRoot + (x / assumedRoot));
            if (Math.abs(root - assumedRoot) < 0.5) {
                break;
            }
            assumedRoot = root;
        }
        return (int) root;
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(1)
    public static int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        double result = 1;
        while (result * result <= x) {
            result++;
        }
        if (result * result == x) {
            return (int) result;
        }
        return (int) result - 1;
    }
}
