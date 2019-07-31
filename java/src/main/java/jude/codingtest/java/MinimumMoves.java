package jude.codingtest.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Andrea and Maria each have an array of integers. Andrea wants to change her array to match Maria's. For each element of her array, she can increment or decrement one digit in one item in one move. How many moves will it take Andrea to match Maria's array. No reordering of the digits is allowed.
 * For example, consider two arrays: Andrea's = [123, 543] and Maria's = [321, 279].
 * For the first integer, Andrea can increment the 1 twice to achieve 3. The 2's are equal already. Finally, she decrements her 3 twice to equal 1. It
 * took 4 moves to reach her goal.
 * For the second integer, she decrements 5 three times, increments 4 three times and 3 six times. It took 12 moves to convert the second array
 * element.
 * In total, it took 16 moves to convert both values comprising the complete array.
 * Function Description
 * Complete the function minimumMoves in the editor below. The function must return the integer number of moves to convert Andrea's array to match Maria's.
 * minimumMoves has the following parameter(s): a[a[0],...a[n-1]]: Andreas's array of integers m[m[0],...m[n-1]]: Maria's array of integers
 * Constraints
 * 1 ≤ n ≤ 105
 * 1 ≤ a[i], m[i] ≤ 109
 * The lengths of a and m are equal, |a| = |m|.
 * The elements a[i] and m[i] have an equal number of digits.
 * Input Format for Custom Testing
 * Input from stdin will be processed as follows and passed to the function.
 * The first line contains an integer n, the size of the array a.
 * The next n lines each contain an element a[i] where 0 ≤ i < n. The next line contains an integer n, the size of the array m. The next n lines each contain an element m[i] where 0 ≤ i < n.
 *
 */
public class MinimumMoves {

    public static void main (String[] args) throws java.lang.Exception
    {
        List<Integer> andrea = new ArrayList<>();
        List<Integer> maria = new ArrayList<>();
        andrea.add(1000000000);
        andrea.add(1000000000);
        maria.add(1234567890);
        maria.add(1876543210);
        System.out.println(minimumMoves(andrea, maria));
    }

    /* * * * * * *
     */
    public static int minimumMoves(List<Integer> andrea, List<Integer> maria) {
        // Write your code here
        int result = 0;
        for(int i=0; i< maria.size(); i++) {
            String tempa = String.valueOf(andrea.get(i));
            String tempb = String.valueOf(maria.get(i));
            for(int j=0; j < tempa.length(); j++) {
                int a = Integer.parseInt("" + tempa.charAt(j));
                int b = Integer.parseInt("" + tempb.charAt(j));
                result = result + Math.abs(a-b);
            }
        }

        return result;
    }
}
