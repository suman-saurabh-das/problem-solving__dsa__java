package sorting.leetcode;

/*
    1637. Widest vertical area between two points containing no points
    https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/description/

    Input: points = [[8,7],[9,9],[7,4],[9,7]]
    Output: 1
    Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
    Output: 3
*/

public class P003_Widest_vertical_area_between_two_points_containing_no_points {
    public static void main(String[] args) {
        int[][] points1 = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};
        int[][] points2 = {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};
        System.out.println("Widest vertical area : " + maxWidthOfVerticalArea(points1));
        System.out.println("Widest vertical area : " + maxWidthOfVerticalArea(points2));
    }

    // SOLUTION USING INSERTION SORT - time complexity : O(n^2)
    public static int maxWidthOfVerticalArea(int[][] points) {
        // We need to find the max width between 2 consecutive points in x-coordinate.
        // Create an array from the points given so that we have the x-coordinates.
        int[] verticalPointsArr = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            verticalPointsArr[i] = points[i][0];
        }
        // Now sort the array containing the x-coordinates.
        insertionSort(verticalPointsArr);
        // Maximum difference between 2 consecutive points will be the widest.
        int maxDifference = 0;
        for (int i = 0; i < verticalPointsArr.length - 1; i++) {
            int difference = verticalPointsArr[i + 1] - verticalPointsArr[i];
            if (difference > maxDifference) {
                maxDifference = difference;
            }
        }
        return maxDifference;
    }

    // Insertion sort - time complexity : O(n^2)
    public static void insertionSort(int[] arr) {
        // External loop will run less than n-1 times.
        // (because we are comparing element at i and i+1)
        for (int i = 0; i < arr.length - 1; i++) {
            // Internal loop will run while j > 0
            for (int j = i + 1; j > 0; j--) {
                // Swap the 2 numbers if element at j < element at j-1
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
                // Break out of loop as LHS is already sorted.
                else {
                    break;
                }
            }
        }
    }

    // Swap array elements using index.
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
