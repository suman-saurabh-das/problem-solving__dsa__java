package searching.leetcode;

/*
    744. Find smallest letter greater than target
    https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

    Input: letters = ['c','f','j'], target = 'a'
    Output: 'c'
    Input: letters = ['c','f','j'], target = 'c'
    Output: 'f'
    Input: letters = ['x','x','y','y'], target = 'z'
    Output: 'x'
*/

public class P010_Find_smallest_letter_greater_than_target {
    public static void main(String[] args) {
        char[] letters1 = {'c', 'f', 'j'}, letters2 = {'x', 'x', 'y', 'y'};
        char target1 = 'a', target2 = 'c', target3 = 'z';
        System.out.println("Smallest letter greater than target : " + nextGreatestLetter(letters1, target1));
        System.out.println("Smallest letter greater than target : " + nextGreatestLetter(letters1, target2));
        System.out.println("Smallest letter greater than target : " + nextGreatestLetter(letters2, target3));
    }

    // SOLUTION USING BINARY SEARCH
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If target is greater than or equal to arr[mid], ans will lie in right half.
            // If target is lesser than arr[mid], ans will lie in left half.
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // If no character greater than target exist then start will become equal to arr.length
        // So we can take the % of start and arr.length to get the start element.
        return letters[start % letters.length];
    }
}
