package jude.codingtest.java.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorder {

    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     *
     * Example:
     *
     * Input: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * Output: [1,3,2]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) throws IOException {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        build(root, result);

        return result;
    }

    public  static void build(TreeNode node, List<Integer> result) {

        if(node != null) {
            if(node.left != null)
                build(node.left, result);

            result.add(node.val);
            if(node.right != null)
                build(node.right, result);

        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
