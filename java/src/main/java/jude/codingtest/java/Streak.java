package jude.codingtest.java;

public class Streak {
    public static void main (String[] args) throws java.lang.Exception
    {
        StringBuilder builder = new StringBuilder("");
        for(int i=0; i< 2; i++) {
            builder.append("Y");
        }
        String allAttendance = builder.toString();

        String allData[] = {"YY", "NY", "YY", "YY", "YY", "YY", "YY", "YY", "YY"};

        int count=0;
        int max = 0;
        for (String today : allData) {
            if (today.equals(allAttendance)) {
                count++;
            } else {
                count = 0;
            }

            if (max < count)
                max = count;

        }

        System.out.println("jude test : " + max);
    }
}
