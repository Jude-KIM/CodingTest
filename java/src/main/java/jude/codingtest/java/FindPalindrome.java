package jude.codingtest.java;

import java.io.IOException;

public class FindPalindrome {

    public static int count = 0;
    public static void main(String[] args) throws IOException {
//        String test = "babad";
//        String test = "cbbd";
//        String test = "abcdedcxccccccc";
//        String test ="lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc";
        String test ="aaabaaaa";
        System.out.println(longestPalindrome(test));
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.trim().length() == 0)
            return s;

        String test = "" + s.charAt(0);
        if(s.replace(test, "").length() == 0) {
            return s;
        }

        String palindrome ="";
        for(int i=0; i<s.length(); i++) {
            String temp = findPalindrome(""+s.charAt(i), s.substring(i));
            if(temp.length() > palindrome.length())
                palindrome = temp;
        }

        System.out.println("count : " + count);
        return palindrome;
    }

    private static String findPalindrome(String key, String s) {
        int index = s.indexOf(key, 1);
        String palindrome = key;
        while (index > -1) {
            String substring = s.substring(0, index+1);
            if(isPalindromic(substring)) {
                if(substring.length() > palindrome.length())
                    palindrome = substring;
            }
            index = s.indexOf(key, index+1);
            count++;
        }
        return palindrome;
    }

    private static boolean isPalindromic(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return s.equalsIgnoreCase(stringBuilder.reverse().toString());
    }
}
