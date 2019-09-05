package jude.codingtest.java.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LowestAncestor {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     *
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q
     * as the lowest node in T that has both p and q as descendants
     * (where we allow a node to be a descendant of itself).”
     *
     * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     *
     *
     *
     * Example 1:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     * Example 2:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
     *
     *
     * Note:
     *
     * All of the nodes' values will be unique.
     * p and q are different and both values will exist in the binary tree.
     */

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(37);
        TreeNode node2 = new TreeNode(-34);
        TreeNode node3 = new TreeNode(-48);
//        TreeNode node4 = new TreeNode(null);
        TreeNode node5 = new TreeNode(-100);
        TreeNode node6 = new TreeNode(-101);
        TreeNode node7 = new TreeNode(48);
//        TreeNode node8 = new TreeNode(7);
//        TreeNode node9 = new TreeNode(4);
//        TreeNode node10 = new TreeNode(4);
//        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(-54);
//        TreeNode node13 = new TreeNode(48);
        TreeNode node14 = new TreeNode(-71);
        TreeNode node15 = new TreeNode(-22);
//        TreeNode node16 = new TreeNode(48);
//        TreeNode node17 = new TreeNode(48);
//        TreeNode node18 = new TreeNode(48);
        TreeNode node19 = new TreeNode(8);


        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node7.left = node12;
        node12.left = node14;
        node12.right = node15;
        node15.right = node19;


//        TreeNode node3 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node0 = new TreeNode(0);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node4 = new TreeNode(4);
//
//        node3.left = node5;
//        node3.right = node1;
//        node5.left = node6;
//        node5.right = node2;
//        node2.left = node7;
//        node2.right = node4;
//        node1.left = node0;
//        node1.right = node8;




        System.out.println(lowestCommonAncestor(node3, node14, node19).val);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null) {
            if (right != null) {
                return root;
            }
            return left;
        }
        return right;
    }

}
