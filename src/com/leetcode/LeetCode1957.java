package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/25
 */
public class LeetCode1957 {

    public static void main(String[] args) {
        String s = "leeetcode";
        String s1 = makeFancyString(s);
        System.out.println(s1);
    }

    public static String makeFancyString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] strArr = s.toCharArray();

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0 || strArr[i] == strArr[i - 1]) {
                count++;
            } else {
                for (int j = 0; j < count && j < 2; j++) {
                    sb.append(strArr[i - 1]);
                }
                count = 1;
            }
        }

        for (int j = 0; j < count && j < 2; j++) {
            sb.append(strArr[strArr.length - 1]);
        }

        return sb.toString();
    }
}
