package com.leet;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

/**
 * @author Fafnir
 * @date 2023/6/21
 */
public class Leet113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        pathSum(root, targetSum, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void pathSum(TreeNode node, int rest, List<Integer> pathSum) {
        if (node.left == null && node.right == null) {
            if (rest - node.val == 0) {
                pathSum.add(node.val);
                res.add(new ArrayList<>(pathSum));
                pathSum.remove(pathSum.size() - 1);
            }
            return;
        }
        pathSum.add(node.val);
        if (node.left != null) {
            pathSum(node.left, rest - node.val, pathSum);
        }
        if (node.right != null) {
            pathSum(node.right, rest - node.val, pathSum);
        }
        pathSum.remove(pathSum.size() - 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

