package searching.leetcode;

/*
    1011. Capacity to ship packages within D days
    https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

    Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
    Output: 15
    Input: weights = [3,2,2,4,1,4], days = 3
    Output: 6
    Input: weights = [1,2,3,1,1], days = 4
    Output: 3
*/

public class P012_Capacity_to_ship_packages_within_D_days {
    public static void main(String[] args) {
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, weights2 = {3, 2, 2, 4, 1, 4}, weights3 = {1, 2, 3, 1, 1};
        int days1 = 5, days2 = 3, days3 = 4;
        System.out.println(shipWithinDays(weights1, days1));
        System.out.println(shipWithinDays(weights2, days2));
        System.out.println(shipWithinDays(weights3, days3));
    }

    // SOLUTION USING BINARY SEARCH AND LOOP
    // Time complexity : O(n * log(n)) | Space complexity : O(1)
    public static int shipWithinDays(int[] weights, int days) {
        // Find the sum of all weights & maximum weight in weights array.
        int maxWeight = weights[0], totalWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > maxWeight) {
                maxWeight = weights[i];
            }
            totalWeight = totalWeight + weights[i];
        }

        // Apply binary search to find the min capacity of ship needed.
        // The minimum capacity that is needed will lie between maxWeight and totalWeight.
        int start = maxWeight, end = totalWeight;
        while (start <= end) {
            // mid is used to calculate capacity of the ship needed.
            int mid = start + (end - start) / 2;
            // Check how many days it takes for a ship with capacity = mid to deliver all cargo.
            // If the ship can deliver it in less than or equal to days (given time),
            // then we should decrement the capacity, so end = mid - 1.
            if (days >= daysTaken(weights, mid)) {
                end = mid - 1;
            }
            // If the ship cannot deliver it in days (given time),
            // then we should increment the capacity, so start = mid + 1.
            else {
                start = mid+1;
            }
        }
        // After loop breaking condition, start will be equal to the
        // capacity of the cargo that can be shipped in days. (given time)
        return start;
    }

    // Find number of days taken to deliver all cargo with a ship of maxCapacity
    // Time complexity : O(n) | Space complexity : O(1)
    public static int daysTaken(int[] weights, int maxCapacity) {
        int days = 1;
        int capacity = maxCapacity;
        for (int i = 0; i < weights.length; i++) {
            capacity = capacity - weights[i];
            if (capacity < 0) {
                days++;
                --i;
                capacity = maxCapacity;
            }
        }
        return days;
    }
}
