package com.leet;

import com.leetcode.TreeNode;

import java.util.TooManyListenersException;

/**
 * @author Fafnir
 * @date 2023/6/28
 */
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return process01(nums, 0, nums.length - 1);
    }

    public TreeNode process01(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process01(nums, l, mid - 1);
        root.right = process01(nums, mid + 1, r);
        return root;
    }
}
