package jude.codingtest.java;

import java.io.IOException;

/**
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
public class SearchRange {

    public static void main(String[] args) throws IOException {

        int[] temp = {5,7,7,8,8,10};
        searchRange(temp, 8);
    }

    // 1,7   5
    public static int[] searchRange(int[] nums, int target) {
        int start = Integer.MAX_VALUE;
        int end = -1;
        int left = 0;
        int right = nums.length-1;
        int mid;

        if(nums.length == 1) {
            if(nums[0] == target)
                return new int[]{0,0};
            else
                return new int[]{-1,-1};
        }

        while(left<=right) {
             mid = (left+right) /2;
             if(mid == left && mid == right) {
                 if(nums[mid] == target) {
                     if(mid < start)
                         start = mid;

                     if(mid > end)
                         end = mid;
                 }
                 break;
             }

             if(nums[mid] == target) {
                 if(nums[left] == target && nums[right] == target) {
                     if(left < start)
                        start = left;
                     if(right > end)
                        end = right;
                    break;
                 } else if (nums[left] == target) {
                     if(start > left)
                        start = left;
                     end = mid;
                     left = mid+1;
                     right = right -1;
                 } else if (nums[right] == target) {
                     if(end < right)
                     start = mid;
                     end = right;
                     right = mid -1;
                     left = left +1;
                 } else {
                     left = left +1;
                     right = right -1;
                 }
             } else if(nums[mid] < target) {
                 left = mid +1;
             } else {
                 right = mid -1;
             }
        }

        if(start == Integer.MAX_VALUE)
            start = -1;

        System.out.print(start + ", " );
        System.out.print(end);

        return new int[]{start, end};
    }

    private static int findEnd(int[] nums, int left, int right, int target) {
        int mid;
        while(left<=right) {
            mid = (left+right)/2;
            if(nums[mid] == target) {
                left = mid+1;
            } else {
                right = mid -1;
            }
        }

        return left;
    }
}
