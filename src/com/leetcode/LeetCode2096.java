package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2096 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    static class TreeNode {
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

    class Solution {
        List<List<Character>> lls; //保存第二次和第三次回溯正确路径的集合
        List<Character> findStart; //保存第二次找起始节点的正确路径结合
        List<Character> findDest; //保存第三次找终点节点的正确路径集合

        public String getDirections(TreeNode root, int startValue, int destValue) {
            this.lls = new ArrayList<>();
            this.findStart = new ArrayList<>();
            this.findDest = new ArrayList<>();
            //找到两个节点的最近公共祖先节点
            TreeNode commonRoot = findRoot(root, startValue, destValue);
            //第二次回溯找起始节点的正确路径
            dfsStart(commonRoot, startValue);
            //第三次回溯找终点节点的正确路径
            dfsDest(commonRoot, destValue);
            StringBuilder sb = new StringBuilder();
            //获取两次回溯正确路径的每一步结果
            for (List<Character> paths : lls) {
                for (char path : paths) sb.append(path);
            }
            return sb.toString();
        }

        /**
         * 查询公共祖先
         *
         * @param root
         * @param startValue
         * @param destValue
         * @return
         */
        public TreeNode findRoot(TreeNode root, int startValue, int destValue) {
            if (root == null || root.val == startValue || root.val == destValue) return root;
            TreeNode left = findRoot(root.left, startValue, destValue);
            TreeNode right = findRoot(root.right, startValue, destValue);
            if (left == null) return right;
            if (right == null) return left;
            return root;
        }

        public void dfsStart(TreeNode root, int startValue) {
            if (root == null) return;
            //找到起始节点，保存该正确路径
            if (root.val == startValue) {
                lls.add(new ArrayList<>(findStart));
                return;
            }
            //不管往左子树还是右子树遍历，从起始节点出发都是从下向上前往父节点
            findStart.add('U');
            dfsStart(root.left, startValue);
            findStart.remove(findStart.size() - 1);
            findStart.add('U');
            dfsStart(root.right, startValue);
            findStart.remove(findStart.size() - 1);
        }

        public void dfsDest(TreeNode root, int destValue) {
            if (root == null) return;
            //找到终点节点，保存该正确路径
            if (root.val == destValue) {
                lls.add(new ArrayList<>(findDest));
                return;
            }
            //往当前节点的左子树遍历
            findDest.add('L');
            dfsDest(root.left, destValue);
            //回溯
            findDest.remove(findDest.size() - 1);
            //往当前节点的右子树遍历
            findDest.add('R');
            dfsDest(root.right, destValue);
            //回溯
            findDest.remove(findDest.size() - 1);
        }
    }


    public static void main(String[] args) {
        // [5,1,2,3,null,6,4]
        leetcode_2096 leetcode2096 = new leetcode_2096();
        TreeNode root = new TreeNode(5);
        // root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(6);

        leetcode2096.getDirections(root,3,6);

    }

    static class leetcode_2096 {
        List<List<Character>> lls; //保存第二次和第三次回溯正确路径的集合
        List<Character> findStart; //保存第二次找起始节点的正确路径结合
        List<Character> findDest; //保存第三次找终点节点的正确路径集合


        /**
         * 1、dp查询两个节点的公共祖先
         * 2、从左起始节点往上查询最近公共祖先
         * 2、从公共祖先往下查询右终止节点
         *
         * @param root
         * @param startValue
         * @param destValue
         * @return
         */
        public String getDirections(TreeNode root, int startValue, int destValue) {
            lls = new ArrayList<>(); // 保存两个节点的之间的最短路径

            findStart = new ArrayList<>(); // 起始节点-》公共祖先
            findDest = new ArrayList<>();// 公共祖先-》终止节点

            TreeNode commonRoot = findRoot(root, startValue, destValue);
            if (commonRoot == null) { // 没有公共祖先
                return "";
            }
            dfsStart(commonRoot, startValue);
            dfsDest(commonRoot,destValue);

            StringBuffer result = new StringBuffer();
            for (List<Character> paths : lls) {
                for (Character path : paths) {
                    result.append(path);
                }
            }
            return result.toString();
        }

        private void dfsStart(TreeNode root, int startValue) {
            if (root == null) return;

            if (root.val == startValue) {
                lls.add(new ArrayList<>(findStart));
                return;
            }


            findStart.add('U');
            dfsStart(root.left, startValue);
            findStart.remove(findStart.size() - 1);

            findStart.add('U');
            dfsStart(root.right, startValue);
            findStart.remove(findStart.size() - 1);
        }


        private void dfsDest(TreeNode root, int destValue) {
            if (root == null) return;

            if (root.val == destValue) {
                lls.add(new ArrayList<>(findDest));
                return;
            }


            findDest.add('L');
            dfsDest(root.left, destValue);
            findDest.remove(findDest.size() - 1);

            findDest.add('R');
            dfsDest(root.right, destValue);
            findDest.remove(findDest.size() - 1);
        }


        /**
         * 查询公共祖先
         *
         * @param root       头节点
         * @param startValue
         * @param destValue
         * @return
         */
        private TreeNode findRoot(TreeNode root, int startValue, int destValue) {

            if (root == null || root.val == startValue || root.val == destValue) {
                return root;
            }
            TreeNode left = findRoot(root.left, startValue, destValue);
            TreeNode right = findRoot(root.right, startValue, destValue);
            if (left == null && right == null) { //
                return null;
            }

            return left != null && right != null ? root : (left == null ? right : left);

        }
    }

}
