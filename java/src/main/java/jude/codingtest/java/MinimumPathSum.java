package jude.codingtest.java;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MinimumPathSum {

    /**
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * Example:
     *
     * Input:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     */


    /**
     * 1, 4, 5
     * 2, 7, 6
     * 6, 8, 7
     */

    public static void main(String[] args) throws IOException {
        int[][] input = {{1,3,1},{1,5,1},{4,2,1}};
//        int[][] input = {{0,0},{0,0}};
//        int[][] input = {{9,1,4,8}};
//        int[][] input = {{1,4},{0,1}};
//        int[][] input ={{1,4},{0,2},{3,5}};
//        int[][] input = {{2,3},{5,5},{2,2},{3,4},{3,4}};
        System.out.println(minPathSum(input));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        if(m == 1 || n == 1) {
            List<int[]> list = Arrays.asList(grid);
            for(int i=0; i < list.get(0).length; i++) {
                sum = sum + list.get(0)[i];
            }
            return sum;
        }

        /*
        for(int i=0; i<n; i++) {
            sum = sum + grid[0][i];
            matrix[0][i] = sum;
        }

        sum=0;
        for(int i=0; i < m; i++) {
            sum = sum+grid[i][0];
            matrix[i][0] = sum;
        }
        */

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j== 0)
                    continue;
                else if(i == 0) {
                    grid[i][j] += grid[i][j-1];
                } else if(j==0) {
                    grid[i][j] += grid[i-1][j];
                } else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
//
//                if(i==0) {
//                    grid[i][j] = current + grid[0][j-1];
//                } else if (j==0) {
//                    grid[i][j] = current + grid[i-1][0];
//                } else {
//                    grid[i][j] = current + Math.min(grid[i-1][j] + current, grid[i][j-1] + current);
//                }


//                if(matrix[i][j] == 0 && !(i == 0 || j==0)) {
//                    matrix[i][j] = Math.min(matrix[i-1][j] + cost, matrix[i][j-1] + cost);
//                }
            }
        }

        return grid[m-1][n-1];
    }
}
