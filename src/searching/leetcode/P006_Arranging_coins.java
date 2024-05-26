package searching.leetcode;

/*
    441. Arranging coins
    https://leetcode.com/problems/arranging-coins/description/

    Input: n = 5
    Output: 2
    Input: n = 8
    Output: 3
*/

public class P006_Arranging_coins {
    public static void main(String[] args) {
        int n1 = 5, n2 = 8;
        System.out.println("Number of complete rows : " + arrangeCoins(n1));
        System.out.println("Number of complete rows : " + arrangeCoins(n2));
    }

    // SOLUTION USING BINARY SEARCH
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int arrangeCoins(int n) {
        // For a row to be completely filled, the total number of coins must satisfy,
        // totalCoinsInFilledRow = n * (n+1) / 2, where n is number of filled rows.
        // e.g. n = 1, totalFilledRows = 1 * (1 + 1)/2 = 1;
        // e.g. n = 2, totalFilledRows = 2 * (2 + 1)/2 = 3;
        // e.g. n = 3, totalFilledRows = 3 * (3 + 1)/2 = 6;
        // e.g. n = 4, totalFilledRows = 4 * (4 + 1)/2 = 10;
        // So now we can use binary search to check if the above condition is satisfied or not.
        long start = 1, end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * (mid + 1) / 2 > n) {
                end = mid - 1;
            } else if (mid * (mid + 1) / 2 < n) {
                start = mid + 1;
            }
            // Since condition is satisfied, we have a fully filled row.
            else {
                return (int) mid;
            }
        }
        // Since we have an incomplete row, we return end value,
        // which will be equal to last fully filled row.
        return (int) end;
    }
}
