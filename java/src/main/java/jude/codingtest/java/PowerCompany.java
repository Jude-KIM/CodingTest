package jude.codingtest.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PowerCompany {

    /**
     * During a surge in demand, an electric company activated generators to meet the demand. Now that the
     * demand has passed, at least half of the generators need to be shut down. All generators of a particular
     * model are similar and can be controlled as a single unit. Find the minimum number of models required to
     * deactivate at least half of the generators.
     * If there are n generators, then the ceiling of n/2 generators must be deactivated (ceiling is obtained when a
     * floating point value is rounded up to the next higher integer, example ceiling(3/2) = ceiling(1.5) = 2).
     * Example:
     * n = 14
     * model = [3, 4, 6, 11, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8].
     * There are 14 generators, and the ceiling of n/2 = 14/2 = 7. At least 7 generators must be deactivated. One
     * of the optimal solutions is deactivating two types of generators, models 9 and 8. The number of models 9
     * and 8 is 4 + 6 = 10, which is ≥ 7. The answer is 2.
     */

    public static void main(String[] args) {
//        int[] input = {3,4,6,11,9,9,9,9,8,8,8,8,8};
        int[] input = {6, 6, 6, 6, 7, 7, 7, 7, 5};
        int size = input.length;

        System.out.println(solve(input, size));
    }

    private static int solve(int[] input, int size) {
        int target = Math.round(size/2f);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: input) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        PriorityQueue queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return map.get(y) - map.get(x);
            }
        });

        queue.addAll(map.keySet());

        int count = 0;
        while(!queue.isEmpty() && target > 0) {
            int num = (int) queue.poll();
            target = target - map.get(num);
            count++;
        }

        return count;
    }
}
