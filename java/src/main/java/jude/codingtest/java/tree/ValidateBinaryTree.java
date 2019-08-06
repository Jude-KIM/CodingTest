package jude.codingtest.java.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jude.codingtest.java.tree.UniqueBinarySearchTree.numTrees;

public class ValidateBinaryTree {

    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * Assume a BST is defined as follows:
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     *
     * Example 1:
     *
     *     2
     *    / \
     *   1   3
     *
     * Input: [2,1,3]
     * Output: true
     * Example 2:
     *
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     *
     * Input: [5,1,4,null,null,3,6]
     * Output: false
     * Explanation: The root node's value is 5 but its right child's value is 4.
     *
     *
     *     10
     *    / \
     *   5   15
     *      / \
     *     6   20
     *
     * [10,5,15,null,null,6,20]
     * Output : false
     */

    public static void main(String[] args) throws IOException {
        BinaryTreeInorder.TreeNode node5 = new BinaryTreeInorder.TreeNode(5);
        node5.left = new BinaryTreeInorder.TreeNode(1);
//        node5.right = new BinaryTreeInorder.TreeNode(3);

        BinaryTreeInorder.TreeNode node4 = new BinaryTreeInorder.TreeNode(4);
        node4.left = new BinaryTreeInorder.TreeNode(3);
        node4.right = new BinaryTreeInorder.TreeNode(6);
        node5.right = node4;

        System.out.println(isValidBST(node5));
    }


//            *     10
//             *    / \
//             *   5   15
//             *      / \
//             *     6   20
    public static boolean isValidBST(BinaryTreeInorder.TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return build(root, list);
//        return false;
    }

    public static boolean build(BinaryTreeInorder.TreeNode node, List<Integer> list) {
            if (node != null) {
                if (node.left != null) {
                    boolean test = build(node.left, list);
                    if(!test)
                        return false;
                }

                if(list.size() > 0 && list.get(list.size()-1) >= node.val)
                    return false;
                list.add(node.val);
//                if(list.size() > 2) {
//                    int left = list.get(list.size()-2);
//                    int right = list.get(list.size()-1);
//                    if(left >= right)
//                        return false;
//                }

                if (node.right != null) {
                    boolean result = build(node.right, list);
                    if(!result)
                        return false;
                }
            }
            return true;

//        return true;
    }

}
