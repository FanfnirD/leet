package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fafnirH
 * @date 2023/4/23
 */
public class LeetCode2570 {

    public static void main(String[] args) {
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] ints = mergeArrays(nums1, nums2);
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        if (nums1 == null || nums1.length < 1) {
            return nums2;
        }
        if (nums2 == null || nums2.length < 1) {
            return nums1;
        }

        int[][] result = new int[nums1.length + nums2.length][2];

        int num1Cur = 0;
        int num2Cur = 0;
        int resIndex = 0;
        while (num1Cur < nums1.length && num2Cur < nums2.length) {
            int[] temp = null;
            if (nums1[num1Cur][0] == nums2[num2Cur][0]) {
                temp = new int[]{nums1[num1Cur][0], nums2[num2Cur++][1] + nums1[num1Cur++][1]};
            } else if (nums1[num1Cur][0] > nums2[num2Cur][0]) {
                temp = new int[]{nums2[num2Cur][0], nums2[num2Cur++][1]};
            } else {
                temp = new int[]{nums1[num1Cur][0], nums1[num1Cur++][1]};
            }
            result[resIndex++] = temp;
        }

        // 找出剩余的数组
        int[][] lessArr = num1Cur == nums1.length ? nums2 : nums1;
        int lessCur = lessArr == nums1 ? num1Cur : num2Cur;
        while (lessCur < lessArr.length) {
            result[resIndex][0] = lessArr[lessCur][0];
            result[resIndex][1] = lessArr[lessCur][1];
            resIndex++;
            lessCur++;
        }

        return Arrays.copyOfRange(result, 0, resIndex);
    }
}
