package com.leet;

/**
 * @author Fafnir
 * @date 2023/5/23
 */
public class Leet1287 {
    public static void main(String[] args) {
        Leet1287 leet1287 = new Leet1287();
        leet1287.uniquePaths(3, 2);
        System.out.println(leet1287.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int n1 = 1; n1 < m; n1++) {
            for (int n2 = 1; n2 < n; n2++) {
                dp[n1][n2] = dp[n1 - 1][n2] + dp[n1][n2 - 1];
            }
        }
        return dp[m - 1][n - 1];

    }

    //public int uniquePaths(int m, int n) {
    //    int[][] cache = new int[m][n];
    //    return dp1(m - 1, n - 1, m, n,cache);
    //}

    public int dp(int step1, int step2, int m, int n) {
        if (step1 >= m || step1 < 0 || step2 >= n || step2 < 0) {
            return 0;
        }
        if (step1 == 0 && step2 == 0) {
            return 1;
        }
        return dp(step1 - 1, step2, m, n) + dp(step1, step2 - 1, m, n);

    }

    public int dp1(int step1, int step2, int m, int n, int[][] cache) {
        if (step1 >= m || step1 < 0 || step2 >= n || step2 < 0) {
            return 0;
        }
        if (cache[step1][step2] != 0) {
            return cache[step1][step2];
        }
        if (step1 == 0 && step2 == 0) {
            return 1;
        }

        cache[step1][step2] = dp1(step1 - 1, step2, m, n, cache) + dp1(step1, step2 - 1, m, n, cache);
        return cache[step1][step2];

    }
}
