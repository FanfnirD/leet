package com.leet;

/**
 * @author Fafnir
 * @date 2023/5/26
 */
public class LeetCode1010 {


    public static void main(String[] args) {
        LeetCode1010 code = new LeetCode1010();
        System.out.println(code.numPairsDivisibleBy60(new int[]{60, 60, 60}));

    }

    static int ans = 0;

    //public int numPairsDivisibleBy60(int[] time) {
    //    if (time == null || time.length < 2) {
    //        return 0;
    //    }
    //
    //    backTracking(time, 0, 0, 2);
    //    return ans;
    //}
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        var cnt = new int[60];
        for (int t : time) {
            // 先查询 cnt，再更新 cnt，因为题目要求 i<j
            // 如果先更新，再查询，就把 i=j 的情况也考虑进去了
            ans += cnt[(60 - t % 60) % 60];
            cnt[t % 60]++;
        }
        return ans;


    }

    public void backTracking(int[] time, int startIndex, int sum, int deep) {
        if (startIndex > time.length) {
            return;
        }
        if (deep == 0) {
            if (sum % 60 == 0) {
                ans++;
            }
            return;
        }
        for (int i = startIndex; i < time.length; i++) {
            backTracking(time, i + 1, sum + time[i], deep - 1);
        }
    }
}
