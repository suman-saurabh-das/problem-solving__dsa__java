package math.leetcode;

/*
    832. Flipping an image
    https://leetcode.com/problems/flipping-an-image/description/

    Input: image = [[1,1,0],[1,0,1],[0,0,0]]
    Output: [[1,0,0],[0,1,0],[1,1,1]]
    Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
*/

import java.util.Arrays;

public class P010_Flipping_an_image {
    public static void main(String[] args) {
        int[][] image1 = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] image2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println("Image after flipping is : ");
        int[][] flippedImg1 = flipAndInvertImage(image1);
        for (int[] arr : flippedImg1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        System.out.println("Image after flipping is : ");
        int[][] flippedImg2 = flipAndInvertImage(image2);
        for (int[] arr : flippedImg2) {
            System.out.println(Arrays.toString(arr));
        }
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            // Flipping the image.
            // To flip an image horizontally means that each row of the image is reversed.
            int start = 0, end = image[i].length - 1;
            while (start <= end) {
                int temp = image[i][start];
                image[i][start] = image[i][end];
                image[i][end] = temp;
                start++;
                end--;
            }
            // Inverting the image.
            // To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == 1) {
                    image[i][j] = 0;
                } else {
                    image[i][j] = 1;
                }
            }
        }
        return image;
    }
}
