package string.leetcode;

/*
    2194. Cells in a range on an excel sheet
    https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/description/

    Input: s = "K1:L2"
    Output: ["K1","K2","L1","L2"]
    Input: s = "A1:F1"
    Output: ["A1","B1","C1","D1","E1","F1"]
*/

import java.util.ArrayList;

public class P019_Cells_in_range_on_a_excel_sheet {
    public static void main(String[] args) {
        String s1 = "K1:L2", s2 = "A1:F1";
        System.out.println("Cells in range are : " + cellsInRange(s1));
        System.out.println("Cells in range are : " + cellsInRange(s2));
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n * m) | Space complexity : O(n * m)
    // where n is the number of columns and m is the number of rows.
    public static ArrayList<String> cellsInRange(String s) {
        ArrayList<String> cells = new ArrayList<>();
        char colStart = s.charAt(0), colEnd = s.charAt(3);
        // Outer loop to loop through the column values.
        while (colStart <= colEnd) {
            // Converting ascii value of integer to integer.
            int rowStart = s.charAt(1) - 48, rowEnd = s.charAt(4) - 48;
            // Inner loop to loop through the row values.
            while (rowStart <= rowEnd) {
                cells.add(colStart + "" + rowStart);
                rowStart++;
            }
            colStart++;
        }
        return cells;
    }
}
