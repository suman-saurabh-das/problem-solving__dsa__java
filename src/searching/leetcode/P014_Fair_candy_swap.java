package searching.leetcode;

/*
    888. Fair candy swap
    https://leetcode.com/problems/fair-candy-swap/description/

    Input: aliceSizes = [1,1], bobSizes = [2,2]
    Output: [1,2]
    Input: aliceSizes = [1,2], bobSizes = [2,3]
    Output: [1,2]
    Input: aliceSizes = [2], bobSizes = [1,3]
    Output: [2,3]
*/

/*
    Considering example 3,
    If Alice gives her candy box at index 0 (2 candies) to Bob,
    then total candies with Bob = candies with Bob + candies from Alice
    i.e. totalBobCandies = (1+3) + 2 = 6
    In order for both to have equal number of candies, Bob must give to Alice,
    totalBobCandies - halfCandies, i.e 6 - 3 = 3 candies
    So try to find if 3 lies in bobSizes array.
*/

import java.util.Arrays;

public class P014_Fair_candy_swap {
    public static void main(String[] args) {
        int[] aliceSizes1 = {1, 1}, aliceSizes2 = {1, 2}, aliceSizes3 = {2};
        int[] bobSizes1 = {2, 2}, bobSizes2 = {2, 3}, bobSizes3 = {1, 3};
        System.out.println("Candies to be swapped : " + Arrays.toString(fairCandySwap(aliceSizes1, bobSizes1)));
        System.out.println("Candies to be swapped : " + Arrays.toString(fairCandySwap(aliceSizes2, bobSizes2)));
        System.out.println("Candies to be swapped : " + Arrays.toString(fairCandySwap(aliceSizes3, bobSizes3)));
    }

    // SOLUTION USING BINARY SEARCH, SORTING & LOOP
    // Time complexity : O((m + n) * log(n)) | Space complexity : O(log(n))
    // where m is length of aliceSizes, n is length of bobSizes.
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // Find total candies with Alice, Bob and half of total candy count.
        int totalAliceCandies = findTotalCandies(aliceSizes);
        int totalBobCandies = findTotalCandies(bobSizes);
        int halfCandies = (totalAliceCandies + totalBobCandies) / 2;

        // Sort the array bobSizes
        quickSort(bobSizes, 0, bobSizes.length - 1);

        int candiesGivenByAlice = 0, candiesGivenByBob = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            // Candy box given by Alice to Bob.
            candiesGivenByAlice = aliceSizes[i];
            // Find if Bob has a candy box, which if he now gives to Alice,
            // then both will have equal number of candies.
            candiesGivenByBob = totalBobCandies + aliceSizes[i] - halfCandies;
            if (binarySearch(bobSizes, candiesGivenByBob)) {
                break;
            }
        }
        return new int[]{candiesGivenByAlice, candiesGivenByBob};
    }

    // Find total candies
    // Time complexity : O(n) | Space complexity : O(1)
    public static int findTotalCandies(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
        }
        return total;
    }

    // Binary search
    // Time complexity : O(log(n)) | Space complexity : O(1)
    public static boolean binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // Quick sort
    // Time complexity : O(n * log(n)) | Space complexity : O(log(n))
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        // low and high pointers determine which part of array we are working on.
        // start and end pointers are used for swapping the elements.
        int start = low, end = high, mid = start + (end - start) / 2;
        int pivot = arr[mid];
        // Placing pivot at correct index.
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            // If start is less than end and the above condition is violated,
            // then we swap the elements at start and end indexes.
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        // Sorting LHS and RHS of pivot.
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
