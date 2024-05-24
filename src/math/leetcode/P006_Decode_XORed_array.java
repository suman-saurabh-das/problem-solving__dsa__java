package math.leetcode;

/*
    1720. Decode XORed array
    https://leetcode.com/problems/decode-xored-array/description/

    Input: encoded = [1,2,3], first = 1
    Output: [1,0,2,1]
    Input: encoded = [6,2,7,3], first = 4
    Output: [4,2,0,7,4]
*/

import java.util.Arrays;

public class P006_Decode_XORed_array {
    public static void main(String[] args) {
        int[] encoded1 = {1, 2, 3}, encoded2 = {6, 2, 7, 3};
        int first1 = 1, first2 = 4;
        System.out.println("Decoded array is : " + Arrays.toString(decode(encoded1, first1)));
        System.out.println("Decoded array is : " + Arrays.toString(decode(encoded2, first2)));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity  : O(n)
    public static int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        // First element in decoded array will be first
        decoded[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            // Elements in decoded array from index i+1 will be,
            // decoded[i+1] = encoded[i] XOR decoded[i]
            decoded[i + 1] = encoded[i] ^ decoded[i];
        }
        return decoded;
    }
}
