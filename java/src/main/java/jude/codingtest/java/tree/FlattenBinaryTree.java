package jude.codingtest.java.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {
    /**
     * Given a binary tree, flatten it to a linked list in-place.
     *
     * For example, given the following tree:
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * The flattened tree should look like:
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     */

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.right = new TreeNode(6);
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return;
        build(list, root);
        root.left = null;
        TreeNode cur = root;
        for(int i = 1; i < list.size(); i++){
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
    }

    private static void build(List<Integer> list, TreeNode root) {
        if(root != null) {
            list.add(root.val);
            if(root.left != null) {
                build(list, root.left);
            }

            if(root.right != null) {
                build(list, root.right);
            }

        }
    }

}
