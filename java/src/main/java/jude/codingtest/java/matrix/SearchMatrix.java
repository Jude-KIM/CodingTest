package jude.codingtest.java.matrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchMatrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:
     *
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * Example:
     *
     * Consider the following matrix:
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * Given target = 5, return true.
     *
     * Given target = 20, return false.
     */

    public static void main(String[] args) throws IOException {
        int[][] input = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        System.out.println(searchMatrix(input, 19));
    }


    /**
     * 정렬된 매트릭스에서 숫자 찾기.
     * 정렬이 되어 있기 때문에 모서리 값에서 출발해서 target과 비교하면서 오른쪽 or 위로 이동하면서 찾으면 됨.
     *
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int column = 0;
        while(row >= 0 && row < matrix.length && column >=0 && column < matrix[0].length) {
            int number = matrix[row][column];
            if(number == target)
                return true;

            if(number > target)
                row--;

            if(number < target)
                column++;

        }

        return false;


        /*
        잘못된 접근방법. 풀리긴 하지만 느림
        List<Integer> rowList = new ArrayList<>();
        List<Integer> columnList = new ArrayList<>();

        for(int i=0; i<rowSize; i++) {
            if(matrix[i][0] == target || matrix[i][columnSize-1] == target)
                return true;

            int min = matrix[i][0];
            int max = matrix[i][columnSize-1];

            if(target > min && target < max) {
                rowList.add(i);
            }
        }

        for(int i=0; i<columnSize; i++) {
            if(matrix[0][i] == target || matrix[rowSize-1][i] == target)
                return true;


            int min = matrix[0][i];
            int max = matrix[rowSize-1][i];
            if(target > min && target < max)
                columnList.add(i);
        }

        if(rowList.size() == 0 || columnList.size() == 0)
            return false;

        for(int i=rowList.get(0); i <= rowList.get(rowList.size()-1); i++) {
            for(int j = columnList.get(0); j <= columnList.get(columnList.size()-1); j++) {
                System.out.println(i +", " + j);
                if(matrix[i][j] == target)
                    return true;
            }
        }

        return false;

         */

    }

}
