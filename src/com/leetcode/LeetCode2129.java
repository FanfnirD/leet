package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/11
 */
public class LeetCode2129 {

    public static void main(String[] args) {
        capitalizeTitle("First leTTeR of EACH Word");
    }

    public static String capitalizeTitle(String title) {
        if (title == null || title.length() < 3) {
            return title.toLowerCase();
        }
        int left = 0;
        int right = 0;

        char[] chars = title.toCharArray();
        while (right < chars.length) {
            if (chars[right] == ' ') {
                if (right - left > 2) {
                    chars[left] = Character.toUpperCase(chars[left]);
                }
                left = right < chars.length - 1 ? right + 1 : right;
            } else {
                chars[right] = Character.toLowerCase(chars[right]);
            }
            right++;
        }
        if (right - left > 2) {
            chars[left] = Character.toUpperCase(chars[left]);
        }
        return new String(chars);
    }
}
