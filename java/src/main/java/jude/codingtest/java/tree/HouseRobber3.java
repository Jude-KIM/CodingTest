package jude.codingtest.java.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class HouseRobber3 {

    /**
     * The thief has found himself a new place for his thievery again.
     * There is only one entrance to this area, called the "root." Besides the root,
     * each house has one and only one parent house.
     *
     * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
     * It will automatically contact the police if two directly-linked houses were broken into on the same night.
     *
     * Determine the maximum amount of money the thief can rob tonight without alerting the police.
     * Example 1:
     * Input: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * Output: 7
     * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     *
     * Example 2:
     * Input: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * Output: 9
     * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
     */

    public static void main(String[] args) throws IOException {
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node4.left = node1;
        node1.left = node2;
        node2.left = node3;

//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(1);
//        TreeNode node7 = new TreeNode(3);
//        TreeNode node8 = new TreeNode(1);
//        node3.left = node4;
//        node3.right = node5;
//        node5.right = node8;
//        node4.left = node6;
//        node4.right = node7;


        System.out.println("" + rob(node4));
    }


    /**
     * DFS와 DP의 짬뽕인 문제.
     * 각 node에 대해 선택이 두가지로 나뉜다.
     * 훔친다 : node + node.left.left + node.left.right + node.right.left + node.right.right;
     * 안훔친다 : node.left + node.right
     *
     * 이걸 recursive로 구현하면 됨.
     * return 하기 전의 max 값을 map에 캐시하면 속도가 빨라짐
     */
    public static HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    public static int rob(TreeNode root) {

        if(root == null)
            return 0;

        if(map.containsKey(root))
            return map.get(root);

        if(root.left == null && root.right == null)
            return root.val;

        int select = root.val;
        int notSelect = rob(root.left) + rob(root.right);
        if(root.left != null)
            select = select + rob(root.left.left) + rob(root.left.right);
        if(root.right != null)
            select = select + rob(root.right.left) + rob(root.right.right);

        int result = Math.max(select, notSelect);
        map.put(root, result);

        return result;
    }
}
