package searching.leetcode;

/*
    374. Guess number higher or lower
    https://leetcode.com/problems/guess-number-higher-or-lower/description/

    Input: n = 10, pick = 6
    Output: 6
    Input: n = 1, pick = 1
    Output: 1
    Input: n = 2, pick = 1
    Output: 1
*/

public class P004_Guess_number_higher_or_lower {
    public static void main(String[] args) {
        // NOTE - This is an interactive problem hence it cannot be tested here fully
        // Test case 1 : n = 10, pick = 6
        // Test case 2 : n = 1, pick = 1
        // Test case 3 : n = 2, pick = 1
        System.out.println("Number to guess : " + guessNumber(10));
    }

    // SOLUTION USING BINARY SEARCH - time complexity : O(log(n))
    public static int guessNumber(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If current number is higher than the guessed number, check for smaller number
            if (guess(mid) == -1) {
                end = mid - 1;
            }
            // If current number is lesser than the guessed number, check for bigger number
            else if (guess(mid) == 1) {
                start = mid + 1;
            }
            // If number is found, return it
            else {
                return mid;
            }
        }
        return -1;
    }

    // Internal implementation of guess()
    public static int guess(int num) {
        // Change the pick variable to test with different test cases
        int pick = 6;
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        } else {
            return 0;
        }
    }
}
