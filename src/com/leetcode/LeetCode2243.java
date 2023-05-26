package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/8
 */
public class LeetCode2243 {
    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i += k) {
            int sum = 0;
            for (int t = 0; t < k && i + t < s.length(); t++) {
                sum += (s.charAt(i + t) - '0');
            }
            sb.append(sum);
        }
        return digitSum(sb.toString(), k);
    }
}
