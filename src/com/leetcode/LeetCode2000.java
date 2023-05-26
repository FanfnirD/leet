package com.leetcode;

import javax.swing.*;

/**
 * @author Fafnir
 * @date 2023/5/16
 */
public class LeetCode2000 {
    public String reversePrefix(String word, char ch) {
        if (word.charAt(0) == ch) {
            return word;
        }
        char[] str = word.toCharArray();
        int l = 0;
        int r = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ch) {
                r = i;
                break;
            }
        }
        if (r == -1) {
            return word;
        }
        while (l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
        return new String(str);
    }
}
