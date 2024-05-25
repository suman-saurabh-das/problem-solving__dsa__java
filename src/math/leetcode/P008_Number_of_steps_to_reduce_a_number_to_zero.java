package math.leetcode;

/*
    1342. Number of steps to reduce a number to zero
    https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/

    Input: num = 14
    Output: 6
    Input: num = 8
    Output: 4
    Input: num = 123
    Output: 12
*/
public class P008_Number_of_steps_to_reduce_a_number_to_zero {
    public static void main(String[] args) {
        int num1 = 14, num2 = 8, num3 = 123;
        System.out.println("Number of steps : " + numberOfSteps(num1));
        System.out.println("Number of steps : " + numberOfSteps(num2));
        System.out.println("Number of steps : " + numberOfSteps(num3));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static int numberOfSteps(int num) {
        int numSteps = 0;
        while (num != 0) {
            // If number is even, divide it by 2.
            if (num % 2 == 0) {
                num = num / 2;
            }
            // If number is odd, subtract 1 from it.
            else {
                num = num - 1;
            }
            // Increment number of steps.
            numSteps++;
        }
        return numSteps;
    }
}
