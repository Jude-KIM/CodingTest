package jude.codingtest.java.DP;

import java.io.IOException;

public class StockCooldown {

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
     *
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit.
     * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
     *
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     * Example:
     *
     * Input: [1,2,3,0,2]
     * Output: 3
     * Explanation: transactions = [buy, sell, cooldown, buy, sell]
     *
     * input : {2,1,4}
     * output : 3
     *
     * input : {6,1,3,2,4,7}
     * output : 6
     *
     *
     *
     */

    public static void main(String[] args) throws IOException {
//        int[] input = {2,1,4};
//        int[] input = {6,1,3,2,4,7};
        int[] input = {1,4,2};

        System.out.println(maxProfit(input));
    }



    /**
     *
     * buy[]와 sell[]을 각각계산하는 dynamic programming 문제
     *
     *
     * buy[i] = sell[i-2] - input[i] 와 buy[i-1] 중에 큰 값.
     * sell[i] = sell[i-1] 과 buy[i-1] + input[i] 중에 큰 값.
     * 여기서 i-1은 아무것도 안 한 경우임. 그러니까 매 index에 대해 샀을때 안샀을때 혹은 팔았을때 안팔았을때 중에 큰 값을 저장하는 방식.
     */

    public static int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        if(prices.length < 2)
            return 0;

        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for(int i=2; i<prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }

        return sell[prices.length-1];

    }


    //이걸 아래처럼 recursive로 풀면 풀리긴 하지만 input의 length가 엄청긴 경우 timeout 발생함.
    /*
    //0 : buy
    //1 : sell
    //-1 : do nothing.
    public static int result = 0;
    public static int maxProfit(int[] prices) {
        int x, y;
        x = test(prices, 0, 0, 0, true);
        y = test(prices, 0, 0, -1, false);
        return Math.max(x,y);
    }

    private static int test(int[] prices, int profit,  int index, int command, boolean buy) {
        if(index > prices.length-1) {
            return profit;
        }

        switch (command) {
            case 0:
                if(index == prices.length - 1)
                    return profit;
                //buy
                profit = profit - prices[index];
                index++;
                result = Math.max(result, test(prices, profit, index, 1, true));
                result = Math.max(result, test(prices, profit, index, -1, true));
                return result;
            case 1:
                //sell
                profit = profit + prices[index];
                index++;
                result = Math.max(result, test(prices, profit, index, -1, false));
                return result;
            case -1:
                if(index == prices.length - 1) {
                    return profit;
                }
                index++;
                if(buy) {
                    result = Math.max(result, test(prices, profit, index, 1, true));
                    result = Math.max(result, test(prices, profit, index, -1, true));
                } else {
                    //cooldown
                    result = Math.max(result, test(prices, profit, index, 0, false));
                    result = Math.max(result, test(prices, profit, index, -1, false));
                }
                return result;
        }

        return result;
    }

 */
}
