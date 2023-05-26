package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/25
 */
public class LeetCode7 {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;//2147483647
        int minValue = Integer.MIN_VALUE;//-2147483648
        System.out.println(String.format("min=%d,max=%d", minValue, maxValue));
    }

    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int tmp = x % 10;
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }

        return res;
    }
}
