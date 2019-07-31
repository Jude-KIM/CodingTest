package jude.codingtest.java;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Consider a string that consists of lowercase English alphabetic letters (i.e., [a-z]) only. The following rules are used to encode all of its characters
 * into string s:
 * a is encoded as 1, b is encoded as 2, c is encoded as 3, ..., and i is encoded as 9.
 * j is encoded as 10#, k is encoded as 11#, l is encoded as 12#, ..., and z is encoded as 26#.
 * If there are two or more consecutive occurrences of any character, then the character count is written within parentheses (i.e., (c) , where c is an integer denoting the count of consecutive occurrences being encoded) immediately following the encoded character. For example, consider the following string encodings:
 * String "abzx" is encoded as s = "1226#24#".
 * String "aabccc" is encoded as s = "1(2)23(3)".
 * String "bajj" is encoded as s = "2110#(2)".
 * String "wwxyzwww" is encoded as s = "23#(2)24#25#26#23#(3)".
 * Given an encoded string s, determine the character counts for each letter of the original, decoded string. Return an integer array of length 26 where index 0 contains the number of 'a' characters, index 1 contains the number of 'b' characters and so on.
 * Function Description
 * Complete the frequency function in the editor below. It should return an array of 26 integers as described. frequency has the following parameter:
 * s: an encoded string Constraints
 * String s consists of decimal integers from 0 to 9, #'s, and ()'s only.
 * 1 ≤ length of s ≤ 105
 * It is guaranteed that string s is a valid encoded string.
 * 2 ≤ c ≤ 104, where c is a parenthetical count of consecutive occurrences of an encoded character.
 * Input Format For Custom Testing
 * Input from stdin will be processed as follows and passed to the function. The only line contains the string s, the encoded string.
 */
public class LongEncodedString {

    public static void main (String[] args) throws java.lang.Exception
    {
//        String input = "1(2)226#24#";
//        String input = "1226#24#";
//        String input = "23#(2)24#25#26#23#(3)";
//        String input = "1(2)23(3)";
        String bajj = "2110#(2)";
        String aabccc = "1(2)23(3)";
        String abzx = "1226#24#";
        String wwxyzwww = "23#(2)24#25#26#23#(3)";
        String jude = "2110#";
        List<String> input = new ArrayList<>();
//        input.add(abzx);
//        input.add(aabccc);
//        input.add(bajj);
//        input.add(wwxyzwww);
        input.add(bajj);

        for(String s : input) {
//            System.out.println(frequency(s));\
            frequency(s);
        }
    }

//    public static List<Integer> frequency(String input) {
//        List<Integer> result = new ArrayList<>(26);
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i = input.length() -1; i < 0; i--) {
//            char t = input.charAt(i);
//            int value = 1;
//            if(t == '#') {
//
//            }
//
//        }
//
//
//        return result;
//
//    }

    public static Map<Character, Integer> map = new HashMap<>();

    public static List<Integer> frequency(String input) {
        String text = messageBuilder(input).reverse().toString();
        int index = 0;
        while(index < text.length()) {
            char current = text.charAt(index);
            char next = index < text.length() - 1 ? text.charAt(index+1) : ' ';
            if(next == '(') {
                int closeIndex = text.indexOf(")", index);
                removeBracket(text.substring(index, closeIndex+1));
                index = closeIndex;
            } else {
                putMap(current, 1);
            }
            index++;
        }

        List<Integer> result = new ArrayList<>(26);
        for(int i = 97; i< 123; i++) {
            char key = (char) i;
            int value = 0;
            if(map.containsKey(key)) {
                value = map.get(key);
            }
            result.add(i - 97, value);
        }
        return result;
    }

    private static void removeBracket(String text) {
        int closeIndex = text.indexOf(")");
        char key = text.charAt(0);
        String value = text.substring(2, closeIndex);
        putMap(key, Integer.parseInt(value));
    }

    public static StringBuilder messageBuilder(String input) {
        int index = input.length() -1;
        StringBuilder builder = new StringBuilder();
        while(index >= 0) {
            char current = input.charAt(index);
            if(current == '#') {
                String group = input.substring(index - 2, index);
                builder.append((char) (Integer.parseInt(group) + 96));
                index = index - 3;
            } else {
                builder.append(current);
                index = index - 1;
            }
        }
        return builder;
    }


    private static void putMap(Character c, int count) {
        int value = 0;
        char key = c;
        if(!Character.isAlphabetic(c)) {
            key = (char) (Integer.parseInt("" + c) +96);
        }

        if(map.containsKey(key))
            value = map.get(key);

        map.put(key, value + count);
    }
}
