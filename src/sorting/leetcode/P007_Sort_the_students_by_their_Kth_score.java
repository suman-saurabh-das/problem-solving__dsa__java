package sorting.leetcode;

/*
    2545. Sort the students by their Kth score
    https://leetcode.com/problems/sort-the-students-by-their-kth-score/description/

    Input: score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
    Output: [[7,5,11,2],[10,6,9,1],[4,8,3,15]]
    Input: score = [[3,4],[5,6]], k = 0
    Output: [[5,6],[3,4]]
*/

import java.util.Arrays;

public class P007_Sort_the_students_by_their_Kth_score {
    public static void main(String[] args) {
        int[][] score1 = {{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}}, score2 = {{3, 4}, {5, 6}};
        int k1 = 2, k2 = 0;
        int[][] sortedScore1 = sortTheStudents(score1, k1);
        int[][] sortedScore2 = sortTheStudents(score2, k2);
        System.out.println("Scores of students sorted by kth exam : ");
        for (int[] arr : sortedScore1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        System.out.println("Scores of students sorted by kth exam : ");
        for (int[] arr : sortedScore2) {
            System.out.println(Arrays.toString(arr));
        }
    }

    // SOLUTION USING BUBBLE SORT
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int[][] sortTheStudents(int[][] score, int k) {
        boolean isSwapped;
        for (int i = 0; i < score.length; i++) {
            isSwapped = false;
            // Number of comparisons will be equal to number of students.
            for (int j = 0; j < score.length - 1; j++) {
                // If kth exam score of student[j+1][k] > student[j][k],
                // then we swap both students.
                if (score[j][k] < score[j + 1][k]) {
                    swapArray(score, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
        return score;
    }

    // Swap the student who has more score with student having less score.
    // Time complexity : O(1) | Space complexity : O(1)
    public static void swapArray(int[][] arr, int index1, int index2) {
        int[] temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
