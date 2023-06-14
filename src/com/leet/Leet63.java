package com.leet;

/**
 * @author Fafnir
 * @date 2023/6/14
 */
public class Leet63 {
    public static int uniquePathsWithObstacles(int[][] obs) {
        if (obs == null) {
            return 0;
        }
        int N = obs.length;
        int M = obs[0].length;
        if (obs[0][0] == 1 || obs[N - 1][M - 1] == 1) {
            return 0;
        }
        int[] dp = new int[M];
        dp[M - 1] = 1;
        for (int i = M - 2; i >= 0 && obs[N - 1][i] == 0; i--) {
            dp[i] = 1;
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (j == M - 1) {
                    dp[j] = obs[i][j] == 1 || dp[j] == 0 ? 0 : 1;
                } else {
                    dp[j] = obs[i][j] == 1 ? 0 : dp[j] + dp[j + 1];
                }
            }
        }
        return dp[0];
    }

    public static int uniquePathsWithObstacles1(int[][] obs) {
        if (obs == null) {
            return 0;
        }
        int N = obs.length;
        int M = obs[0].length;
        if (obs[0][0] == 1 || obs[N - 1][M - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[N][M];
        dp[N - 1][M - 1] = 1;
        for (int i = M - 2; i >= 0 && obs[N - 1][i] == 0; i--) {
            dp[N - 1][i] = 1;
        }
        for (int i = N - 2; i >= 0 && obs[i][M - 1] == 0; i--) {
            dp[i][M - 1] = 1;
        }


        for (int i = N - 2; i >= 0; i--) {
            for (int j = M - 2; j >= 0; j--) {
                if (obs[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j];
                    dp[i][j] += dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles1(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
