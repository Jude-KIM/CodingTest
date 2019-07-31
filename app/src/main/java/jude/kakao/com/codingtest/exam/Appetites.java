package jude.kakao.com.codingtest.exam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jude.kakao.com.codingtest.R;

public class Appetites extends AppCompatActivity {

    final private int[] apetites = {1000000001, 1000000010, 1000000005, 1000000004, 1000000005, 1000000002, 1000000008, 1000000003, 1000000015};
    final private int k = 3;
    private TextView tvResult;
    private StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        tvResult = findViewById(R.id.tv_content);
        List<Integer> result= new ArrayList<>(apetites.length);

        int[] temp = apetites.clone();
        Arrays.sort(temp);

        for(int i=0; i< apetites.length; i++) {
//            result.add(getBound(apetites[i], i));
            int lower = lowerBound(temp, apetites[i] - 3);
            int upper = upperBound(temp,apetites[i] + 3);
            result.add(upper-lower-1);
        }
        System.out.println(result.toString());

        tvResult.setText(result.toString());
    }

    private int getBound(int target, int pos) {
        int count = 0;
        for(int i=0; i< apetites.length; i++) {
            if(i == pos)
                continue;

            int apetite = apetites[i];
            if(target-k <= apetite && target+k >= apetite) {
                count++;
            }
        }
        return count;
    }


    private int lowerBound(int[] temp, int target) {
        int start = 0;
        int end = temp.length;
        while(end > start) {
            int mid = (start + end) / 2;

            if (target <= temp[mid])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    private int upperBound(int[] temp, int target) {
        int start = 0;
        int end = temp.length;
        while(end > start) {
            int mid = (start+end) / 2;

            if(target >= temp[mid])
                start = mid +1;
            else
                end = mid;
        }
        return start;
    }

}
