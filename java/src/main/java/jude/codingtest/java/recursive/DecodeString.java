package jude.codingtest.java.recursive;

public class DecodeString {

    /**
     * Given an encoded string, return its decoded string.
     *
     * The encoding rule is: k[encoded_string],
     * where the encoded_string inside the square brackets
     * is being repeated exactly k times.
     * Note that k is guaranteed to be a positive integer.
     *
     * You may assume that the input string is always valid;
     * No extra white spaces, square brackets are well-formed, etc.
     *
     * Furthermore, you may assume that the original data does not contain
     * any digits and that digits are only for those repeat numbers, k.
     * For example, there won't be input like 3a or 2[4].
     *
     * Examples:
     *
     * s = "3[a]2[bc]", return "aaabcbc".
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */

    // open : 1, 5
    // close : 3, 8

    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
//        String s= "adgv2[abc]3[cd]ef";
//        String s= "3[a2[c]]";
        String s="100[k]";
        String anwser = decodeString(s);
        System.out.println(anwser + " ," + anwser.length());
    }


    /**
     * decode 안에 decode가 또 있는 경우가 있으므로 recursive하게 풀어야함.
     * 바깥의 괄호보다 안의 괄호를 먼저 붙여야 되는데 괄호의 카운터를 세어서 0이되면 파싱하게 하면됨
     * chatAt(i) == '[' 면 count++
     * charAt(i) == ']' 면 count--
     * 해서 0이되면 바깥 괄호 사이의 string을 recursive로 넘겨주면됨.
     *
     */
    public static String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                StringBuilder num = new StringBuilder();
                while(Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i));
                    i++;
                }

                int start = i+1;
                int count = 1;
                String token = "";
                while(count > 0) {
                    i++;
                    if(s.charAt(i) == '[')
                        count++;
                    if(s.charAt(i) == ']')
                        count--;
                }
                token = s.substring(start, i);
                String decoded = decodeString(token);
                builder.append(test(Integer.parseInt(num.toString()), decoded));
            } else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }

    private static String test(int num, String decoded) {
        StringBuilder builder = new StringBuilder(num);
        for(int i=0; i<num; i++) {
            builder.append(decoded);
        }
        return builder.toString();
    }
}
