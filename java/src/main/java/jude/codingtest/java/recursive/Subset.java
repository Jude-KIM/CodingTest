package jude.codingtest.java.recursive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Subset {

    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: nums = [1,2,3]
     * Output:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */

    public static void main(String[] args) throws IOException {
        int[] input = {1,2,3};
        System.out.println(subsets(input).toString());
    }

    public static List<List<Integer>> subset;
    public static List<List<Integer>> subsets(int[] nums) {
        subset = new ArrayList<>();
        subset.add(new ArrayList<Integer>(0));
        List<Integer> input = new ArrayList<>();
        for(Integer x : nums) {
            input.add(x);
        }

        for(int i=1;i<=nums.length;i++) {
            combination(input, new ArrayList<Integer>(), 0, nums.length, i);
        }
        return subset;
    }

    /**
     *
     *
     * @param result
     * @param r : 뽑는 개수
     * @param index : 뽑은 개수
     */
    public static void combination(List<Integer> target, List<Integer> result, int index, final int n, int r) {
        if(r == 0) {
            if(result.size() > 0) {
                subset.add(new ArrayList<Integer>(result));
            }
            return;
        }

        if(index == n) {
            return;
        }

        result.add(target.get(index));
        combination(target, result, index+1, n, r-1);

        result.remove(result.size()-1);
        combination(target, result, index+1, n, r);
    }
}
