package string.leetcode;

/*
    2011. Final value of variable after performing operations
    https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/

    Input: operations = ["--X","X++","X++"]
    Output: 1
    Input: operations = ["++X","++X","X++"]
    Output: 3
    Input: operations = ["X++","++X","--X","X--"]
    Output: 0
*/

public class P002_Final_value_of_variable_after_performing_operations {
    public static void main(String[] args) {
        String[] operations1 = {"--X", "X++", "X++"}, operations2 = {"++X", "++X", "X++"};
        String[] operations3 = {"X++", "++X", "--X", "X--"};
        System.out.println("Final value : " + finalValueAfterOperations(operations1));
        System.out.println("Final value : " + finalValueAfterOperations(operations2));
        System.out.println("Final value : " + finalValueAfterOperations(operations3));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(1)
    public static int finalValueAfterOperations(String[] operations) {
        int finalValue = 0;
        // Check for the middle character in each string in array,
        // If it is + then increment finalValue else decrement finalValue.
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(1) == '+') {
                finalValue++;
            } else {
                finalValue--;
            }
        }
        return finalValue;
    }
}
