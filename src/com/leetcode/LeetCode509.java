package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/28
 */
public class LeetCode509 {

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(fib(i));
        }
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int pre1 = 1;
        int pre2 = 1;
        int cur = 0;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            cur = pre1 + pre2;
            temp = pre2;
            pre2 = cur;
            pre1 = temp;

        }
        return cur;
    }
}
