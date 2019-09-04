package jude.codingtest.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImplementTrie
{

    /**
     * Implement a trie with insert, search, and startsWith methods.
     *
     * Example:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // returns true
     * trie.search("app");     // returns false
     * trie.startsWith("app"); // returns true
     * trie.insert("app");
     * trie.search("app");     // returns true
     * Note:
     *
     * You may assume that all inputs are consist of lowercase letters a-z.
     * All inputs are guaranteed to be non-empty strings.
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
     System.out.println(trie.search("apple"));   // returns true
     System.out.println(trie.search("app"));     // returns false
     System.out.println(trie.startsWith("app")); // returns true
     trie.insert("app");
     System.out.println(trie.search("app"));   // returns true;

    }


    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    static class Trie {

        Map<String, Boolean> map = new HashMap<>();
        Map<String, Boolean> map2 = new HashMap<>();
        public Trie() {
            map  = new HashMap<>();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if(map.containsKey(word)) {
                //do nothing;
            } else {
                map.put(word, true);
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return map.containsKey(word);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if(map.containsKey(prefix))
                return true;



            for(String word : map.keySet()) {
                if(word.startsWith(prefix))
                    return true;
            }

            return false;
        }
    }
}
