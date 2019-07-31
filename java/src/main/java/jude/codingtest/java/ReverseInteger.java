package jude.codingtest.java;

import java.io.IOException;

public class ReverseInteger {

//    Given a 32-bit signed integer, reverse digits of an integer.
//
//            Example 1:
//
//    Input: 123
//    Output: 321
//    Example 2:
//
//    Input: -123
//    Output: -321
//    Example 3:
//
//    Input: 120
//    Output: 21
//    Note:
//    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

    public static void main(String[] args) throws IOException {
        int x = -123;
        System.out.println(reverse(x));
    }

    private static int reverse(int x) {
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;

        StringBuilder builder;
        if(x < 0) {
            builder = new StringBuilder("" + -x).append("-").reverse();
        } else {
            builder = new StringBuilder("" + x).reverse();
        }


        return Integer.parseInt(builder.toString());
    }


}
