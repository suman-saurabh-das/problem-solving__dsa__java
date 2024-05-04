package math.leetcode;

/*
    441. Arranging coins
    https://leetcode.com/problems/arranging-coins/description/

    Input: n = 5
    Output: 2
    Input: n = 8
    Output: 3
*/

public class P001_Arranging_coins {
    public static void main(String[] args) {
        int n1 = 5, n2 = 8;
        System.out.println("Number of complete rows : " + arrangeCoins(n1));
        System.out.println("Number of complete rows : " + arrangeCoins(n2));
    }

    // SOLUTION USING LOOP - time complexity : O(n)
    public static int arrangeCoins(int n) {
        // We will keep decrementing max coins that can be filled in each row from n,
        // until we have 0 (row is completely filled) or -ve value (row is incomplete).
        int maxCoinsInRow = 1, numCompleteRows = 0;
        while (n > 0) {
            n = n - maxCoinsInRow;
            maxCoinsInRow++;
            numCompleteRows++;
        }
        // Row is completely filled.
        if (n == 0) {
            return numCompleteRows;
        }
        // Row is incomplete.
        else {
            return numCompleteRows - 1;
        }
    }
}
