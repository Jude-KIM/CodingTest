package jude.codingtest.java.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTree {
    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * For example, given
     * <p>
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     */


    public static void main(String[] args) throws IOException {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
    }

    private static Map<Integer, Integer> inorderIndexMap = null;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        inorderIndexMap = IndexBuild(inorder);
        TreeNode root = buildBinaryTree(preorder.length, preorder, 0, inorder, 0);
        return root;
    }

    public static TreeNode buildBinaryTree(int len, int[] preorder,int pStart, int[] inorder, int iStart){
        if(len <= 0)
            return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int rootIndex = inorderIndexMap.get(root.val);
        int leftLen = rootIndex - iStart;
        root.left = buildBinaryTree(leftLen, preorder, pStart+1, inorder, iStart);
        root.right = buildBinaryTree(len-1-leftLen, preorder, pStart+1+leftLen, inorder, rootIndex+1);
        return root;
    }

    private static Map<Integer, Integer> IndexBuild(int[] inorder){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        for(int x : inorder){
            map.put(x, index);
            index ++;
        }
        return map;
    }


//    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//
//        int[] order = new int[5];
//        int root_index = map.get(preorder[0]);
//        for (int i = 0; i < preorder.length; i++) {
//            int number = preorder[i];
//            int index = map.get(number);
//            order[i] = index;
//        }
//        //1, 0, 3, 2, 4
//
////        TreeNode root = new TreeNode(order[0]);
////        test(root, root, preorder, order, 1);
//        TreeNode root = test(preorder, order, 0);
//        System.out.println("jude");
//
//        return root;
//    }

    private static TreeNode test(int[] preorder, int[] sort, int index) {
//        if(index >= preorder.length)
//            return;

        TreeNode root = new TreeNode(0);
        TreeNode parent;
        for(int i=1; i<preorder.length; i++) {

            if(root.val > sort[i]) {
                if(root.left == null) {
                    root.left = new TreeNode(sort[i]);
                } else {
                    root = root.left;
                    i = i-1;
                }
            } else {
                if(root.right == null) {
                    root.right = new TreeNode(sort[i]);
                } else {
                    root = root.right;
                    i = i-1;
                }

            }

        }

        return root;
    }

    private static void test(TreeNode compare, final TreeNode root, int[] preorder, int[] sort, int index) {
        if(index >= preorder.length)
            return;

        int number = sort[index];
        if (compare == null) {
            compare = new TreeNode(number);
            if(compare.val < root.val)
                root.left = compare;
            else
                root.right = compare;
            test(compare, root, preorder, sort, index + 1);
        } else {
            if (number > compare.val)
                test(compare.right, root, preorder, sort, index);
            else
                test(compare.left, root, preorder, sort, index);
        }
    }
}
//
//    private static TreeNode test(int[] preorder, int index, int root) {
//        preorder[];
//
//    }

/*
    private static TreeNode build(Map<Integer, Integer> map, int[] preorder, int start, int end, int root) {
        if(end <= start)
            return null;

        int index = map.get(preorder[root]);
        TreeNode node = new TreeNode(preorder[root]);
        node.left = build(map, preorder, start, index, root+1);
        node.right = build(map, preorder, index+1, end, root + index - start +1);
        return node;
    }
    */
