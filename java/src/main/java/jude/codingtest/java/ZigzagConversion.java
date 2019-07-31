package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZigzagConversion {

    public static void main(String[] args) throws IOException {
        String s ="paypalishiring";
        int numRows = 3;
        System.out.print(convert(s, numRows));
    }

    private static String convert(String s, int numRows) {
        List<StringBuilder> temp = new ArrayList<>();

        for(int i = 0; i< numRows; i++) {
            temp.add(new StringBuilder());
        }

        boolean isDown = true;

        int row = 0;
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            temp.get(row).append(c);
            if (row == 0)
                isDown = true;
            else if (row == numRows - 1)
                isDown = false;

            row = isDown ? row + 1 : row - 1;
        }

        StringBuilder result = new StringBuilder(s.length());
        for(int i= 0; i< numRows; i++)
            result.append(temp.get(i));

        return result.toString();
    }


    /*
    private static String convert(String s, int numRows) {
        String result = "";

        List<Character> original = new ArrayList<>(s.length());
        for(int i=0; i<s.length(); i++){
            original.add(s.charAt(i));
        }

        int size = (numRows-1) * (s.length() / numRows);
        if(s.length() % numRows == 0)
            size++;


        int differ = numRows + numRows-2;

        List<Integer> temp = new ArrayList<>(s.length());
        for(int i=0; i< numRows; i++) {
            for(int j=0; j<size; j = j++) {
                int index = i+j*2;
                if(temp.contains(index)) {

                } else {
                    int lastIndex = temp.get(temp.size()-1);
                    if(index == lastIndex + differ)
                        temp.add(index);
                }

            }
        }


        for(int i=0; i < numRows; i++) {
            int multiple = i+2;
            if(temp.contains(i)) {

            } else {
                temp.add(i);
            }


        }


        for(int i=0; i< size; i++) {
            StringBuilder builder = new StringBuilder();
            if(i == 0)
                builder.append(s.charAt(i));
            else if((numRows-1) % i == 0)
                builder.append(s.charAt(i));
            else
                builder.append(" ");



            if(numRows % i == 0) {
                builder.append(s.charAt(i));
            }

        }



        return result;
    }
    */
}
