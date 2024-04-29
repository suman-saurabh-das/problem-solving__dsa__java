package array.leetcode;

/*
    1512. Number of good pairs
    https://leetcode.com/problems/number-of-good-pairs/description/

    Input: nums = [1,2,3,1,1,3]
    Output: 4
    Input: nums = [1,1,1,1]
    Output: 6
    Input: nums = [1,2,3]
    Output: 0
 */

public class P003_Number_of_good_pairs {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 1, 3}, nums2 = {1, 1, 1, 1}, nums3 = {1, 2, 3};
        System.out.println("Number of good pairs : " + numIdenticalPairs(nums1));
        System.out.println("Number of good pairs : " + numIdenticalPairs(nums2));
        System.out.println("Number of good pairs : " + numIdenticalPairs(nums3));
    }

    // SOLUTION USING NESTED LOOPS - time complexity : O(n^2)
    public static int numIdenticalPairs(int[] nums) {
        int numGoodPairs = 0;
        // Using 2 for loops, compare the elements at index i and j
        // If both are equal then we increment numGoodPairs
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    numGoodPairs++;
                }
            }
        }
        return numGoodPairs;
    }
}
