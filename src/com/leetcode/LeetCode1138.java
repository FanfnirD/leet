package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/3
 */
public class LeetCode1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        int x = 0, y = 0;
        for (char c : target.toCharArray()) {
            int nx = (c - 'a') / 5;
            int ny = (c - 'a') % 5;

            String v = nx < x ? "U".repeat(x - nx) : "D".repeat(nx - x); // 竖直
            String h = ny < y ? "L".repeat(y - ny) : "R".repeat(ny - y); // 水平

            ans.append(c != 'z' ? v + h : h + v).append('!');

            x = nx;
            y = ny;
        }
        return ans.toString();
    }


}
