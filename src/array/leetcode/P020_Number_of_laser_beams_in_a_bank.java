package array.leetcode;

/*
    2125. Number of laser beams in a bank
    https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/

    Input: bank = ["011001","000000","010100","001000"]
    Output: 8
    Input: bank = ["000","111","000"]
    Output: 0
*/

public class P020_Number_of_laser_beams_in_a_bank {
    public static void main(String[] args) {
        String[] bank1 = {"011001", "000000", "010100", "001000"}, bank2 = {"000", "111", "000"};
        System.out.println("Number of laser beams : " + numberOfBeams(bank1));
        System.out.println("Number of laser beams : " + numberOfBeams(bank2));
    }

    // SOLUTION USING NESTED LOOPS & TWO POINTERS
    // Time complexity : O(m * n) | Space complexity: O(m)
    // where m is the length of bank array and n is length of each string.
    public static int numberOfBeams(String[] bank) {
        int totalLaserBeams = 0;
        // If there is only 1 floor, return 0 as there will be no laser beams.
        if (bank.length == 1) {
            return 0;
        }

        // Create an integer array to hold number of devices in each floor.
        int[] devicesArr = new int[bank.length];
        // Find number of device in a floor, add device count in devicesArr.
        for (int i = 0; i < bank.length; i++) {
            int numDevices = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                // For each 1 in string, we add one device.
                if (bank[i].charAt(j) == '1') {
                    numDevices++;
                }
            }
            devicesArr[i] = numDevices;
        }

        // Loop through devicesArr and find product of 2 consecutive,
        // non-zero elements in devicesArr and add the results.
        int f1 = 0, f2 = 1;
        while (f2 < devicesArr.length) {
            // If no devices in floor f1, increment f1 & f2 by 1
            if (devicesArr[f1] == 0) {
                f1++;
                f2++;
            }
            // If no devices in floor f2, increment f2 by 1
            if (f2 < devicesArr.length && devicesArr[f2] == 0) {
                f2++;
            }
            // If there are devices in both floor f1 & f2, calculate number of laser beams.
            // Set f1 to f2 and increment f2.
            if (f2 < devicesArr.length && devicesArr[f1] != 0 && devicesArr[f2] != 0) {
                totalLaserBeams = totalLaserBeams + devicesArr[f1] * devicesArr[f2];
                f1 = f2;
                f2++;
            }
        }
        return totalLaserBeams;
    }
}
