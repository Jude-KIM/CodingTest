package jude.codingtest.java;

import java.io.IOException;
import java.util.Arrays;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class CountingBits {

    /**
     * Given a non negative integer number num.
     * For every numbers i in the range 0 ≤ i ≤ num calculate
     * the number of 1's in their binary representation and return them as an array.
     *
     * Example 1:
     *
     * Input: 2
     * Output: [0,1,1]
     * Example 2:
     *
     * Input: 5
     * Output: [0,1,1,2,1,2]
     * Follow up:
     *
     * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
     * But can you do it in linear time O(n) /possibly in a single pass?
     * Space complexity should be O(n).
     * Can you do it like a boss? Do it without
     * using any builtin function like __builtin_popcount in c++ or in any other language.
     */

    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(countBits(24)));
    }
//
//    23= 16 + 7
//    24 == 16 + 8
//      1
//     10
//     11
//    100
//    101
//    0 1 2 3 4 5 6 7 8 9 10 11 12
// 0,1,1,2,1,2,
//   2,3,1,2,2,
//   3,2,3,3,4,
//   1,2,2,3,2,
//   3,3,4,3(여기가 2임),4,
//   4,5,4,5,5,6,1,2,2,3,2,3,3,4,3,4,4,5,4,5,5,6,5,6,6,7,6,7,7,8,7,8,8,9,8,9,9,10,1]
    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        if(num ==0)
            return result;
        result[1] = 1;

        for(int i=1; i<=num; i++)
            result[i] = result[i/2] + result[i%2];

        /*
        이렇게 복잡하게 풀 필요없음.
        int index = 2;
        int lastPow = 1;
        for(int i=3; i<=num; i++) {
            if(i%2 == 0) {
                //짝수
                if(index * 2 == i) {
                    //2의 n제곱수
                    result[i] = 1;
                    index = index *2;
                    lastPow = i;
                } else {
                    int temp = i/2;
                    if(temp % 2 == 0) {
                        result[i] = 1 + result[i-lastPow];
                    } else {
                        result[i] = result[i - 1];
                    }

                }
            } else {
                //홀수
                result[i] = result[i-1] + 1;
            }
        }
        return result;
         */

        return result;
    }
}
