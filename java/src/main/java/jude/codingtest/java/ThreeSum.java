package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 *
 * -4, -1, -1, 0, 1, 2
 *
 * 1, 2
 *1, 1, 4
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 1,1,3,5,8
 *
 * -1, -2, -6
 *
 * map(sum, Pair)
 *
 * (1,1), (1,3), (1,5), (1,8), (3,5), (3,8), (5,8)
 *
 * 1, 2, 3, 4, 5, 6, 8, 9, 11, 13
 *
 *
 * 1,7  2,6, 3,5 , 4,4
 */
public class ThreeSum {

    public static void main(String[] args) throws IOException {
        int[] input = {6,-5,-6,-1,-2,8,-1,4,-10,-8,-10,-2,-4,-1,-8,-2,8,9,-5,-2,-8,-9,-3,-5};
        System.out.println(threeSum(input).toString());
    }

    public static void add(Set<List<Integer>> set, int minus, int zero, int plus) {
        set.add(Arrays.asList(minus, zero, plus));
//        List<Integer> temp = Arrays.asList(minus, zero, plus);
//        temp.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer t1) {
//                if(integer.equals(t1)) return 0;
//
//                return integer > t1 ? 1:-1;
//            }
//        });
//        set.add(temp);
    }

    public static List<List<Integer>> threeSum(final int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                start = i;
                break;
            }
        }

        // - 10, -10, -9, -8, -8, -8, -6, -5, -5, -5, -4, -3, -2, -2, -2, -2, -1, -1, -1
//           4, 6, 8, 8, 9
//           1, 3, 5, 7, 7
//           2, 4, 4, 6, 8
        //start=19


        for (int i=0; i < nums.length; i++) {
            int target = nums[i];
            int left, right;
            if(i < start) {
                //음수영역
                left = start;
                right = nums.length -1;
            } else {
                //양수영역
                left = 0;
                right = start -1;
            }
            while(left < right) {
                System.out.println(target + " = " + nums[left] +" + " + nums[right]);
                if(Math.abs(nums[left] + nums[right]) == Math.abs(target)) {
                    add(set, target, nums[left], nums[right]);
                    left++;
                    right--;
                } else if(nums[left] + nums[right] + target < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int count = 0;
        for (int temp : nums) {
            if (temp == 0)
                count++;
        }

        if (count >= 3)
            add(set, 0, 0, 0);

        return new ArrayList<List<Integer>>(set);
    }
}
