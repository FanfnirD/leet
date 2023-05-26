package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/9
 */
public class LeetCode1299 {
    public static void main(String[] args) {
        replaceElements(new int[]{17, 18, 5, 4, 6, 1});
    }

    public static int[] replaceElements(int[] arr) {
        if (arr.length < 2) {
            return new int[]{-1};
        }
        int rightMax = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = rightMax;
            if (temp > rightMax) {
                rightMax = temp;
            }
        }
        return arr;
    }
}
