package jude.codingtest.java;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Sample Input
 *
 * Alex
 * Michael
 * Harry
 * Dave
 * Michael
 * Victor
 * Harry
 * Alex
 * Mary
 * Mary
 *
 *
 * Sample Output
 * Michael
 */
public class HackLandElection {


    public static void main(String[] args) throws IOException {

        String[] test = {"Alex",
                "Michael",
                "Harry",
                "Dave",
                "Michael",
                "Victor",
                "Harry",
                "Alex",
                "Mary",
                "Mary"};
        System.out.println(electionWinner(test));
    }


    static Map<Integer, String> vote = new HashMap<>();
    static String electionWinner(String[] votes) {
        Arrays.sort(votes);

        int count = 0;
        int max = 1;
        String candidate = votes[0];
        for(int i=0; i< votes.length; i++) {
            String name = votes[i];
            if(candidate.equals(name)) {
                count++;
                vote.put(count, name);
                candidate= name;
            } else {
                count = 1;
                vote.put(count, name);
                candidate= name;
            }

            if(count >= max) {
                max = count;
            }
        }

        return vote.get(max);
    }
}
