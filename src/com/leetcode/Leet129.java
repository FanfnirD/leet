package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/6/15
 */
public class Leet129 {
    public int sumNumbers(TreeNode node) {
        return process01(node,0);
    }

    public int process01(TreeNode node, int i) {
        if (node == null) {
            return 0;
        }
        int temp = i * 10 + node.val;
        if (node.left == null && node.right == null) {
            return temp;
        }
        return process01(node.left, temp) + process01(node.right, temp);
    }

}
