package jude.codingtest.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * We define the binary cardinality of a number as the total number of 1's it contains in its binary representation. For example, the decimal integer
 *  (20)10 corresponds to the binary number (10100)2, so its binary cardinality is 2.
 * Given an array of decimal integers, we want to sort them by ascending binary cardinality. If two numbers have the same binary cardinality, the
 * smaller decimal number comes first. For example, let's say nums = [1, 2, 3, 4]. We evaluate each number as follows:
 * (1)10 → (1)2, so 1's binary cardinality is 1. (2)10 → (10)2, so 2's binary cardinality is 1. (3)10 → (11)2, so 3's binary cardinality is 2. (4)10 → (100)2, so 4's binary cardinality is 1.
 * When sorted first by ascending binary cardinality and then by ascending decimal value, numssorted = [1, 2, 4, 3]. Note that 1, 2, and 4 are in ascending decimal order because they all have a binary cardinality of 1, and 3 is ordered last because its binary cardinality is 2.
 * Function Description
 * Complete the function cardinalitySort in the editor below. The function must sort nums by ascending binary cardinality and return the array of sorted integers.
 * cardinalitySort has the following parameter(s): nums[nums[0],...nums[n-1]]: an array of integers
 * Constraints
 * 1 ≤ n ≤ 105
 * 1 ≤ nums[i] ≤ 106
 * Input Format for Custom Testing
 * Input from stdin will be processed as follows and passed to the function. The first line contains an integer n, the size of the array nums.
 * Each of the next n lines contains an integer nums[i].
 */
public class CardinalitySorting {

    public static void main (String[] args) throws java.lang.Exception
    {
        List<Integer> param = new ArrayList<>();
        param.add(4);
        param.add(8);
        param.add(1);
        param.add(2);
        param.add(6);
        param.add(3);

        List<Cardinal> items = cardinalitySort(param);
        List<Integer> temp = new ArrayList<>(items.size());
        for(int i=0; i < items.size(); i++ ) {
            temp.add(items.get(i).decimal);
        }
        System.out.println(temp);
    }

    public static List<Cardinal> cardinalitySort(List<Integer> nums) {
        // Write your code here
        List<Cardinal> result = new ArrayList<>();
        for(int i=0; i< nums.size(); i++) {
            int num = nums.get(i);
            Cardinal item = new Cardinal(num);
            result.add(item);
        }

        Collections.sort(result);
        return result;
    }

    public static class Cardinal implements Comparable<Cardinal> {

        int decimal;
        String binary;
        int count;
        public Cardinal(int decimal) {
            this.decimal = decimal;
            this.binary = Integer.toBinaryString(decimal);
            this.count = getCardinal();
        }

        public int getCardinal() {
            int cnt = 0;
            int i = 0;
            while(i < binary.length()) {
                i = binary.indexOf("1", i);
                if(i >= 0) {
                    cnt++;
                    i = i+1;
                } else break;
            }
            return cnt;
        }

        @Override
        public int compareTo(Cardinal cardinal) {
            if(this.count - cardinal.count > 0) {
                return 1;
            } else if(this.count == cardinal.count) {
                return this.decimal - cardinal.decimal;
            } else {
                return -1;
            }
        }
    }

}
