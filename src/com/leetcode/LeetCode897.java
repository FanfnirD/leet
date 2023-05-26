package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/27
 */
public class LeetCode897 {


    class Recursion {
        public TreeNode headNode;

        public TreeNode endNode;

        public Recursion() {
        }

        public Recursion(TreeNode headNode, TreeNode endNode) {
            this.headNode = headNode;

            this.endNode = endNode;
        }
    }




    TreeNode prev;
    TreeNode r;

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev == null) {
            r = root;
        } else {
            prev.right = root;
        }
        prev = root;
        root.left = null;
        helper(root.right);
    }

}
