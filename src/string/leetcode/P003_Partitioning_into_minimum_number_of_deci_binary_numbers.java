package string.leetcode;

/*
    1689. Partitioning into minimum number of deci-binary numbers
    https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/

    Input: n = "32"
    Output: 3
    Input: n = "82734"
    Output: 8
    Input: n = "27346209830709182346"
    Output: 9
*/

public class P003_Partitioning_into_minimum_number_of_deci_binary_numbers {
    public static void main(String[] args) {
        String n1 = "32", n2 = "82734", n3 = "27346209830709182346";
        System.out.println("Minimum number of deci-binary numbers : " + minPartitions(n1));
        System.out.println("Minimum number of deci-binary numbers : " + minPartitions(n2));
        System.out.println("Minimum number of deci-binary numbers : " + minPartitions(n3));
    }

    // SOLUTION USING LOOP - time complexity : O(n)
    public static int minPartitions(String n) {
        // The minimum number of deci-binary numbers needed to form any number,
        // will be equal to the largest digit present in that number.
        // e.g. 234 can be formed by 111 + 111 + 011 + 001
        // Loop through the String to find the largest digit and return it.
        int largestDigit = 0;
        for (int i = 0; i < n.length(); i++) {
            // Automatic type casting of character to integer (ascii value)
            int currentDigit = n.charAt(i);
            if (currentDigit > largestDigit) {
                largestDigit = currentDigit;
            }
        }
        // Converting ascii value of integer to decimal value
        return largestDigit - 48;
    }
}

/*
    ALTERNATIVE APPROACH (slower)
    Converting character to string and string to number
    int currentDigit = Integer.parseInt(String.valueOf(n.charAt(i)));
*/
