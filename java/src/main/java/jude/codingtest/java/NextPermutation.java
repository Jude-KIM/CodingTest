package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NextPermutation {

    //[5,4,7,5,3,2]
    // -> [5,5,2,3,4,7]

    //[2,2,7,5,4,3,2,2,1]
    //-> [2,3,1,2,2,2,4,5,7]

    public static void main(String[] args) throws IOException {

        int[] temp = {3,2,1};
        nextPermutation(temp);
    }

    public static void nextPermutation(int[] nums) {
        int target = -1;
        for(int i = nums.length -1; i >0; i--) {
            if(nums[i] > nums[i-1]) {
                target = i-1;
                break;
            }

        }

        if(target >= 0) {
            for(int j = nums.length - 1; j >=0; j--) {
                if(nums[j] > nums[target]) {
                    swap(nums, target, j);
                    break;
                }
            }
        }

        reverse(nums, target+1);

        for(int i:nums) {
            System.out.print(i);
        }
    }

    public static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
