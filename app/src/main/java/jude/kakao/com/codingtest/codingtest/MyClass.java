package jude.kakao.com.codingtest.codingtest;

public class MyClass {

    public void Main() {

        StringBuilder builder = new StringBuilder("");
        for(int i=0; i< 2; i++) {
            builder.append("Y");
        }
        String allAttendance = builder.toString();

        String allData[] = {"YY", "NN", "YY", "YY", "NY", "YN", "YY", "YY", "YY"};

        int count=0;
        int max = 0;
        for(String date : allData) {
            max = count;
            if(date.equals(allAttendance)) {
                count++;
            } else{
                count = 0;
            }

            if(max > count)
                max = count;
        }

        System.out.println("jude test : " + max);
    }


}
