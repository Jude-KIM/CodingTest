package jude.codingtest.java;

import java.io.IOException;

public class ContainerWithMostWater {

    public static void main(String[] args) throws IOException {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        if(height.length == 2)
            return Math.min(height[0], height[1]);

        int left = 0;
        int right = height.length-1;
        int result = 0;
        while(left < right) {
            int multiple = Math.min(height[left],height[right]) * (right-left);
            if (result < multiple)
                result = multiple;

            if(height[left] < height[right])
                left = left+1;
            else
                right = right-1;
        }



/*
        for(int i=0; i< height.length - 1; i++) {
            for(int j = i+1; j<height.length; j++) {
                int y = Math.min(height[i], height[j]);
                int x = j - i;
                int sum = x * y;
                if(sum > result)
                    result = sum;
            }
        }
        */

        return result;
    }


}
