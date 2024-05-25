package string.leetcode;

/*
    1108. Defanging an IP address
    https://leetcode.com/problems/defanging-an-ip-address/description/

    Input: address = "1.1.1.1"
    Output: "1[.]1[.]1[.]1"
    Input: address = "255.100.50.0"
    Output: "255[.]100[.]50[.]0"
*/

public class P001_Defanging_an_IP_address {
    public static void main(String[] args) {
        String s1 = "1.1.1.1", s2 = "255.100.50.0";
        System.out.println("Defanged IP address : " + defangIPaddr(s1));
        System.out.println("Defanged IP address : " + defangIPaddr(s2));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(n)
    public static String defangIPaddr(String address) {
        StringBuilder defangedAddress = new StringBuilder();
        int i = 0;
        // Check each character, if it is . then append [.]
        // else append the character to defangedAddress.
        while (i < address.length()) {
            if (address.charAt(i) == '.') {
                defangedAddress.append("[.]");
            } else {
                defangedAddress.append(address.charAt(i));
            }
            i++;
        }
        return new String(defangedAddress);
    }

    // SOLUTION USING BUILT-IN METHOD
    // Time complexity : O(n) | Space complexity : O(n)
    // where n is the length of the input string.
    // length of the substring to be replaced is constant.
    public static String defangIPaddr2(String address) {
        return address.replace(".", "[.]");
    }
}
