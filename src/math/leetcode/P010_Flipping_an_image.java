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
        flipAndInvertImage(image1);
        for (int[] arr : image1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        System.out.println("Image after flipping is : ");
        flipAndInvertImage(image2);
        for (int[] arr : image2) {
            System.out.println(Arrays.toString(arr));
        }
    }

    // SOLUTION USING NESTED LOOPS
    // Time complexity : O(n²) | Space complexity : O(1)
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            // Flipping the image
            int start = 0, end = image[i].length - 1;
            while (start <= end) {
                int temp = image[i][start];
                image[i][start] = image[i][end];
                image[i][end] = temp;
                start++;
                end--;
            }
            // Inverting the image
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
