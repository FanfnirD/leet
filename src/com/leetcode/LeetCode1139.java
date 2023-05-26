package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/4
 */
public class LeetCode1139 {


    public boolean makeEqual(String[] words) {
        if (words.length == 1)
            return true;
        int[] count = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                count[words[i].charAt(j) - 'a']++;
            }
        }
        for (int i : count) {
            if (i % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j][0]: (i,j)横向连续1的个数
        //dp[i][j][1]: (i,j)竖向连续1的个数
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //如果当前位置是0，就跳过
                if (grid[i - 1][j - 1] == 0) {
                    continue;
                }
                //如果是1，我们就计算横向和竖向连续1的个数
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }
        int maxSide = 0;// 记录正方形的最大长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int curSide = Math.min(dp[i][j][1], dp[i][j][0]);
                if (curSide < maxSide) {
                    continue;
                }
                for (; curSide > maxSide; curSide--) {
                    if (dp[i][j - curSide + 1][1] >= curSide && dp[i - curSide + 1][j][0] >= curSide) {
                        maxSide = curSide;
                        //更短的就没必要考虑了，这里直接中断
                        break;
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
}
