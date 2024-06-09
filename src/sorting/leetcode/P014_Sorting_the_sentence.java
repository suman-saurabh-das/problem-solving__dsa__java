package sorting.leetcode;

/*
    1859. Sorting the sentence
    https://leetcode.com/problems/sorting-the-sentence/description/

    Input: s = "is2 sentence4 This1 a3"
    Output: "This is a sentence"
    Input: s = "Myself2 Me1 I4 and3"
    Output: "Me Myself and I"
*/

public class P014_Sorting_the_sentence {
    public static void main(String[] args) {
        String s1 = "is2 sentence4 This1 a3", s2 = "Myself2 Me1 I4 and3";
        System.out.println("Sorted sentence : " + sortSentence(s1));
        System.out.println("Sorted sentence : " + sortSentence(s2));
    }

    // SOLUTION USING BUBBLE SORT
    // Time complexity : O(n²) | Space complexity : O(n)
    public static String sortSentence(String s) {
        // Split the string into an array of strings.
        String[] strArr = s.split(" ");

        // Sort the array using bubble sort.
        for (int i = 0; i < strArr.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < strArr.length - 1 - i; j++) {
                // If last character of string at index j is > than,
                // last character of string at index j+1 then swap the strings.
                if (strArr[j].charAt(strArr[j].length() - 1) > strArr[j + 1].charAt(strArr[j + 1].length() - 1)) {
                    String temp = strArr[j];
                    strArr[j] = strArr[j + 1];
                    strArr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }

        // Remove the numbers at the end of each string in array.
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].substring(0, strArr[i].length() - 1);
        }

        // Join the strings in array into 1 string.
        return String.join(" ", strArr);
    }
}
