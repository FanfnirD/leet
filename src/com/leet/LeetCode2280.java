package com.leet;

import java.util.Arrays;

/**
 * @author Fafnir
 * @date 2023/5/29
 */
public class LeetCode2280 {

    public static void main(String[] args) {
        LeetCode2280 leet = new LeetCode2280();
        int i = leet.minimumLines(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}});
        System.out.println(i);
    }

    public int minimumLines(int[][] stockPrices) {
        if (stockPrices == null || stockPrices.length == 1) {
            return 0;
        }
        Arrays.sort(stockPrices, (arr1, arr2) -> {
            return arr1[0] - arr2[0];
        });
        int len = stockPrices.length;
        int ans = 1;
        for (int i = 2; i < len; i++) {
            int x1 = stockPrices[i][0] - stockPrices[i - 1][0];
            int y1 = stockPrices[i][1] - stockPrices[i - 1][1];
            int x2 = stockPrices[i - 1][0] - stockPrices[i - 2][0];
            int y2 = stockPrices[i - 1][1] - stockPrices[i - 2][1];
            if (x1 * y2 != x2 * y1){
                ans++;
            }
        }
        return ans;
    }
}


