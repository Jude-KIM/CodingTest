package jude.codingtest.java.matrix;

import java.util.Map;

public class NumberIslands {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands. An island is surrounded by water and
     * is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     *
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * Output: 1
     *
     * Example 2:
     *
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * Output: 3
     *
     */

//    00, 01
//    11, 11
//           22

    public static void main(String[] args) {
//        char[][] input = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','1','0','0'},
//                {'0','0','0','0','0'},
//        };

        char[][] input = {{'1','0','1','1','0','1','1'}};
//        char[][] input = {
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}};
        System.out.println(numIslands(input));
    }

    //row 0,1
    //coulm 0,1,2,3

    /** DFS, BFS 문제.
     * 이중 포문으로 0,0에서부터 모든 위치를 탐색.
     * 1을 만나면, 그 지점에서 인접지역에 0이 하나도 없을때까지 모든 1을 0으로 바꾼다. 이게 iteration 1회
     *  1회가 끝날때마다 output+1 하고 다시 탐색재개. 위에서 1을 만나면 인접한 1을 0으로 계속 바꾸므로,
     *  원래 1이던 위치도 0으로 바뀌어서 이중 for문이 빨리 끝남.

     */

    public static int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    change(grid, i,j);
                }
            }
        }

        return result;
    }

    private static void change(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j<0 || j>=grid[0].length) return;

        if(grid[i][j] == '1') {
            grid[i][j] ='0';
            change(grid, i, j+1);
            change(grid, i, j-1);
            change(grid, i+1, j);
            change(grid, i-1, j);

        }

    }

    private static boolean adjacent(Pair cur, Map<Integer, Boolean> rowMap, Map<Integer, Boolean> columnMap, Map<String, Boolean> map) {
        boolean result = false;
        if(rowMap.containsKey(cur.row)) {
            result = (map.containsKey(cur.row + "" + (cur.column-1)) || map.containsKey(cur.row + "" + (cur.column+1)));
//            return result;
        }

        if(columnMap.containsKey(cur.column) && !result) {
            result = (map.containsKey((cur.row-1) + "" + cur.column) || map.containsKey((cur.row+1) + "" + cur.column));
//            return  result;
        }

        return result;
    }


    public static class Pair {
        int row;
        int column;
        Pair(int a, int b) {
            row = a;
            column = b;
        }
    }
}
