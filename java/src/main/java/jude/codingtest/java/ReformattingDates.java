package jude.codingtest.java;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *input
 * 20th Oct 2052
 * 6th Jun 1933
 * 26th May 1960
 * 20th Sep 1958
 * 16th Mar 2068
 * 25th May 1912
 * 16th Dec 2018
 * 26th Dec 2061
 * 4th Nov 2030
 * 28th Jul 1963
 *
 * output
 2052-10-20
 1933-06-06
 1960-05-26
 1958-09-20
 2068-03-16
 1912-05-25
 2018-12-16
 2061-12-26
 2030-11-04

 Explanation
 20th Oct 2052 → 2052-10-20
 6th Jun 1933 → 1933-06-06
 26th May 1960 → 1960-05-26
 20th Sep 1958 → 1958-09-20
 16th Mar 2068 → 2068-03-16
 25th May 1912 → 1912-05-25
 16th Dec 2018 → 2018-12-16
 26th Dec 2061 → 2061-12-26
 4th Nov 2030 → 2030-11-04
 28th Jul 1963 → 1963-07-28
 We then return the array ["2052-10-20", "1933-06-06", "1960-05-26", "1958-09-20", "2068-03-16", "1912-05-25", "2018-12-16", "2061-12-26", "2030-11-04", "1963-07-28"] as our answer.
 */
public class ReformattingDates {

    public static void main(String[] args) throws IOException {

        String[] test = {"20th Oct 2052",
                "6th Jun 1933",
                "26th May 1960",
                "20th Sep 1958",
                "16th Mar 2068",
                "25th May 1912",
                "16th Dec 2018",
                "26th Dec 2061",
                "4th Nov 2030",
                "28th Jul 1963"};
        System.out.println(reformatDate(Arrays.asList(test)));
    }



    public static List<String> reformatDate(List<String> dates) {
        // Write your code here
        List<String> result = new ArrayList<>(dates.size());
        for(String date : dates) {
            String[] subStrings = date.split(" ");
            String day = getDay(subStrings[0]);
            String month = getMonth(subStrings[1].toUpperCase());
            String year = subStrings[2];
            result.add(year+"-"+month+"-"+day);
        }

        return result;
    }

    public static String getDay(String dayString) {
        String day;
        if(dayString.length() == 4) {
            day = dayString.substring(0, 2);
        } else {
            day = "0" + dayString.substring(0, 1);
        }

        return day;
    }

    public static String getMonth(String monthString) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(monthString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        String result = "" + month;
        if(result.length() == 1)
            result = "0" + result;
        return result;
    }

}
