package searching.leetcode;

/*
    1351. Count negative numbers in a sorted matrix
    https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

    Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
    Output: 8
    Input: grid = [[3,2],[1,0]]
    Output: 0
*/

public class P011_Count_negative_numbers_in_a_sorted_matrix {
    public static void main(String[] args) {
        int[][] grid1 = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int[][] grid2 = {{3, 2}, {1, 0}};
        System.out.println("Number of negative elements : " + countNegatives(grid1));
        System.out.println("Number of negative elements : " + countNegatives(grid2));
    }

    // SOLUTION USING BINARY SEARCH & LOOP
    // Time complexity : O(m * log(n)) | Space complexity : O(1)
    // where m is the length of the grid and n is the length of each array in it.
    public static int countNegatives(int[][] grid) {
        int totalCount = 0;
        for (int i = 0; i < grid.length; i++) {
            int indexOfFirstNegativeNum = binarySearch(grid[i]);
            // Count of negative numbers in an array = array length - index.
            int countNegativeElements = grid[i].length - indexOfFirstNegativeNum;
            totalCount = totalCount + countNegativeElements;
        }
        return totalCount;
    }

    // Binary search to find index of first -ve number.
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If middle element is >= 0, then check in right half.
            if (arr[mid] >= 0) {
                start = mid + 1;
            }
            // If middle element is < 0, then check in left half.
            else {
                end = mid - 1;
            }
        }
        // After the loop breaking condition,
        // start will point to the index of first negative number.
        return start;
    }
}
