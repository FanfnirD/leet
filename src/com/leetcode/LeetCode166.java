package com.leetcode;

import java.util.HashMap;

/**
 * @author fafnirH
 * @date 2023/4/24
 */
public class LeetCode166 {

    /**
     * 模拟竖式计算
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        long num1 = numerator;
        long num2 = denominator;

        // 如果能整除直接返回
        if (num1 % num2 == 0) {
            return String.valueOf(num1 / num2);
        }

        StringBuilder sb = new StringBuilder();

        // 如果存在其中有一个为负数
        if (num1 < 0 ^ num2 < 0) {
            sb.append("-");
        }
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        sb.append(num1 / num2 + ".");

        num1 %= num2;
        HashMap<Long, Integer> map = new HashMap<>();

        while (num1 != 0) {
            map.put(num1, sb.length());
            num1 *= 10;
            sb.append(num1 / num2);
            num1 %= num2;


            // 存在循环
            if (map.containsKey(num1)) {
                int u = map.get(num1);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }

        }
        return sb.toString();
    }
}
