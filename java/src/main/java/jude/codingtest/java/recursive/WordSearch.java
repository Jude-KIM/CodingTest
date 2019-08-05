package jude.codingtest.java.recursive;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     *
     * Example:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     */

    public static void main(String[] args) throws IOException {


        char[][] input = {
                            {'A','B','C','E'},
                            {'S','F','E','S'},
                            {'A','D','E','E'}
                        };
//        char[][] input = {
//                {'C','A','A'},
//                {'A','A','A'},
//                {'B','C','D'}
//        };

//        char[][] input = {{'A','B','C','D'}};
        String word = "ABCESEEEFS";
//        String word = "AAB";
//        String word = "SEE";
//        String word = "ABCB";
        System.out.println(exist(input, word));
    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        if(word.length() == 0)
            return false;

        if(word.length() > row * column)
            return false;

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++) {
                if(board[i][j] == word.charAt(0) && find(i, j, 1, row, column, word, word.length(), board, new boolean[board.length][board[0].length])) {
                    return true;
                }

            }
        }


        return false;
    }

    private static boolean find(int i, int j, int index, final int row, final int column, final String word, final int length, final char[][] board, final boolean[][] isVisited) {
        if(isVisited[i][j])
            return false;

        if(index >= length) {
            return true;
        }

        isVisited[i][j] = true;
        //left
        if(j-1 >= 0 && board[i][j-1] == word.charAt(index))
            if(find(i, j - 1, index+1, row, column, word, length, board, isVisited))
                return true;
        //right
        if(j+1 < column && board[i][j+1] == word.charAt(index))
            if(find(i, j+1, index+1, row, column, word, length, board, isVisited))
                return true;

        //down
        if(i+1 < row && board[i+1][j] == word.charAt(index))
            if(find(i+1, j, index+1, row, column, word, length, board, isVisited))
                return true;
        //up
        if(i-1 >= 0 && board[i-1][j] == word.charAt(index))
            if(find(i-1, j, index+1, row, column, word, length, board, isVisited))
                return true;

        isVisited[i][j] = false;

        return false;
    }

}
