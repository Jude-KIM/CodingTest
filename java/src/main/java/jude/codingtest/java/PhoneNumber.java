package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class PhoneNumber {
    public static void main(String[] args) throws IOException {
        String input = "23";
        System.out.println(letterCombinations(input));
    }

    public static List<String> output = new ArrayList<>();
    public static Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public static List<String> letterCombinations(String digits) {
        output = new ArrayList<>();
        if(digits.length() > 0)
            combine("", digits);
        return output;
    }

    public static void combine(String combination, String input) {
        if (input.length() == 0) {
            output.add(combination);
        } else {
            Character digit = input.charAt(0);
            String mapping = map.get(digit);
            for(int i=0; i< mapping.length(); i++) {
                Character letter = mapping.charAt(i);
                combine(combination + letter, input.substring(1));
            }
        }
    }
}
