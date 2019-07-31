package jude.codingtest.java;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 */

public class IntervalMerge {

    public static void main(String[] args) throws IOException {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] input = {{1,4},{0,4}};
//        int[][] input = {{1,4},{0,1}};
//        int[][] input ={{1,4},{0,2},{3,5}};
//        int[][] input = {{2,3},{5,5},{2,2},{3,4},{3,4}};
//Output
//[[2,3],[5,5],[2,2],[3,4]]
        System.out.println(merge(input));
    }

    public static int[][] merge(int[][] intervals) {
        Pair current, next;
        boolean changed = false;
        int j = 0;


        List<Pair> temp = new ArrayList<>();
        for(int i=0; i< intervals.length; i ++) {
            Pair pair = new Pair(intervals[i][j], intervals[i][j+1]);
            temp.add(pair);
        }

        Collections.sort(temp, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if(a.first == b.first)
                    return 0;
                else if(a.first > b.first)
                    return 1;
                else
                    return -1;
            }
        });

        while(temp.size() > 1) {
            for (int i = 0; i< temp.size() -1; i++) {
                current = temp.get(i);
                next = temp.get(i+1);
                if ((current.second >= next.first && current.second <= next.second)
                        || (next.second >= current.first && next.second <= current.second)) {
                    temp.remove(i);
                    temp.remove(i);
                    temp.add(i, new Pair(Math.min(current.first, next.first), Math.max(current.second, next.second)));
                    changed = true;
                    break;
                }
            }

            if(changed)
                changed = false;
            else
                break;
        }

        int[][] result = new int[temp.size()][2];
        for(int i=0; i< temp.size(); i++) {
            result[i][j] = temp.get(i).first;
            result[i][j+1] = temp.get(i).second;
        }

        return result;
    }

    public static class Pair {
        int first;
        int second;
        Pair(int a, int b) {
            first = a;
            second = b;
        }
    }


}
