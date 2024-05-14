package string.leetcode;

/*
    1678. Goal parser interpretation
    https://leetcode.com/problems/goal-parser-interpretation/description/

    Input: command = "G()(al)"
    Output: "Goal"
    Input: command = "G()()()()(al)"
    Output: "Gooooal"
    Input: command = "(al)G(al)()()G"
    Output: "alGalooG"
*/

public class P006_Goal_parser_interpretation {
    public static void main(String[] args) {
        String command1 = "G()(al)", command2 = "G()()()()(al)", command3 = "(al)G(al)()()G";
        System.out.println("Interpreted string is : " + interpret(command1));
        System.out.println("Interpreted string is : " + interpret(command2));
        System.out.println("Interpreted string is : " + interpret(command3));
    }

    // SOLUTION USING LOOP - time complexity : O(n)
    public static String interpret(String command) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        // Check characters at i & i+1 to determine which character to add to result.
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                result.append("G");
                i++;
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                result.append("o");
                i = i + 2;
            } else {
                result.append("al");
                i = i + 4;
            }
        }
        return new String(result);
    }
}
