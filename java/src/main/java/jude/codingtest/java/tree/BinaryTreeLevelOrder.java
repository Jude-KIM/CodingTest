package jude.codingtest.java.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeLevelOrder {

    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its level order traversal as:
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */

    public static void main(String[] args) throws IOException {
        TreeNode node5 = new TreeNode(3);
        node5.left = new TreeNode(9);
//        node5.right = new BinaryTreeInorder.TreeNode(20);
        TreeNode node4 = new TreeNode(20);
        node4.left = new TreeNode(15);
        node4.right = new TreeNode(7);
        node5.right = node4;
        System.out.println(levelOrder(node5).toString());
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        build(map, root, 0);
        result.addAll(map.values());
        return result;
    }

    private static void build(Map<Integer, List<Integer>> map, TreeNode node, int level) {
        List<Integer> list = map.get(level);
        if(list == null)
            list = new ArrayList<>();

        list.add(node.val);
        map.put(level, list);

        if(node.left != null)
            build(map, node.left, level+1);

        if(node.right != null)
            build(map, node.right, level+1);
    }


}
