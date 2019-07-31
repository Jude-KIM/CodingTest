package jude.codingtest.java.recursive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniquePath {

    /**
     *
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     *
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     *
     * How many possible unique paths are there?
     *
     *
     * Above is a 7 x 3 grid. How many possible unique paths are there?
     *
     * Note: m and n will be at most 100.
     *
     * Example 1:
     *
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down
     * 2. Right -> Down -> Right
     * 3. Down -> Right -> Right
     *
     * Example 2:
     *
     * Input: m = 7, n = 3
     * Output: 28
     *
     */

    public static void main(String[] args) throws IOException {
        uniquePaths(7, 3);
    }

    public static int uniquePaths(int m, int n) {
        List<String> list = new ArrayList<>();
        list.add("Right");
        list.add("Down");
        String[] result = new String[m-1+n-1];
        Map<String, Integer> map = new HashMap<>();
        count = 0;
        permutation(m-1+n-1, 0, list, m, n, map, result);
        return count;
    }

    public static int count;
    public static void permutation(int r, int index, List<String> arr, final int m, final int n, Map<String, Integer> map, String[] result) {
        if(map.containsKey("Right") && map.get("Right") > m-1) {
            return;
        }

        if(map.containsKey("Down") && map.get("Down") > n-1) {
            return;
        }

        if(index == r) {
            count++;
            return;
        }

        for (int i=0; i< 2; i++) {
            String action = arr.get(i);
            result[index] = action;
            if(map.containsKey(action)) {
                map.put(action, map.get(action) + 1);
            } else {
                map.put(action, 1);
            }
            permutation(r, index+1, arr, m, n, map, result);
            map.put(action, map.get(action) - 1);
        }

    }
}
