package jude.codingtest.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindNLargestElement {

    /**
     * Find the kth largest element in an unsorted array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Example 1:
     *
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     *
     * Example 2:
     *
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     */

    public static void main(String[] args) {
        int[] input = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(input, k));
    }



    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>(nums.length);

        for(int number : nums) {
            pq.add(number);

        }

        for(int i =0; i<k; i++) {
            pq.poll();
        }

        return pq.poll();
    }

    private static void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
