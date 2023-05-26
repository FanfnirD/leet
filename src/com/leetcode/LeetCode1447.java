package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fafnirH
 * @date 2023/4/21
 */
public class LeetCode1447 {
    int gcd(int a, int b) { // 欧几里得算法
        return b == 0 ? a : gcd(b, a % b);
    }

    /*int gcd(int a, int b) { // 更相减损法
        while (true) {
            if (a > b) a -= b;
            else if (a < b) b -= a;
            else return a;
        }
    }*/


    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) ans.add(i + "/" + j);
            }
        }
        return ans;
    }

}
