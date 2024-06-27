package array.leetcode;

/*
    1409. Queries on a permutation with key
    https://leetcode.com/problems/queries-on-a-permutation-with-key/description/

    Input: queries = [3,1,2,1], m = 5
    Output: [2,1,2,1]
    Input: queries = [4,1,2,2], m = 4
    Output: [3,1,2,0]
    Input: queries = [7,5,5,8,3], m = 8
    Output: [6,5,0,7,5]
*/

import java.util.Arrays;

public class P022_Queries_on_a_permutation_with_key {
    public static void main(String[] args) {
        int[] queries1 = {3, 1, 2, 1}, queries2 = {4, 1, 2, 2}, queries3 = {7, 5, 5, 8, 3};
        int m1 = 5, m2 = 4, m3 = 8;
        System.out.println("Resultant array is : " + Arrays.toString(processQueries(queries1, m1)));
        System.out.println("Resultant array is : " + Arrays.toString(processQueries(queries2, m2)));
        System.out.println("Resultant array is : " + Arrays.toString(processQueries(queries3, m3)));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];

        // Create a permutation array containing elements from 1 to m.
        int[] p = new int[m];
        for (int i = 0; i < p.length; i++) {
            p[i] = i + 1;
        }

        for (int i = 0; i < queries.length; i++) {
            // Find index of element to be moved to front,
            // this will be equal to number of swaps required to move it.
            int numSwaps = findIndexOfElement(queries[i], p);
            // Store the index of element in p array at index i in result array.
            result[i] = numSwaps;
            // Swap the elements to move it to front.
            while (numSwaps > 0) {
                int temp = p[numSwaps - 1];
                p[numSwaps - 1] = p[numSwaps];
                p[numSwaps] = temp;
                numSwaps--;
            }
        }
        return result;
    }

    // Linear search - Finding target element in array.
    // Time complexity : O(n) | Space complexity : O(1)
    public static int findIndexOfElement(int ele, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }
}
