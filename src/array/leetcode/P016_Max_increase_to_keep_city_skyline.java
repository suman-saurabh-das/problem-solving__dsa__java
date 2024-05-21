package array.leetcode;

/*
    807. Max increase to keep city skyline
    https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/

    Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
    Output: 35
    Input: grid = [[0,0,0],[0,0,0],[0,0,0]]
    Output: 0
*/
public class P016_Max_increase_to_keep_city_skyline {
    public static void main(String[] args) {
        int[][] grid1 = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        int[][] grid2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println("Maximum height that can be increased : " + maxIncreaseKeepingSkyline(grid1));
        System.out.println("Maximum height that can be increased : " + maxIncreaseKeepingSkyline(grid2));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n²) | Space complexity : O(n)
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int maxHeight = 0;
        int[] maxRowArr = new int[grid.length];
        int[] maxColArr = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                // Find the maximum heights in a row.
                if (grid[i][j] > maxRowArr[i]) {
                    maxRowArr[i] = grid[i][j];
                }
                // Find the maximum heights in a column.
                if (grid[j][i] > maxColArr[i]) {
                    maxColArr[i] = grid[j][i];
                }
            }
        }

        // The maximum height that can be increased of a building will be the minimum value
        // between the maximum height of building in that particular row/col.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                // Calculating the maximum possible height of each building and adding it to maxHeight.
                // Check if the minimum value is of row / column.
                if (maxRowArr[i] > maxColArr[j]) {
                    maxHeight = maxHeight + maxColArr[j] - grid[i][j];
                } else {
                    maxHeight = maxHeight + maxRowArr[i] - grid[i][j];
                }
            }
        }
        return maxHeight;
    }
}
