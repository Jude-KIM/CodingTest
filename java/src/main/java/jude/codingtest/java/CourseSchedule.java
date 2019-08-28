package jude.codingtest.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
    /**
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     *
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     *
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     *
     * Example 1:
     *
     * Input: 2, [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     *
     * Input: 2, [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0, and to take course 0 you should
     *              also have finished course 1. So it is impossible.
     * Note:
     *
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
     * You may assume that there are no duplicate edges in the input prerequisites.
     */

    public static void main(String[] args) {
        int[][] input = {{2,0}, {1,0}, {3,2}, {0,3}};
        int course = 4;
        System.out.println(canFinish(course, input));
    }


    /**
     *
     * 그래프 탐색. <integer,list> 로 구성된 인접리스트를 만들고
     * cycle이 있는지를 검사
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i< prerequisites.length; i++) {
            int key = prerequisites[i][0];
            int value = prerequisites[i][1];
            if(map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            }

            if(checkCycle(map, prerequisites[i]))
                return false;
        }

        return map.size() < numCourses;
    }

    private static boolean checkCycle(HashMap<Integer, List<Integer>> map, int[] prerequisite) {
        if(map.containsKey(prerequisite[1])) {
            List<Integer> list = map.get(prerequisite[1]);
            if(list.contains(prerequisite[1]))
                return true;
            for(int course : list) {
                if(map.containsKey(course)) {
                    if(map.get(course).contains(prerequisite[0]))
                        return true;
                }
            }


        }
        return false;
    }
}
