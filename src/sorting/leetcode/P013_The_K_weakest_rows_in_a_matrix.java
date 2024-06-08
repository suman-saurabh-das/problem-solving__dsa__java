package sorting.leetcode;

/*
    1337. The K weakest rows in a matrix
    https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/

    Input: mat = [[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]], k = 3
    Output: [2,0,3]
    Input: mat = [[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]], k = 2
    Output: [0,2]
*/

import java.util.Arrays;

public class P013_The_K_weakest_rows_in_a_matrix {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int[][] mat2 = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int k1 = 3, k2 = 2;
        System.out.println("The k weakest rows are : " + Arrays.toString(kWeakestRows(mat1, k1)));
        System.out.println("The k weakest rows are : " + Arrays.toString(kWeakestRows(mat2, k2)));
    }

    // SOLUTION USING INSERTION SORT & LOOP
    // Time complexity : O(m * n + n²) | Space complexity : O(n + k)
    // where m is number of rows, n is number of columns.
    public static int[] kWeakestRows(int[][] mat, int k) {
        // Create a 2D array having the row index and number of soilders for each row.
        int[][] soildersCountAndPositionArr = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            int numSoilders = 0;
            // Number of soilders in each row.
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    numSoilders++;
                }
            }
            // Storing the row index and number of soilders as an array.
            soildersCountAndPositionArr[i] = new int[]{numSoilders, i};
        }

        // Sort the 2D array based on the number of soilders.
        // Here we are using insertion sort because it is a stable sorting algorithm.
        // i.e. the order remains same when value is same.
        insertionSort(soildersCountAndPositionArr);

        // Now create an array of length k, containing only the row indexes.
        int[] weakestRows = new int[k];
        for (int i = 0; i < k; i++) {
            weakestRows[i] = soildersCountAndPositionArr[i][1];
        }
        return weakestRows;
    }

    // Insertion sort.
    // Time complexity : O(n²) | Space complexity : O(1)
    public static void insertionSort(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1][0] > arr[j][0]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    // Swap array elements using index.
    // Time complexity : O(1) | Space complexity : O(1)
    public static void swap(int[][] arr, int index1, int index2) {
        int[] temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
