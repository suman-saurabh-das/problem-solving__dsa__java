package sorting.leetcode;

/*
    1561. Maximum number of coins you can get
    https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/

    Input: piles = [2,4,1,2,7,8]
    Output: 9
    Input: piles = [2,4,5]
    Output: 4
    Input: piles = [9,8,7,6,5,1,2,3,4]
    Output: 18
*/

public class P008_Maximum_number_of_coins_you_can_get {
    public static void main(String[] args) {
        int[] piles1 = {2, 4, 1, 2, 7, 8}, piles2 = {2, 4, 5}, piles3 = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        System.out.println("Max number of coins with us : " + maxCoins(piles1));
        System.out.println("Max number of coins with us : " + maxCoins(piles2));
        System.out.println("Max number of coins with us : " + maxCoins(piles3));
    }

    // SOLUTION USING SELECTION SORT - time complexity : O(n^2)
    public static int maxCoins(int[] piles) {
        // Sort the pile of coins, so we can have triplets in ascending order.
        // e.g. {1, 2, 3, 4, 5, 6, 7, 8, 9}
        selectionSort(piles);
        // Now in order to give max possible coins to first 2 persons we can form triplets.
        // like -> 9,8,1 | 7,6,2 | 5,4,3
        // Here Alice will get (9 + 7 + 5) i.e. 21 coins
        // We will get (8 + 6 + 4) i.e. 18 coins (desired output)
        // Bob will get (3 + 2 + 1) i.e. 6 coins
        // In this example we can have max 3 triplets, so if we eliminate the lowest 3 numbers (1 triplet),
        // we will have 2 triplets which will give max possible coins to the first 2 members.
        int totalCoins = 0;
        // Starting from i = piles.length / 3, to eliminate the coins with min value.
        for (int i = piles.length / 3; i < piles.length; i = i + 2) {
            // In this loop we increment by 2 after every iteration,
            // since coins at intervals of i + 2 will be picked by us.
            totalCoins = totalCoins + piles[i];
        }
        return totalCoins;
    }

    // Selection sort - time complexity : O(n^2)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lastElementIndex = arr.length - 1 - i;
            int maxElementIndex = findMaxElementIndex(arr, lastElementIndex);
            swap(arr, lastElementIndex, maxElementIndex);
        }
    }

    // Find index of max element in array.
    public static int findMaxElementIndex(int[] arr, int end) {
        int maxElementIndex = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > arr[maxElementIndex]) {
                maxElementIndex = i;
            }
        }
        return maxElementIndex;
    }

    // Swap array elements using index.
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
