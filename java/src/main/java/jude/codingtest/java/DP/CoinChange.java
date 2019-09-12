package jude.codingtest.java.DP;

import java.io.IOException;
import java.util.Arrays;

public class CoinChange {

    /**
     * https://leetcode.com/problems/coin-change/
     *
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     *
     * Example 1:
     *
     * Input: coins = [1, 2, 5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     * Example 2:
     *
     * Input: coins = [2], amount = 3
     * Output: -1
     * Note:
     * You may assume that you have an infinite number of each kind of coin.
     */


    public static void main(String[] args) throws IOException {
//        int[] input = {2,1,4};
//        int[] input = {6,1,3,2,4,7};
//        int[] input = {2};
        int[] input ={1};

        System.out.println(coinChange(input, 2));
    }


    /**
     * 1 부터 amount까지 순서대로 최소값을 배열에 저장하는 dynamic program.
     * result[0] = 0으로 초기화.
     *
     * result[i]에 코인 종류별로 i-코인 한값을 넣고 그 중에 최소값을 최종 저장.
     *
     */
    public static int coinChange(int[] coins, int amount) {

        int[] result = new int[amount+1];
        Arrays.fill(result, amount + 1);
        result[0] = 0;
        for(int i=1; i<= amount; i++) {
            for(int j=0; j<coins.length; j++) {
                if(coins[j] <= i)
                    result[i] = Math.min(result[i], 1+ result[i - coins[j]]);
            }
        }

        if(result[amount] > amount)
            return -1;

        return result[amount];

    }
}
