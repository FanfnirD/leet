package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/25
 */
public class LeetCode8 {
    public int myAtoi(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] strArr = s.toCharArray();
        int length = strArr.length;
        int result = 0;
        int index = 0;
        int sign = 1;

        // 去除前置空格
        while (index < length && strArr[index] == ' ') {
            index++;
        }

        if (index == length) {
            return 0;
        }


        // 判断是否有符号位
        char firstChar = strArr[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }


        for (int i = index; i < strArr.length; i++) {
            char curChar = strArr[i];
            if (curChar > '9' || curChar < '0') {
                break;
            }
            int curNum = curChar-'0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && curNum > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && curNum > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + sign * curNum;
        }
        return result;
    }
}
