package com.leetcode;

import java.util.Arrays;

/**
 * @author Fafnir
 * @date 2023/5/19
 */
public class LargetNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = "" + nums[i];
        }
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b;
            String sb = b + a;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i]);
        }
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
}
