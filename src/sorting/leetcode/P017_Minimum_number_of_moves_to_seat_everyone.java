package sorting.leetcode;

/*
    2037. Minimum number of moves to seat everyone
    https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/

    Input: seats = [3,1,5], students = [2,7,4]
    Output: 4
    Input: seats = [4,1,5,9], students = [1,3,2,6]
    Output: 7
    Input: seats = [2,2,6,6], students = [1,3,2,6]
    Output: 4
*/

public class P017_Minimum_number_of_moves_to_seat_everyone {
    public static void main(String[] args) {
        int[] seats1 = {3, 1, 5}, seats2 = {4, 1, 5, 9}, seats3 = {2, 2, 6, 6};
        int[] students1 = {2, 7, 4}, students2 = {1, 3, 2, 6}, students3 = {1, 3, 2, 6};
        System.out.println("Minimum number of moves : " + minMovesToSeat(seats1, students1));
        System.out.println("Minimum number of moves : " + minMovesToSeat(seats2, students2));
        System.out.println("Minimum number of moves : " + minMovesToSeat(seats3, students3));
    }

    // SOLUTION USING BUBBLE SORT
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int minMovesToSeat(int[] seats, int[] students) {
        // Sort the seats and students array.
        bubbleSort(seats);
        bubbleSort(students);
        // Minimum number of moves to seat everyone can be found by,
        // subtracting each element of seat and students array.
        int minMoves = 0;
        for (int i = 0; i < seats.length; i++) {
            minMoves = minMoves + Math.abs(seats[i] - students[i]);
        }
        return minMoves;
    }

    // Bubble sort.
    // Time complexity : O(n²) | Space complexity : O(1)
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    // Swap array elements using index.
    // Time complexity : O(1) | Space complexity : O(1)
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
