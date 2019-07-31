package jude.codingtest.java;

import java.io.IOException;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class RotatedSortedArray {

    public static void main(String[] args) throws IOException {

        int[] temp = {1,3};
        System.out.println(search(temp, 0));
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length -1;
        int mid = (left+right) /2;
        while(left<=right) {
            int middle = nums[mid];
            if(nums[left] == target)
                return left;

            if(nums[right] == target)
                return right;

            if(middle == target)
                return mid;
            else if(middle < nums[right]) {
                if(target < middle && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right =mid+1;
                }
            } else {
                if(target >= nums[left] && target < middle) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }

            }
        }

        return -1;

    }

    public static int binarySearch(int[] nums, int start, int target) {
        int m = (nums.length + start) /2;
        while(m >=start && m <= nums.length -1) {
            if(nums[m] == target)
                return m;
            else if(nums[m] > target)
                m = m-1;
            else
                m = m+1;
        }
        return  -1;
    }
}
