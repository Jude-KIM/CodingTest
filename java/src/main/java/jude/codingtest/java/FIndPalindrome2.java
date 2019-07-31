package jude.codingtest.java;

import java.io.IOException;

public class FIndPalindrome2 {

    public static void main(String[] args) throws IOException {
//        String test = "babad";
//        String test = "cbbd";

//                String test = "cbbbdabc";
//        String test = ""tattarrattat"";
        String test = "bb";
//        String test ="lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc";
        System.out.println(longestPalindrome(test));
    }

    public static String longestPalindrome(String s) {

        String test = "" + s.charAt(0);
        if(s.replace(test, "").length() == 0) {
            return test;
        }

        String palindrome ="";
        if(s == null || s.length() <2)
            return s;

        if(s.length() == 2) {
            if(s.charAt(0) == s.charAt(1))
                return s;
            else
                return s.charAt(0) + "";
        }

        for(int i=0; i < s.length() -1; i++) {
            String temp = findPalindrome(i, s, i-1, i+1);
//            if(isPalindromic(temp)) {
            if(temp.length() > palindrome.length())
                palindrome = temp;
//            }

        }
        return palindrome;
    }

    public static String findPalindrome(int i, String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        left++;
        right--;

        if(i != 0 && left == right) {
            char center = s.charAt(i);
            char l = s.charAt(i-1);
            char r = s.charAt(i+1);
            if(center == l) {
                return ""+center+l;
            } else if(center == r) {
                return ""+center+r;
            } else
                return "";
        }

        String temp = s.substring(left, right + 1);
        return temp;

    }

    private static boolean isPalindromic(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return s.equalsIgnoreCase(stringBuilder.reverse().toString());
    }
}
