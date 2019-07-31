package jude.codingtest.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CardinalitySorting2 {

    public static void main (String[] args) throws java.lang.Exception {
        List<Integer> param = new ArrayList<>();
        param.add(1);
        param.add(2);
        param.add(3);
        param.add(4);
        param.add(5);
//        param.add(3);

        System.out.println(cardinalitySort(param));
    }

    public static List<Integer> cardinalitySort(List<Integer> nums) {
        // Write your code here

        List<Integer> result = new ArrayList<>(nums.size());
        List<Cardinal> items = new ArrayList<>(nums.size());
        for(int i=0; i< nums.size(); i++) {
            Cardinal cardinal = new Cardinal(nums.get(i));
            items.add(cardinal);
        }

        Collections.sort(items);
        for(int i=0; i< items.size();i++) {
            result.add(items.get(i).decimal);
        }

        return result;

    }

    public static class Cardinal implements Comparable<CardinalitySorting2.Cardinal> {

        int decimal;
        int carninality;
        String binary;

        public Cardinal(int decimal) {
            this.decimal = decimal;
            this.binary = Integer.toBinaryString(decimal);
        }

        public int getCarninality() {
            int cnt =0;
            for(int i=0; i< binary.length(); i++) {
                if(binary.charAt(i) == '1') {
                    cnt++;
                }
            }

            return cnt;
        }

        @Override
        public int compareTo(Cardinal cardinal) {
            if(this.getCarninality() == cardinal.getCarninality())
                return this.decimal - cardinal.decimal;
            else
                return this.getCarninality() - cardinal.getCarninality();
        }
    }
}
