package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/3
 */
public class LeetCode404 {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LeetCode404 leetCode404 = new LeetCode404();
        leetCode404.sumOfLeftLeaves(root);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            result += root.left.val;
        }

        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);


        return leftSum + rightSum + result;

    }
}
