package string.leetcode;

/*
    2391. Minimum amount of time to collect garbage
    https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/

    Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]
    Output: 21
    Input: garbage = ["MMM","PGM","GP"], travel = [3,10]
    Output: 37
 */

public class P015_Minimum_amount_of_time_to_collect_garbage {
    public static void main(String[] args) {
        String[] garbage1 = {"G", "P", "GP", "GG"}, garbage2 = {"MMM", "PGM", "GP"};
        int[] travel1 = {2, 4, 3}, travel2 = {3, 10};
        System.out.println("Total time taken : " + garbageCollection(garbage1, travel1));
        System.out.println("Total time taken : " + garbageCollection(garbage2, travel2));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int garbageCollection(String[] garbage, int[] travel) {
        int timeToCollectP = 0, timeToCollectG = 0, timeToCollectM = 0;
        boolean isPaperGarbage = false, isGlassGarbage = false, isMetalGarbage = false;
        // To calculate the time required to collect the garbage.
        // Here we are looping from end of garbage array to determine,
        // till which house the truck must travel to.
        for (int i = garbage.length - 1; i >= 0; i--) {
            // Time taken to collect P,G,M garbage.
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'P') {
                    timeToCollectP++;
                    isPaperGarbage = true;
                } else if (garbage[i].charAt(j) == 'G') {
                    timeToCollectG++;
                    isGlassGarbage = true;
                } else {
                    timeToCollectM++;
                    isMetalGarbage = true;
                }
            }
            // Time taken to travel.
            if (isPaperGarbage && i > 0) {
                timeToCollectP = timeToCollectP + travel[i - 1];
            }
            if (isGlassGarbage && i > 0) {
                timeToCollectG = timeToCollectG + travel[i - 1];
            }
            if (isMetalGarbage && i > 0) {
                timeToCollectM = timeToCollectM + travel[i - 1];
            }
        }
        // Calculate total time to collect garbage from each truck.
        return timeToCollectP + timeToCollectG + timeToCollectM;
    }
}
