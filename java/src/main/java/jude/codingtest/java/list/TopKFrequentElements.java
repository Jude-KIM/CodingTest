package jude.codingtest.java.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;

public class TopKFrequentElements {

    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     * Note:
     *
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */

    public static void main(String[] args) {
        int[] input = {3, 2,1,1,1,2};
        System.out.println(topKFrequent(input, 2));
    }

    /**
     * 그냥 단순함.
     * 맵에 넣고, 맵의 key를 priority queue에 넣으면 끝
     *
     */

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Queue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> map.get(n2) - map.get(n1));
        for(int i: map.keySet()) {
            pq.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty() && result.size() < k)
            result.add(pq.poll());

        return result;
    }

}
