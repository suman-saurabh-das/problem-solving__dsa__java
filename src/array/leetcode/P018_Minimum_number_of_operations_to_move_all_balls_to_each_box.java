package array.leetcode;

/*
    1769. Minimum number of operations to move all balls to each box
    https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/

    Input: boxes = "110"
    Output: [1,1,3]
    Input: boxes = "001011"
    Output: [11,8,5,4,3,4]
*/

import java.util.Arrays;

public class P018_Minimum_number_of_operations_to_move_all_balls_to_each_box {
    public static void main(String[] args) {
        String boxes1 = "110", boxes2 = "001011";
        System.out.println("Total number of operations : " + Arrays.toString(minOperations(boxes1)));
        System.out.println("Total number of operations : " + Arrays.toString(minOperations(boxes2)));
    }

    // SOLUTION USING NESTED LOOPS - time complexity : O(n^2)
    public static int[] minOperations(String boxes) {
        int[] totalMovesArr = new int[boxes.length()];
        // Loop through the boxes to find minimum number of moves required.
        for (int i = 0; i < boxes.length(); i++) {
            int totalMoves = 0;
            // Find the total moves to move all balls from,
            // boxes at indexes j to box at index i (i != j)
            for (int j = 0; j < boxes.length(); j++) {
                if (i != j && boxes.charAt(j) == '1') {
                    // Number of moves required will be indexes j - i
                    totalMoves = totalMoves + Math.abs(j - i);
                }
            }
            totalMovesArr[i] = totalMoves;
        }
        return totalMovesArr;
    }
}
