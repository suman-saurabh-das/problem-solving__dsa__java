package array.leetcode;

/*
    1672. Richest customer wealth
    https://leetcode.com/problems/richest-customer-wealth/description/

    Input: accounts = [[1,2,3],[3,2,1]]
    Output: 6
    Input: accounts = [[1,5],[7,3],[3,5]]
    Output: 10
    Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
    Output: 17
*/

public class P006_Richest_customer_wealth {
    public static void main(String[] args) {
        int[][] accounts1 = {{1, 2, 3}, {3, 2, 1}}, accounts2 = {{1, 5}, {7, 3}, {3, 5}};
        int[][] accounts3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println("Wealth of richest customer : " + maximumWealth(accounts1));
        System.out.println("Wealth of richest customer : " + maximumWealth(accounts2));
        System.out.println("Wealth of richest customer : " + maximumWealth(accounts3));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(m * n) | Space complexity : O(1)
    // where m is the length of accounts array and n is the length of each array inside it.
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                // Calculate the wealth of each customer.
                wealth = wealth + accounts[i][j];
            }
            // If customers wealth is greater than max wealth then update max wealth.
            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }
        return maxWealth;
    }
}
