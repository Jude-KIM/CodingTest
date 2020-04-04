package jude.codingtest.java.recursive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    /**
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
     * find all unique combinations in candidates where the candidate numbers sums to target.
     *
     * The same repeated number may be chosen from candidates unlimited number of times.
     *
     * Note:
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,3,5], target = 8,
     * A solution set is:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     *
     */

    public static void main(String[] args) throws IOException {

        int[] temp = {2,3,5,8};
        System.out.println(combinationSum(temp, 7));;
    }

    /**
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> entry = new ArrayList<>();
        dfs(0, candidates, target, entry, result);
        return result;
    }

    private static void dfs(int index, final int[] candidates, int target, List<Integer> entry, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(entry));
            return;
        }

        if (target < 0)
            return;

        for(int i = index; i<candidates.length; i++) {
            entry.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], entry, result);
            entry.remove(entry.size()-1);
        }

    }
















    /**
     *
     * @param index :
     * @param candidates : input으로 주어지는 배열(뽑아야 되는 상)
     * @param target : 더해서 만들어야 되는 수. iteration을 진행할때마다 target = target - 방금 뽑은수 를 함. 이게 0이되면 entry에 추가. 0이하가 되면 실패로 추가 안하고 return
     * @param entry : 현재 뽑아서 리스트로 만든 것
     * @param result : entry를 다시 list로 만든것.
     */
    private static void test(int index, final int[] candidates, int target, List<Integer> entry, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(entry));
            return;
        }

        if(target < 0)
            return;

        for(int i=index; i< candidates.length; i++) {
            entry.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], entry, result);
            entry.remove(entry.size()-1);
        }
    }
}
