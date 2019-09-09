package jude.codingtest.java;

import java.io.IOException;
import java.util.Arrays;

public class PerfectSquare {

    /**
     * Given a positive integer n,
     * find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
     *
     * Example 1:
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4.
     *
     * Example 2:
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9.
     *
     *
     * 88 = 3
     *
     */

    public static void main(String[] args) throws IOException {
        System.out.println(numSquares(88));
    }

    /**
     * Dynamic programming으로 풀어야 하는 문제.
     * 최소값을 찾는 문제이므로 배열을 Integer.Max 로 초기화 시켜 놓고 시작.
     * 제곱해서 i보다 작거나 같은 모든 정수 j에 대해 아래를 계산해야 함
     * res[i] = Math.min(res[i-j*j] + 1, res[i])
     *
     */
    public static int numSquares(int n) {
        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        result[1] = 1;

        for(int i=1; i <= n; i++) {
            for(int j=1; j*j<=i; j++) {
                result[i] = Math.min(result[i - j*j] + 1, result[i]);
            }
            if(i == n)
                return result[i];
        }
        return 0;
    }
}
