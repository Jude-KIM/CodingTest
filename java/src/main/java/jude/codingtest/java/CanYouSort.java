package jude.codingtest.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanYouSort {

    public static void main (String[] args) throws java.lang.Exception
    {
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(1);
        input.add(2);
        input.add(2);
        input.add(4);

        customSort(input);
    }

    public static void customSort(List<Integer> arr) {
        // Write your code here

        Map<Integer, Integer> map = new HashMap<>();
        for(int key : arr) {
            if(map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value +1);
            } else {
                map.put(key, 1);
            }
        }

        List<Item> items = new ArrayList<>();
        for(int key : map.keySet()) {
            items.add(new Item(key, map.get(key)));
        }
        Collections.sort(items);
        StringBuilder builder = new StringBuilder();
        for(Item item : items) {
            builder.append(item.getString());
        }
        System.out.println(builder.toString());
    }

    public static class Item implements Comparable<CanYouSort.Item> {

        int number, count;
        String s;
        public Item(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public String getString() {
            StringBuilder builder = new StringBuilder();
            for(int i=0 ; i< count; i++) {
                builder.append(number);
                builder.append("\n");
            }

            return builder.toString();
        }

        @Override
        public int compareTo(Item item) {
            if(this.count == item.count) {
                return this.number - item.number;
            }

            return this.count - item.count;
        }
    }
}
