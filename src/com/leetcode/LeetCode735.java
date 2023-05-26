package com.leetcode;

import java.util.ArrayDeque;

/**
 * @author fafnirH
 * @date 2023/4/28
 */
public class LeetCode735 {

    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int t : asteroids) {
            boolean flag = true;
            while (flag && !d.isEmpty() && d.peekLast() > 0 && t < 0) {
                int a = d.peekLast();
                int b = -t;
                if (a <= b) {
                    d.pollLast();
                }
                if (a >= b) {
                    flag = false;
                }

            }
            if (flag){
                d.addLast(t);
            }
        }
        int sz = d.size();
        int[] ans =new int[sz];
        while (!d.isEmpty()){
            ans[--sz] = d.pollLast();
        }
        return ans;
    }
}
