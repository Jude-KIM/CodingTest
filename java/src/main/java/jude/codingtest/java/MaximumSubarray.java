package jude.codingtest.java;

public class MaximumSubarray {

    /**
     * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
     *
     * Example 1:
     *
     * Input: [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     * Example 2:
     *
     * Input: [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     */

    public static void main(String[] args) {
//        int[] input = {-2,0,-1};
        int[] input = {2,3,-2,4};
//        int[] input = {0,2};
//        int[] input = {3,-1,4};
//        int[] input = {-4, -3};
//        int[] input = {-2,3, 5, 4};
        System.out.println(maxProduct(input));
    }

    public static int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int biggest = nums[0];
        for(int i=1; i<nums.length;i++) {
            int positive = Math.max(Math.max(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            int negative = Math.min(Math.min(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            max[i] = positive;
            min[i] = negative;
            biggest = Math.max(biggest, Math.max(max[i], min[i]));
        }

        return biggest;
    }

}
