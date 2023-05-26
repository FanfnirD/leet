package com.leetcode;

import java.util.HashSet;
import java.util.zip.CheckedInputStream;

/**
 * @author fafnirH
 * @date 2023/4/21
 */
public class LeetCode1346 {

    public static void main(String[] args) {
        int[] arr = new int[]{10,2,5,3};
        boolean b = checkIfExist(arr);
    }
    public static boolean checkIfExist(int[] arr) {

        if (arr.length < 2) {
            return false;
        }

        HashSet<Double> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains((double) arr[i] / 2) || set.contains(arr[i] * 2.0)) {
                return true;
            }
            set.add((double) arr[i]);
        }

        return false;
    }
}
