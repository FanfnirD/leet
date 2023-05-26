package com.leetcode;

import java.util.LinkedList;

/**
 * @author Fafnir
 * @date 2023/5/15
 */
public class Leetcode1161 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        maxLevelSum(root);

    }

    public static int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        TreeNode endNode = root;
        TreeNode nextEndNode = null;
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int maxLevel = 0;
        int curLevel = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            if (cur.left != null) {
                queue.addLast(cur.left);
                nextEndNode = cur.left;
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
                nextEndNode = cur.right;
            }
            curSum += cur.val;
            if (cur == endNode) {
                if (curSum > maxSum) {
                    maxSum = curSum;
                    maxLevel = curLevel;
                }
                endNode = nextEndNode;
                curSum = 0;
                curLevel++;
            }
        }
        return maxLevel;
    }
}
