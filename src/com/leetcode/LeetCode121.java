package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/25
 */
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int down = prices[0];
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - down);
            down = Math.min(down, prices[i]);

        }
        return profit;
    }
}
