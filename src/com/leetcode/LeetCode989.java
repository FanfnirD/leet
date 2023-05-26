package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fafnir
 * @date 2023/5/12
 */
public class LeetCode989 {


    public static void main(String[] args) {
        addToArrayForm(new int[]{2, 1, 7}, 806);
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        List<Integer> res = new ArrayList<>();
        int i = n - 1, sum = 0, carry = 0;
        while (i >= 0 || k != 0) {
            int x = i >= 0 ? num[i]: 0;
            int y = k != 0 ? k % 10 : 0;

            sum = x + y + carry;
            carry = sum / 10;
            k = k / 10;

            i--;
            res.add(0, sum % 10);
        }
        if (carry != 0) res.add(0, carry);
        return res;
    }
}
