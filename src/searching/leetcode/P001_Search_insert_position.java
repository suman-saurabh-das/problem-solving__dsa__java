package searching.leetcode;

/*
    35. Search insert position
    https://leetcode.com/problems/search-insert-position/description/

    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Input: nums = [1,3,5,6], target = 7
    Output: 4
*/

public class P001_Search_insert_position {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target1 = 5, target2 = 2, target3 = 7, target4 = 0;
        System.out.println("Insert position is : " + searchInsert(nums, target1));
        System.out.println("Insert position is : " + searchInsert(nums, target2));
        System.out.println("Insert position is : " + searchInsert(nums, target3));
        System.out.println("Insert position is : " + searchInsert(nums, target4));
    }

    // SOLUTION USING BINARY SEARCH - time complexity : O(log(n))
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If mid-element is greater than target, we need to check in left half
            if (nums[mid] > target) {
                end = mid - 1;
            }
            // If mid-element is lesser than target, we need to check in right half
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            // If mid element is equal to target, return mid
            else {
                return mid;
            }
        }
        // If element is not found return index where it should be inserted
        return start;
    }
}
