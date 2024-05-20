package array.leetcode;

/*
    1389. Create target array in the given order
    https://leetcode.com/problems/create-target-array-in-the-given-order/description/

    Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
    Output: [0,4,1,3,2]
    Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
    Output: [0,1,2,3,4]
    Input: nums = [1], index = [0]
    Output: [1]
 */

import java.util.Arrays;

public class P017_Create_target_array_in_given_order {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 3, 4}, nums2 = {1, 2, 3, 4, 0}, nums3 = {1};
        int[] indexes1 = {0, 1, 2, 2, 1}, indexes2 = {0, 1, 2, 3, 0}, indexes3 = {0};
        System.out.println("Target array is : " + Arrays.toString(createTargetArray(nums1, indexes1)));
        System.out.println("Target array is : " + Arrays.toString(createTargetArray(nums2, indexes2)));
        System.out.println("Target array is : " + Arrays.toString(createTargetArray(nums3, indexes3)));
    }

    // SOLUTION USING NESTED LOOP - time complexity : O(n^2)
    public static int[] createTargetArray(int[] nums, int[] index) {
        // Create a new array to fill the elements.
        int[] targetArr = new int[nums.length];

        // Replacing default value 0 in targetArr with -1, because elements in nums lie in range 0 to 100
        // So in order to check if a number is already present in that index we will compare it with -1
        // -1 can be considered as empty value in array.
        Arrays.fill(targetArr, -1);

        for (int i = 0; i < nums.length; i++) {
            int targetIndex = index[i];
            // If element at targetIndex is -1, i.e. that index can be considered empty,
            // So we insert the value of nums[i] at targetIndex.
            if (targetArr[targetIndex] == -1) {
                targetArr[targetIndex] = nums[i];
            }
            // If element at targetIndex is not -1 then we will have to shift,
            // all the elements in targetArray by 1 position to right side.
            // then we insert the element from nums[i] at the targetIndex.
            else {
                // Shifting all elements from end.
                int j = nums.length - 1;
                while (j != targetIndex) {
                    targetArr[j] = targetArr[j - 1];
                    j--;
                }
                targetArr[targetIndex] = nums[i];
            }
        }
        return targetArr;
    }
}
