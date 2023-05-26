package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/22
 */
public class LeetCode941 {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int right = arr.length - 1;
        int left = 0;
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right - 1] > arr[right]) {
            right--;
        }
        return left > 0 && right < arr.length - 1 && left == right;

    }
}
