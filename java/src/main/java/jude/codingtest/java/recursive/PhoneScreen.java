package jude.codingtest.java.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneScreen {

    /**
     * Given an array A that is a permutation of n numbers [1-n].
     * Find the number of subarrarys S that meets the following condition
     * max(S) - min(S) = length(S) - 1.
     *
     * Input: [4, 3, 1, 2, 5]
     * Output: 10
     * Explanation:
     * subarrays that meets the condition are
     * [4]
     * [3]
     * [1]
     * [2]
     * [5]
     * [4 3]
     * [1 2]
     * [3 1 2]
     * [4 3 1 2]
     * [4 3 1 2 5]
     *
     * There are 10 subarray that meets the condition, so the answer should be 10.
     */
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(3);
        input.add(1);
        input.add(2);
        input.add(5);


        Set<String> set = new HashSet<>();
        int length = input.size();
        for(int i=0; i< length; i++) {
            permutation(input, set);
            input.remove(0);
        }
    }

    /**
     * 구글 인터뷰 문제라는데 n제곱으로 풀면 쉬움.
     * 그냥 모든 permutation을 만들고, 그중에 condition 에 부합하는지 체크만 하면 끝.
     */
    private static void permutation(List<Integer> input, Set<String> set) {
        List<Integer> list = new ArrayList<>();
        int min = input.get(0);
        int max = input.get(0);
        for(int i=0; i< input.size(); i++) {
            list.add(input.get(i));
            min = Math.min(min, input.get(i));
            max = Math.max(max, input.get(i));
            if(list.size() - 1 == max -min) {
                if(!set.contains(list.toString())) {
//                    result.add(list);
                    System.out.println(list);
                    set.add(list.toString());
                }
            }
        }
    }
}

