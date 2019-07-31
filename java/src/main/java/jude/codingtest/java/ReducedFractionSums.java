package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Consider two fractions in the form a/b and c/d, where a, b, c, and d are integers. Given a string describing an arithmetic expression that sums these two fractions in the form a/b+c/d, compute the sum and fully reduce the resultant fraction to its simplest form.
 * For example:
 * The expression 1/2+1/6 evaluates to 4/6, which we reduce to the string 2/3.
 * The expression 7/10+13/10 evaluates to 20/10, which we reduce to the string 2/1.
 * Function Description
 * Complete the function reducedFractionSums in the editor below. The function must return an array of strings representing the fully reduced fractions.
 * reducedFractionSums has the following parameter(s): expressions[expressions[0],...expressions[n-1]]: an array of strings in the form a/b+c/d.
 * Constraints
 * 1 ≤ n ≤ 500
 * 1 ≤ a, b, c, d ≤ 2000
 * Input Format for Custom Testing Sample Case 0
 * Sample Input
 * 5
 * 722/148+360/176
 * 978/1212+183/183
 * 358/472+301/417
 * 780/309+684/988
 * 258/840+854/686
 *
 *
 * Sample Output
 * 2818/407
 * 365/202
 * 145679/98412
 * 4307/1339
 * 1521/980
 *
 * Explanation 0
 * We perform the following n = 5 calculations:
 * 0. 722/148+360/176 = 127072/26048+53280/26048 = 180352/26048 = 2818/407. 1. 978/1212+183/183 = 978/1212 + 1212/1212 = 2190/1212 = 365/202.
 * 2. 358/472+301/417evaluatestothereducedfraction145679/98412.
 * 3. 780/309+684/988 → 4307/1339.
 * 4. 258/840+854/686 → 1521/980.
 * Return the array ["2818/407", "365/202", "145679/98412", "4307/1339", "1521/980"] .

 */
public class ReducedFractionSums {

    public static void main(String[] args) throws IOException {

        String[] test = {"722/148+360/176",
                "978/1212+183/183",
                "358/472+301/417",
                "780/309+684/988",
                "258/840+854/686",};

        System.out.println(reducedFractionSums(Arrays.asList(test)));
    }

    public static List<String> reducedFractionSums(List<String> expressions) {
        // Write your code here
        List<String> result = new ArrayList<>(expressions.size());
        for(String s: expressions) {
            String[] token = s.split("\\+");
            String[] aToken = token[0].split("/");
            int aUp = Integer.parseInt(aToken[0]);
            int aDown = Integer.parseInt(aToken[1]);
            String[] bToken = token[1].split("/");
            int bUp = Integer.parseInt(bToken[0]);
            int bDown = Integer.parseInt(bToken[1]);

            int up, down;
            down = aDown * bDown;
            up = aUp * bDown + aDown * bUp;
            int gcd = gcd(up, down);

            String a,b;
            a = "" + up/gcd;
            b = "" + down/gcd;
            result.add(a + "/" + b);
        }

        return result;
    }

    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

}
