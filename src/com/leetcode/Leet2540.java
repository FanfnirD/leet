package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/19
 */
public class Leet2540 {
    public static void main(String[] args) {
        getCommon(new int[]{ 2, 4}, new int[]{1,2});
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if(nums1[0] > nums2[n2 - 1] || nums1[n1 - 1] < nums2[0]) return -1;

        int p1 = 0, p2 = 0;

        while(p1 < n1 && p2 < n2){
            if(nums1[p1] == nums2[p2]) return nums1[p1];
            else if(nums1[p1] > nums2[p2]) ++p2;
            else ++p1;
        }
        return -1;

    }
}
