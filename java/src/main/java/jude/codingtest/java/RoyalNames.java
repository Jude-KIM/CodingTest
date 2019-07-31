package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * soft list first alphabetically by name,
 * then by ordinal increasing within ay given name.
 *
 * input
 Louis IX
 Louis VIII

 * output
 Louis VIII
 Louis IX

 */
public class RoyalNames {

//    public static Map<String, Integer> map = new HashMap<>();
    public static List<RomanNumeral> map;
    public static void main(String[] args) throws IOException {

        String[] test = {
                "Elizabeth X",
                "Elizabeth XI",
                "Elizabeth XII",
                "Elizabeth XIII",
                "Elizabeth XIV",
                "Elizabeth XV",
                "Elizabeth XVI",
                "Elizabeth XVII",
                "Elizabeth XVIII",
                "Elizabeth XIX",
                "Elizabeth XX",
                "Elizabeth XXI",
                "Elizabeth XXII",
                "Elizabeth XXIII",
                "Elizabeth XXIV",
                "Elizabeth XXV",
                "Elizabeth XXVI",
                "Elizabeth XXVII",
                "Elizabeth XXVIII",
                "Elizabeth XXIX",

                "Elizabeth XXX",
                "Elizabeth XXXI",
                "Elizabeth XXXII",
                "Elizabeth XXXIII",
                "Elizabeth XXXIV",
                "Elizabeth XXXV",
                "Elizabeth XXXVI",
                "Elizabeth XXXVII",
                "Elizabeth XXXVIII",
                "Elizabeth XXXIX",

                "Elizabeth XL",
                "Elizabeth XLI",
                "Elizabeth XLII",
                "Elizabeth XLIII",
                "Elizabeth XLIV",
                "Elizabeth XLV",
                "Elizabeth XLVI",
                "Elizabeth XLVII",
                "Elizabeth XLVIII",
                "Elizabeth XLIX",

                "Elizabeth L",
                "Elizabeth LI",
                "Elizabeth LII",
                "Elizabeth LIII",
                "Elizabeth LIV",
                "Elizabeth LV",
                "Elizabeth LVI",
                "Elizabeth LVII",
                "Elizabeth LVIII",
                "Elizabeth LIX",

                "Adward I",
                "Adward II",
                "Adward III",
                "Adward IV",
                "Adward V",
                "Adward VI",
                "Adward VII",
                "Adward VIII",
                "Adward IX",




//                "William II",
//                "Elizabeth XL",
//                "Elizabeth XLVII",
//                "Elizabeth VII",
//                "William I",
//                "Elizabeth X",
//                "Elizabeth L",
//                "Louis IX",
//                "Louis VIII",
//
//                "William XLVII",
//                "William LVI",
//                "Elizabeth XXXV",
//                "Elizabeth XXIX"
        };
        System.out.println(getSortedList(Arrays.asList(test)));
    }
    static List<String> getSortedList(List<String> names) {
        buildMap();
        List<String> result = new ArrayList<>(names.size());
        List<King> kings = new ArrayList<>(names.size());
        for(String name : names) {
            kings.add(new King(name));
        }
        Collections.sort(kings);
        for(King king : kings) {
            result.add(king.full);
        }

        return result;
    }

    private static void buildMap() {
        map = new ArrayList<>(14);
        map.add(RomanNumeral.I);
        map.add(RomanNumeral.II);
        map.add(RomanNumeral.III);
        map.add(RomanNumeral.IV);
        map.add(RomanNumeral.V);
        map.add(RomanNumeral.VI);
        map.add(RomanNumeral.VII);
        map.add(RomanNumeral.VIII);
        map.add(RomanNumeral.IX);
        map.add(RomanNumeral.X);
        map.add(RomanNumeral.XX);
        map.add(RomanNumeral.XXX);
        map.add(RomanNumeral.XL);
        map.add(RomanNumeral.L);
        Collections.reverse(map);
    }

    public enum RomanNumeral {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XX(20), XXX(30), XL(40), L(50);

        private int value;
        RomanNumeral(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return this.name();
        }
    }

    public static class King implements Comparable<King> {

        String full;
        String name;
        String number;
        public King(String name) {
            this.full = name;
            init();
        }

        private int first, second;
        private void init() {
            String[] subString = full.split(" ");
            name = subString[0];
            for(RomanNumeral numeral : map) {
                String temp = subString[1];
                if(temp.equals(numeral.getName())) {
                    number = "" + numeral.getValue();
                    break;
                } else if(temp.startsWith(numeral.getName())) {
                    first = numeral.getValue();
                    int start = numeral.getName().length();
                    int end = temp.length();
                    String test = temp.substring(start, end);
                    for(int i = 0; i <  map.size(); i++) {
                        if (map.get(i).getName().equals(test)) {
                            second = map.get(i).getValue();
                            break;
                        }
                    }

                    number = String.valueOf(first+second);
                    break;
                }
            }
        }

        @Override
        public int compareTo(King king) {
            if(name.equals(king.name)) {
                return Integer.parseInt(number) - Integer.parseInt(king.number);
            }
            return name.compareTo(king.name);
        }
    }
}
