package jude.codingtest.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *String s is an array of lowercase English characters (a-z) indexed from 0 to N − 1.
 * Each index i (where 0 ≤ i < N) in s contains character si.
 * Iterate through each character in s and, for each index i, count the occurrences, k, of si in the inclusive range of indices from 0 to i-1.
 * Then cyclically increment character si by k and save the resulting value to index i in a new string, q.
 * Given s, find string q and print it on a new line.
 * Note: Cyclically incrementing a lowercase character by an integer means that a + 1 = b, b + 2 = d, and z + 1 = a.
 * Input Format
 * The first line contains T (the number of test cases). Each test case is described over two lines.
 * For each test case, the first line contains an integer, N, and the second line contains a string of length N.
 * Constraints
 * 1 ≤ T ≤ 20 5 1 ≤ N ≤ 10
 * Output Format
 * For each test case, print string q on a new line.
 */
public class StringTransformation {

    public static void main (String[] test) throws java.lang.Exception
    {
        String[] args = {"4","5", "aaabbbccc", "10", "abcdeabcde", "3","yzz", "6", "apapap"};
        int numOfCase = Integer.parseInt(args[0]);

        List<String> list = new ArrayList<>();

        list.addAll(Arrays.asList(args));

        for(int i = 0; i< args.length; i++) {
            try{
                int temp = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                buildMap(args[i]);
            }
//            if(i%2 == 0) {
//
//            }
        }
    }

    private static void buildMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder(s.length());
        for(int i=0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if(map.containsKey(key)) {
                int value = map.get(key);;
                map.put(key, value+1);
                builder.append(convert(key, value));
            } else {
                map.put(key, 1);
                builder.append(key);
            }
        }
        System.out.println(builder.toString());
    }

    final static int REBASE = (int) 'a';
    final static int INTEGER_Z = (int) 'z';
    private static char convert(char c, int count) {
        int number = (int) c;
        number = number + count;
        if(number > INTEGER_Z) {
            number = REBASE + number - 123;
        }

        return (char) number;
    }
}
