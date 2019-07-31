package jude.codingtest.java;

/**
 *
 */



import java.util.Scanner;


public class LargeResponses {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        String[] input = {
                "unicomp6.unicomp.net - - [01/Jul/1995:00:00:06 -0400] GET /shuttle/countdown/ HTTP/1.0 200 3985",
                "burger.letters.com - - [01/Jul/1995:00:00:11 -0400] \"GET /shuttle/countdown/liftoff.html HTTP/1.0\" 304 0",
                "burger.letters.com - - [01/Jul/1995:00:00:12 -0400] \"GET /images/NASA-logosmall.gif HTTP/1.0\" 304 0",
                "burger.letters.com - - [01/Jul/1995:00:00:12 -0400] \"GET /shuttle/countdown/video/livevideo.gif HTTP/1.0\" 200 0",
                "d104.aa.net - - [01/Jul/1995:00:00:13 -0400] \"GET /shuttle/countdown/ HTTP/1.0\" 200 3985",
                "unicomp6.unicomp.net - - [01/Jul/1995:00:00:14 -0400] \"GET /shuttle/countdown/count.gif HTTP/1.0\" 200 40310",
                "unicomp6.unicomp.net - - [01/Jul/1995:00:00:14 -0400] \"GET /images/NASA-logosmall.gif HTTP/1.0\" 200 786",
                "unicomp6.unicomp.net - - [01/Jul/1995:00:00:14 -0400] \"GET /images/KSC-logosmall.gif HTTP/1.0\" 200 1204",
                "d104.aa.net - - [01/Jul/1995:00:00:15 -0400] \"GET /shuttle/countdown/count.gif HTTP/1.0\" 200 40310",
                "d104.aa.net - - [01/Jul/1995:00:00:15 -0400] \"GET /images/NASA-logosmall.gif HTTP/1.0\" 200 786"
        };

        // read the string filename
//        String filename;
//        filename = scan.nextLine();

        int sum = 0;
        int count= 0;
        for(String s : input) {
            String[] subStrings = s.split(" ");
            int bytes = Integer.parseInt(subStrings[subStrings.length-1]);
            if( bytes > 5000) {
                count++;
                sum = sum + bytes;
            }

        }


        System.out.println(count);
        System.out.println(sum);
    }
}
