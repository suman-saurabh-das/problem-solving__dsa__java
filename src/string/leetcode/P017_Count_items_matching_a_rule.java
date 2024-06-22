package string.leetcode;

/*
    1773. Count items matching a rule
    https://leetcode.com/problems/count-items-matching-a-rule/description/

    Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]]
           ruleKey = "color", ruleValue = "silver"
    Output: 1
    Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]]
           ruleKey = "type", ruleValue = "phone"
    Output: 2
*/

import java.util.Arrays;
import java.util.ArrayList;

public class P017_Count_items_matching_a_rule {
    public static void main(String[] args) {
        String[][] items1 = {{"phone", "blue", "pixel"}, {"computer", "silver", "lenovo"}, {"phone", "gold", "iphone"}};
        String[][] items2 = {{"phone", "blue", "pixel"}, {"computer", "silver", "phone"}, {"phone", "gold", "iphone"}};
        String ruleKey1 = "color", ruleValue1 = "silver", ruleKey2 = "type", ruleValue2 = "phone";
        ArrayList<ArrayList<String>> list1 = new ArrayList<>();
        for (String[] strings : items1) {
            list1.add(new ArrayList<>(Arrays.asList(strings)));
        }
        ArrayList<ArrayList<String>> list2 = new ArrayList<>();
        for (String[] strings : items2) {
            list2.add(new ArrayList<>(Arrays.asList(strings)));
        }
        System.out.println("Count of items : " + countMatches(list1, ruleKey1, ruleValue1));
        System.out.println("Count of items : " + countMatches(list2, ruleKey2, ruleValue2));
    }

    // SOLUTION USING LOOP
    // Time complexity : O(n) | Space complexity : O(1)
    public static int countMatches(ArrayList<ArrayList<String>> items, String ruleKey, String ruleValue) {
        int itemsCount = 0, indexToCheck = 0;
        switch (ruleKey) {
            case "type":
                indexToCheck = 0;
                break;
            case "color":
                indexToCheck = 1;
                break;
            case "name":
                indexToCheck = 2;
                break;
        }
        // Based on rule key, determine which index to check in items array.
        // Compare the rule value with the value of item in array.
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(indexToCheck).equals(ruleValue)) {
                itemsCount++;
            }
        }
        return itemsCount;
    }
}
