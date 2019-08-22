package jude.codingtest.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note:
     *
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     *
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     *
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     *              Note that you are allowed to reuse a dictionary word.
     * Example 3:
     *
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        String s = "cars";
//        list.add("car");
//        list.add("ca");
//        list.add("rs");

//        String s = "applepenapple";
//        list.add("pen");
//        list.add("apple");

//        String s = "catsandog";
//        list.add("cats");
//        list.add("dog");
//        list.add("sand");
//        list.add("and");
//        list.add("cat");


////        expect false
        String s = "cbca";
        list.add("bc");
        list.add("ca");


//        //expect true
//        String s = "abcd";
//        list.add("a");
//        list.add("abc");
//        list.add("b");
//        list.add("cd");


//        //expect true
//        String s = "ccaccc";
//        list.add("cc");
//        list.add("ac");
        System.out.println(wordBreak(s, list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return test(0, s, wordDict);
//        return breakable(s, wordDict, new HashSet<String>());
    }






    /*
    private static boolean breakable(String s, List<String> wordDict, Set<String> set){
        if (set.contains(s)) return false;
        if (s.isEmpty()) return true;

        for (String w: wordDict)
            if (s.startsWith(w))
                if (breakable(s.substring(w.length()), wordDict, set))
                    return true;
        set.add(s);
        return false;
    }
    */

//    String s = "cbca";
//        list.add("bc");
//        list.add("ca");

    public static boolean test(int index, String s, List<String> wordDict) {
        if(index >= wordDict.size())
            return false;
        String temp = s;
        while(temp.length() > 0 && index < wordDict.size()) {
            String word = wordDict.get(index);
            if(temp.startsWith(word)) {
                temp = temp.replaceAll(word,"");
                if (temp.length() == 0)
                    return true;
            } else {
                if(temp.contains(word)) {
                    index++;
                }
            }
        }

        return false;

/*
        for(int i = index; i<wordDict.size(); i ++) {
            String word = wordDict.get(i);
            if(temp.startsWith(word)) {
                temp = temp.replaceAll(word, "");
                if (temp.length() == 0) {
                    return true;
                }
            } else {
                if(temp.contains(word)) {

                }
                temp = temp.replaceAll(word, "");
            }

            if(s.contains(word) && !s.startsWith(word)) {
            } else {
                temp = temp.replaceAll(word, "");
                if (temp.length() == 0) {
                    return true;
                }
            }
        }
        return test(index+1, s, wordDict);
        */
    }

}
