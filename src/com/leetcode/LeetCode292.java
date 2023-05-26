package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/20
 */
public class LeetCode292 {
    public boolean canWinNim(int n) {
        // 使用包装类型的布尔数组，可以用 null 这个状态，表示当前 n 的结果还没有被计算出来
        Boolean[] memo = new Boolean[n + 1];
        return dfs(n, memo);
    }

    private boolean dfs(int n, Boolean[] memo) {
        if (n <= 3) {
            return true;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        // 如果 3 种选择，只要有一种对方输掉，自己就可以赢
        if (!dfs(n - 1, memo) || !dfs(n - 2, memo) || !dfs(n - 3, memo)) {
            memo[n] = true;
            return true;
        }
        // 否则自己输
        memo[n] = false;
        return false;
    }


}
