package com.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Fafnir
 * @date 2023/5/30
 */
public class LeetCode102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        levelOrder(root);
    }

    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);
        TreeNode endNode = root;
        TreeNode preEndNode = null;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            temp.add(cur.val);

            if (cur.left != null) {
                queue.addLast(cur.left);
                endNode = cur.left;
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
                endNode = cur.right;
            }
            if (preEndNode == null || preEndNode == cur) {
                res.add(new ArrayList<>(temp));
                temp.clear();
                preEndNode = endNode;
            }

        }
        return res;
    }
}
