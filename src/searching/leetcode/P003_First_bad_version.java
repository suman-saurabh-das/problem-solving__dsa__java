package searching.leetcode;

/*
    278. First bad version
    https://leetcode.com/problems/first-bad-version/description/

    Input: n = 5, bad = 4
    Output: 4
    Input: n = 1, bad = 1
    Output: 1
*/

public class P003_First_bad_version {
    public static void main(String[] args) {
        // NOTE - This is an interactive problem hence it cannot be tested here fully.
        // Test case 1 : n = 5, bad = 4 & Test case 1 : n = 1, bad = 1
        System.out.println("First bad version is : " + firstBadVersion(5));
    }

    // SOLUTION USING BINARY SEARCH - time complexity : O(log(n))
    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If current version is bad, check for previous versions.
            if (isBadVersion(mid)) {
                end = mid - 1;
            }
            // If current version is bad, check for next versions.
            else {
                start = mid + 1;
            }
        }
        // At the end the search space will be reduced to the first bad version
        // Then start will point to first bad version.
        return start;
    }

    // Internal implementation if isBadVersion()
    public static boolean isBadVersion(int version) {
        // Change the badVersion variable to test with different test cases
        int badVersion = 4;
        return version >= badVersion;
    }
}
