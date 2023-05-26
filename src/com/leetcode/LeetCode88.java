package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/25
 */
public class LeetCode88 {

    public static void main(String[] args) {

        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length < 1) {
            return;
        }
        if (nums1.length == 1 && nums2.length == 1) {
            nums1[0] = nums2[0];
            return;
        }
        if (n != 0 && nums2[n - 1] <= nums1[0]) {
            for (int i = m - 1; i >= 0; i--) {
                nums1[i + n] = nums1[i];
            }
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        if (m != 0 && nums2[0] >= nums1[m - 1]) {
            for (int i = 0; i < n; i++) {
                nums1[i + m] = nums2[i];
            }
            return;
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] > nums2[index2]) {
                for (int i = m; i > index1; i--) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[index1++] = nums2[index2++];
                m++;
            } else {
                index1++;
            }
        }
        while (index2 < n) {
            nums1[index1++] = nums2[index2++];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        int p = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p--] = nums1[i--];
            } else {
                nums1[p--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[p--] = nums2[j--];
        }
    }
}
