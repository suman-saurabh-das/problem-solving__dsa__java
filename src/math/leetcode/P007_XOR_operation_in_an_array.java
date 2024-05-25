package math.leetcode;

/*
    1486. XOR operation in an array
    https://leetcode.com/problems/xor-operation-in-an-array/description/

    Input: n = 5, start = 0
    Output: 8
    Input: n = 4, start = 3
    Output: 8
*/

public class P007_XOR_operation_in_an_array {
    public static void main(String[] args) {
        int n1 = 5, start1 = 0, n2 = 4, start2 = 3;
        System.out.println("XOR operation result is : " + xorOperation(n1, start1));
        System.out.println("XOR operation result is : " + xorOperation(n2, start2));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(n)
    public static int xorOperation(int n, int start) {
        int result = 0;
        // Create an array nums of length n.
        int[] nums = new int[n];
        // Add elements in nums, where nums[i] = start + 2 * i
        // Find the XOR of all elements in nums.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = start + 2 * i;
            result = result ^ nums[i];
        }
        return result;
    }
}
