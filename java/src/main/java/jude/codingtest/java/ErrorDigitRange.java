package jude.codingtest.java;

import java.io.IOException;

public class ErrorDigitRange {

    public static void main(String[] args) throws IOException {
        int input = 909;
        System.out.println(findRange(input));
    }

    private static long findRange(int input) {
        String temp = Integer.toString(input);
        int[] max = new int[temp.length()];
        int[] min = new int[temp.length()];
        for(int i=0; i < temp.length(); i++) {
            max[i] = temp.charAt(i) - '0';
            min[i] = temp.charAt(i) - '0';

        }

        StringBuilder maxBuilder = new StringBuilder();
        StringBuilder minBuilder = new StringBuilder();
        //find max;
        int maxTarget = max[0];
        for(int i=0; i< max.length; i++) {
            int num = max[i];
            if(maxTarget == num) {
                if(num < 9) {
                    max[i] = 9;
                } else {
                    maxTarget = (i+1) < max.length ? max[i+1] : 0;
                }
            }
            maxBuilder.append(max[i]);
        }

        //find min;
        int minTarget;
        int number;
        int startIndex;
        if(min[0] == 1) {
//            2번째숫자와 같은 것을 전부 0으로 치환
            minTarget = min[1];
            startIndex = 1;
            number = 0;
            minBuilder.append(1);
        } else {
//            1번째숫자와 같은 것을 전부 1로 치환
            minTarget = min[0];
            startIndex = 0;
            number = 1;
        }

        for(int i = startIndex; i< min.length; i++) {
            int num = min[i];
            if(minTarget == num) {
                if(num > number) {
                    min[i] = number;
                } else {
                    minTarget = (i+1) < min.length ? min[i+1] : 0;
                }
            }
            minBuilder.append(min[i]);
        }

        return Integer.parseInt(maxBuilder.toString()) - Integer.parseInt(minBuilder.toString());
    }
}
