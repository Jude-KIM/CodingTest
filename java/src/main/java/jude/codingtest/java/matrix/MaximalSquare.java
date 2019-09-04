package jude.codingtest.java.matrix;

public class MaximalSquare {

    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     *
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * Output: 4
     */

    /**
     * 제일 큰 정사각형 찾기.
     *
     * 1. x,y = 1이면, 정사각형이 되려면 (x,y+1), (x+1,y), (x+1,y+1) 이 전부 1이여야함.
     * 2. 정사각형은 무조건 1의 개수가 제곱수임. 4, 9, 16, 25...
     * 일단 1을 만족하는 1의 개수를 센 뒤 그거 보다 작은 수 중에 제일 큰 제곱수가 정답.
     */



    public static void main(String[] args) {
        char[][] input = {
                {'0', '0', '1', '1', '1'},
                {'0', '0', '1', '1', '1'},
                {'0', '0', '1', '1', '1'},
                {'0', '0', '1', '1', '1'}

        };
        System.out.println(maximalSquare(input));
    }

    public static int maximalSquare(char[][] matrix) {
        int length = 1;
        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    length = check(i,j,matrix, length);
                }
            }
        }
        return length;

}

    private static int check(int i, int j, char[][] matrix, int length) {
        if(i+1 >= matrix.length || j+1 >= matrix[0].length)
            return length;
        int row = i +1;
        int column = j+1;
        while(row < matrix.length && column < matrix[0].length
                && matrix[row][column] == '1') {
            for(int x=i; x <= row; x++) {
                for(int y=j; y <= column; y++) {
                    if(matrix[x][y] != '1') {
                        row--;
                        column--;
                        return Math.max(length, (row-i+1) * (column-j+1));
                    }
                }
            }

            row++;
            column++;
        }

        return Math.max(length, (row-i) * (column-j));
    }
}
