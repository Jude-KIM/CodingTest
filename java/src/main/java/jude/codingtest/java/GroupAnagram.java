package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.

 */
public class GroupAnagram {
    public static void main(String[] args) throws IOException {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            String word = strs[i];
            char[] sort = new char[word.length()];
            for(int j=0; j< word.length(); j++) {
                sort[j] = word.charAt(j);
            }
            Arrays.sort(sort);

            String key = String.copyValueOf(sort);
            if(map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(word);
                map.put(key, list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());

    }

}
