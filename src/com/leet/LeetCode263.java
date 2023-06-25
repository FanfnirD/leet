package com.leet;

import java.util.function.DoublePredicate;

/**
 * @author Fafnir
 * @date 2023/6/25
 */
public class LeetCode263 {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] ops = new int[]{2, 3, 5};
        for (int op : ops) {
            while (n % op == 0) {
                n /= op;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber3(5, 2, 11, 13));
    }

    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] record = new int[n + 1];
        record[0] = 1;
        int i = 1;
        int op2 = 0;
        int op3 = 0;
        int op5 = 0;

        while (i < n) {
            int min = Math.min(record[op2] * 2, Math.min(record[op3] * 3, record[op5] * 5));
            if (min == record[op2] * 2) {
                op2++;
            }
            if (min == record[op3] * 3) {
                op3++;
            }
            if (min == record[op5] * 5) {
                op5++;
            }
            record[i++] = min;
        }
        return record[n - 1];
    }

    public static int nthUglyNumber2(int n) {
        int[] res = new int[n + 1];
        if (res[1] == 0) {

            res[1] = 1;

            // 结果更新从第二个开始
            for (int i2 = 1, i3 = 1, i5 = 1, idx = 2; idx <= 1691; idx++) {

                int a = 2 * res[i2];
                int b = 3 * res[i3];
                int c = 5 * res[i5];
                int min = Math.min(a, Math.min(b, c));

                if (min == a) {
                    i2++;
                }
                if (min == b) {
                    i3++;
                }
                if (min == c) {
                    i5++;
                }

                res[idx] = min;

            }
        }

        return res[n];

    }



}
