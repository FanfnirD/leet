package com.leetcode;

import javax.imageio.event.IIOReadProgressListener;
import java.util.Stack;

/**
 * @author fafnirH
 * @date 2023/4/3
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        //if (n == 0 || n == 1) return 1;
        //if (n < 0) return 0;
        //return climbStairs(n - 1) + climbStairs(n - 2);

        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}

class SortedStack {


    private Stack<Integer> minStack;
    private Stack<Integer> tempStack;

    public SortedStack() {

        this.minStack = new Stack<>();
        this.tempStack = new Stack<>();
    }

    public void push(int val) {
        while (!minStack.isEmpty() && minStack.peek() < val) {
            tempStack.push(minStack.pop());
        }
        minStack.push(val);
        while (!tempStack.isEmpty()) {
            minStack.push(tempStack.pop());
        }
    }

    public void pop() {
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int peek() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public boolean isEmpty() {
        return minStack.isEmpty();
    }
}

