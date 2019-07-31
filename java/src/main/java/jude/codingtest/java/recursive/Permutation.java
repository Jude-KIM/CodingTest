package jude.codingtest.java.recursive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 *
 *   3개일때 6, 4개일때 24. 팩토리얼.
 * ]
 */
public class Permutation {

    //123, 213, 132, 231,

    public static void main(String[] args) throws IOException {
        int[] input = {1,2,3};
        System.out.println(permute(input));
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getPermutation(result, list, nums);
        return result;
    }

    public static void getPermutation(List<List<Integer>> result, List<Integer> list, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                getPermutation(result, list, nums);
                list.remove(list.size() - 1);
            }
        }

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
    }
}
