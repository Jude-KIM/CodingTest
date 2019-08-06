package jude.codingtest.java.tree;

import java.io.IOException;

public class UniqueBinarySearchTree {

    /**
     *
     * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
     *
     * Example:
     *
     * Input: 3
     * Output: 5
     * Explanation:
     * Given n = 3, there are a total of 5 unique BST's:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     * Input: 4
     * Output: 14
     *
     * Input: 5
     * Output: 42
     */

    public static void main(String[] args) throws IOException {
        int input = 11;
        System.out.println(numTrees(input));
    }

    public static int numTrees(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        long top = factorial(2*n);
        long bottom = factorial(n) * factorial(n+1);
        return (int) (top/bottom);
    }

    public static long factorial(int n) {
        long count = n;
        for(int i = n -1 ; i >= 1; i--) {
            count = count * i;
        }

        return count;
    }
}
