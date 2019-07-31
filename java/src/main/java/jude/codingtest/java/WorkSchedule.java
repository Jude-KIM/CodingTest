package jude.codingtest.java;

import java.util.ArrayList;
import java.util.List;

/**
 * QUESTION DESCRIPTION
 *
 * You just got a new job where you have to work exactly as many hours as you are told each week, working no more than a daily maximum number of hours per day. Some of the days, they tell you how many hours you will work. You get to choose the remainder of your schedule, within the limits.
 * A completed schedule consists of exactly 7 digits in the range 0 to 8 representing each day's hours to be worked.
 * You will get a pattern string similar to the schedule, but with some of the digits replaced by a question mark, ?, (ascii 63 decimal).
 * Given a maximum number of hours you can work in a day, replace the question marks with digits so that the sum of the scheduled hours is exactly the hours you must work in a week.
 * Return a string array with all possible schedules you can create, ordered lexicographically.
 *
 * For example, your partial schedule, pattern = 08??840, your required hours, work_hours = 24, and you can only work, at most, day_hours = 4 hours per day during the two days in question. You have two days on which you must work 24 - 20 = 4 more hours for the week. All of your possible schedules are listed below:
 * 0804840 0813840 0822840 0831840 0840840
 * Function Description
 * Complete the function findSchedules in the editor below. The function must return an array of strings that represents all possible valid schedules. The strings must be ordered lexicographically.
 * findSchedules has the following parameter(s):
 * work_hours: an integer that represents the hours you must work in the week day_hours: an integer that represents the maximum hours you may work in a day pattern: a string that represents the partially completed schedule
 * Constraints
 * 1 ≤ work_hours ≤ 56
 * 1 ≤ day_hours ≤ 8
 * | pattern | = 7
 * Each character of pattern ∈ {0, 1,...,8} There is at least one correct schedule.
 */
public class WorkSchedule {

    public static void main (String[] args) throws java.lang.Exception
    {
        List<String> schedules = new ArrayList<>();
        final String pattern = "08??840";
        planSchdules(schedules, 24, 4, pattern);
        System.out.println(schedules);

//        int numOfDay = getNumOfSet(pattern);
//        if(workHours - sum == 0) {
//            System.out.println(getSchedule(numOfDay, sum));
//        }


    }

    public static void planSchdules(List<String> schedules, int workHours, int dayHours, String pattern) {
        int sum = getSum(pattern);
        int index = getIndex(pattern);
        if(index == -1) {
            if(workHours == sum)
                schedules.add(pattern);
            return;
        }

        if(sum > workHours) return;
        for(int i=0; i<=dayHours; i++) {
            planSchdules(schedules, workHours, dayHours, getPattern(pattern, index, i));
        }
    }

    private static int getIndex(String pattern) {
        for(int i=0; i< pattern.length(); i++) {
            if(pattern.charAt(i) == '?')
                return i;
        }

        return -1;
    }

    private static int getSum(String pattern) {
        int count = 0;
        for(int i=0; i< pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(c == '?') continue;
            count = count + Character.getNumericValue(c);
        }
        return count;
    }


    public static String getPattern(String original, int index, int hours) {
        return original.substring(0, index) + hours + original.substring(index+1);

    }

}
