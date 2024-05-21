package array.leetcode;

/*
    2373. Largest local values in a matrix
    https://leetcode.com/problems/largest-local-values-in-a-matrix/description/

    Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
    Output: [[9,9],[8,6]]
    Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
    Output: [[2,2,2],[2,2,2],[2,2,2]]
*/

import java.util.Arrays;

public class P013_Largest_local_values_in_a_matrix {
    public static void main(String[] args) {
        int[][] grid1 = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        int[][] grid2 = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println("Largest local values are : ");
        for (int[] arr : largestLocal(grid1)) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Largest local values are : ");
        for (int[] arr : largestLocal(grid2)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n²) | Space complexity : O (n²)
    public static int[][] largestLocal(int[][] grid) {
        int[][] maxLocalArr = new int[grid.length - 2][grid.length - 2];
        // We need to find max element in all possible 3x3 matrix that,
        // can be formed from the grid and then add the elements to maxLocalArr.
        int rowStart = 0, rowEnd = 3, i = 0;
        while (rowEnd <= grid.length) {
            int colStart = 0, colEnd = 3, j = 0;
            while (colEnd <= grid.length) {
                maxLocalArr[i][j] = findMaxElement(grid, rowStart, rowEnd, colStart, colEnd);
                j++;
                colStart++;
                colEnd++;
            }
            i++;
            rowStart++;
            rowEnd++;
        }
        return maxLocalArr;
    }

    // Find maximum element in 3x3 matrix.
    // Time complexity : O(1) | Space complexity : O(1)
    // since size of sub matrix is constant i.e. 3 * 3
    public static int findMaxElement(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        int maxVal = 0;
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                }
            }
        }
        return maxVal;
    }
}
