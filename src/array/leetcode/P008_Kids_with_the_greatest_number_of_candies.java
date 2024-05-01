package array.leetcode;

/*
    1431. Kids with the greatest number of candies
    https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/

    Input: candies = [2,3,5,1,3], extraCandies = 3
    Output: [true,true,true,false,true]
    Input: candies = [4,2,1,1,2], extraCandies = 1
    Output: [true,false,false,false,false]
    Input: candies = [12,1,12], extraCandies = 10
    Output: [true,false,true]
*/

import java.util.ArrayList;

public class P008_Kids_with_the_greatest_number_of_candies {
    public static void main(String[] args) {
        int[] candies1 = {2, 3, 5, 1, 3}, candies2 = {4, 2, 1, 1, 2}, candies3 = {12, 1, 12};
        int extraCandies1 = 3, extraCandies2 = 1, extraCandies3 = 10;
        System.out.println("Kids having greatest number of candies : " + kidsWithCandies(candies1, extraCandies1));
        System.out.println("Kids having greatest number of candies : " + kidsWithCandies(candies2, extraCandies2));
        System.out.println("Kids having greatest number of candies : " + kidsWithCandies(candies3, extraCandies3));
    }

    // SOLUTION USING LOOP - time complexity : O(n)
    public static ArrayList<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Find the greatest number of candies among the kids.
        int maxCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }
        // Find kids who can have the greatest number of candies.
        ArrayList<Boolean> kidsHavingGreatestCandies = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            // After getting extraCandies, if the kid has candies greater than equal to maxCandies,
            // then add true in ArrayList else add false.
            if (candies[i] + extraCandies >= maxCandies) {
                kidsHavingGreatestCandies.add(true);
            } else {
                kidsHavingGreatestCandies.add(false);
            }
        }
        return kidsHavingGreatestCandies;
    }
}
