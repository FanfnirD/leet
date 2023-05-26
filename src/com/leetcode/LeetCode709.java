package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/9
 */
public class LeetCode709 {


    /**
     * 大写变小写、小写变大写 : 字符 ^= 32;
     * 大写变小写、小写变小写 : 字符 |= 32;
     * 小写变大写、大写变大写 : 字符 &= -33;
     *
     * @param s
     * @return
     */
    public String toLowerCase(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                chars[i] |= 32;
            }
        }
        return new String(chars);
    }
}
