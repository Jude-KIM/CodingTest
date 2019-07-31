package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 * For example, given n = 4, a solution set is"
 * [
 *     "(((())))",
 *     "((()()))",
 *     "((())())",
 *     "((()))()",
 *     "(()(()))",
 *     "(()()())",
 *     "(()())()",
 *     "(())(())",
 *     "(())()()",
 *     "()((()))",
 *     "()(()())",
 *     "()(())()",
 *     "()()(())",
 *     "()()()()"
 * ]
 */

public class GenerateParenthesis {

    public static Set<String> set = new HashSet<>();
    public static int n = 4;
    public static void main(String[] args) throws IOException {

        set = new HashSet<>();
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[n*2], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == n*2) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            System.out.println(current);
            generateAll(current, pos+1, result);
            current[pos] = ')';
            System.out.println(current);
            generateAll(current, pos+1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (int i=0; i< current.length; i++) {
            char c = current[i];
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }

        return (balance == 0);
    }

}
