package searching.leetcode;

/*
    410. Split array largest sum
    https://leetcode.com/problems/split-array-largest-sum/description/

    Input: nums = [7,2,5,10,8], k = 2
    Output: 18
    Input: nums = [1,2,3,4,5], k = 2
    Output: 9
 */

public class P020_Split_array_largest_sum {
    public static void main(String[] args) {
        int[] nums1 = {7, 2, 5, 10, 8}, nums2 = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println("Minimised largest sum is : " + splitArray(nums1, k));
        System.out.println("Minimised largest sum is : " + splitArray(nums2, k));
    }

    // SOLUTION USING BINARY SEARCH
    // Time complexity : O(n*log(n)) | Space complexity : O(1)
    public static int splitArray(int[] nums, int k) {
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end = end + nums[i];
        }

        while (start < end) {
            // mid will be used to find the minimised largest sum.
            int mid = start + (end - start) / 2;
            // Find the number of sub-arrays, an array can be broken into.
            int sum = 0, numOfSubArrays = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    // Increasing the sub array count.
                    numOfSubArrays++;
                    // Setting first element in the new array.
                    sum = num;
                } else {
                    // Calculating the sum of elements.
                    sum = sum + num;
                }
            }
            if (numOfSubArrays <= k) {
                // We can increase numberOfSubArrays i.e. we are decreasing the sum of elements in sub array.
                // So to decrease the sum we will reduce end value.
                end = mid;
            } else {
                // We can decrease numberOfSubArrays i.e. we are increasing the sum of elements in sub array.
                // So to increase the sum we will increase start value.
                start = mid + 1;
            }
        }
        // We have found the minimised largest sum. (here start == end)
        return start;
    }
}
