package jude.codingtest.java;

import java.util.Arrays;

public class ProductExceptSelf {

    /**
     * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     *
     * Example:
     *
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Note: Please solve it without division and in O(n).
     *
     * Follow up:
     * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     */

    public static void main(String[] args) {
        int[] input= {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }

    /**
     *
     * O(n제곱) 으로 풀면 난이도 1짜리 문제지만 O(n)으로 하려면 고민이 필요함.
     * n 제곱으로 traverse 하지 않으려면 현재 index 값 보다 왼쪽에 있는 값 끼리의 product와  오른쪽에 있는 값 끼리의 product를 항상 알고 있어야함.
     *
     * result[n] = n왼쪽에 있는 모든 값의 product * n 오른쪽에 있는 모든 값의 product
     *
     * 결국 input array를 traverse 하는 동안 현재 인덱스 왼쪽의 product(곱하기)와 오른쪽의 product를 각각 별도 배열에 저장해야함.
     */

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];

        for(int i=0; i<length; i++) {
            if(i == 0) {
                left[i] = 1;
            } else {
                left[i] = nums[i-1] * left[i-1];
            }
        }

        for(int i= length - 1; i >= 0 ; i--) {
            if(i == length-1) {
                right[i] = 1;
            } else {
                right[i] = nums[i+1] * right[i+1];
            }
        }

        for(int i = 0; i<length; i++) {
            nums[i] = left[i] * right[i];
        }


        return nums;

    }

}
