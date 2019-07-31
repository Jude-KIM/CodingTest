package jude.codingtest.java;

/**
 *We use different compression techniques in order to reduce the size of the messages sent over the web. An algorithm is designed to compress a given string by describing the total number of consecutive occurrences of each character next to it. For example consider the string "alaasass", we can group the consecutive occurrence of each character:
 * 'a' occurs one time.
 * 'l' occurs one time.
 * 'a' occurs two times consecutively. 's' occurs one time.
 * 'a' occurs one time.
 * 's' occurs two times consecutively.
 * If a character only occurs once, it is added to the compressed string. If it occurs consecutive times, the character is added to the string followed by an integer representing the number of consecutive occurrences. Thus the compressed form of the string is "ala2sas2".
 * Function Description
 * Complete the function compressedString in the editor below. The function must return the compressed form of message. compressedString has the following parameter(s):
 * message: a string
 * Constraints
 * message[i] ascii[a-z] |message| ≤ 105
 *
 *
 * Sample Input 1
 * abaabbbc
 * Sample Output 1
 * aba2b3c
 * Explanation 1
 * If we group the consecutive occurrences of each character, we get "{a}{b}{aa}{bbb}{c}", in compressed form, "aba2b3c". YOUR ANSWER
 *
 */
public class Compression {

    public static void main (String[] args) throws java.lang.Exception
    {
        String input = "abaabbbc";

        System.out.println(compressedString(input));
    }

    public static StringBuilder builder = new StringBuilder();
    public static String compressedString(String message) {
        // Write your code here

        int count = 1;
        for(int i=0; i<message.length() -1; i++) {
            char cur = message.charAt(i);
            char next = message.charAt(i+1);
            if(cur == next) {
                count++;
            } else {
                add(cur, builder, count);
                count = 1;
            }

            if(i + 1  == message.length() -1) {
                if(cur == next)
                    add(next, builder, count);
                else
                    add(next, builder, 1);
            }

        }

        return builder.toString();
    }

    private static void add(char prev, StringBuilder builder, int count) {
        builder.append(prev);
        if(count > 1) {
            builder.append(count);
        }
    }
}
