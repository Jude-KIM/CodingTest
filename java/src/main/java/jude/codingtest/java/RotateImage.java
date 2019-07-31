package jude.codingtest.java;

import java.io.IOException;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */

/*
00, 01, 02
10, 11, 12
20, 21, 22

20, 10, 00
21, 11, 01
22, 12, 02
*/

public class RotateImage {

    public static void main(String[] args) throws IOException {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                int index = matrix.length - 1 - j;
//                System.out.println("[" + i + "][" + j + "]" + " = [" + index +"][" + i +"]");
                result[i][j] = matrix[index][i];
            }
        }
        matrix = result;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
}
