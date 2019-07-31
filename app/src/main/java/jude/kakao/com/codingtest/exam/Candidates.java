package jude.kakao.com.codingtest.exam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import jude.kakao.com.codingtest.R;
import jude.kakao.com.codingtest.ToastUtils;

public class Candidates extends AppCompatActivity {

    TextView tvResult;
    String[][] relations = {{"100","ryan","music","2"},
                            {"200","apeach","math","2"},
                            {"300","tube","computer","3"},
                            {"400","con","computer","4"},
                            {"500","muzi","music","3"},
                            {"600","apeach","music","2"}};
    boolean[] isClear = new boolean[relations[0].length];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(relations == null)
            return;

        setContentView(R.layout.content);
        tvResult = findViewById(R.id.tv_content);

        //column 번호
        ArrayList<Integer> columns = new ArrayList<>();
        for(int i=0; i< relations[0].length; i++) {
            columns.add(i);
        }

        int[] finished = new int[relations[0].length];
        Arrays.fill(finished, 0);

        ToastUtils.alert(this, "candidate key", "" + dfs(columns, new ArrayList<Integer>(), 0, finished), true, null);
        Arrays.fill(isClear, false);
        int count = 0;
        for(int i=0; i< columns.size(); i++) {
//            count = count + jude(columns, new ArrayList<Integer>(), i, finished);
            if(!isClear[i])
                jude(columns, i);
        }


    }


    private int jude(ArrayList<Integer> columns, int start) {
        ArrayList<Integer> picked = new ArrayList<>(relations[0].length);

        //발견안된 column들
        ArrayList<Integer> temp = new ArrayList<>(relations[0].length);
        int count = 0;
        for (int i = start; i<columns.size(); i ++) {
            picked.add(columns.get(i));

            if(isUnique(picked)) {
                isClear[start] = true;
                count++;
                if(i == start) {
                    return 1;
                } else {
                    picked.remove(picked.size() - 1);
                }
            } else {
                temp.add(columns.get(i));
                if(isClear[start])
                    picked.remove(picked.size() - 1);
            }
        }

        if(isClear[start])
            return count;
        else
            return 0;
    }

    private int dfs(ArrayList<Integer> columns, ArrayList<Integer> picked, int start, int[] finished) {
        if(isUnique(picked)) return 1;
        int count = 0;

        for (int i = start; i < columns.size(); i++) {
            if(finished[i] == 0) {
                //pick
                finished[i] = 1;
                picked.add(columns.get(i));

                //search
                count = count + dfs(columns, picked, i+1, finished);

                //cancel
                finished[i] = 0;
                picked.remove(picked.size() -1 );
            }
        }

        return count;
    }

    private boolean isUnique(ArrayList<Integer> columns) {
        HashMap<String, Boolean> map = new HashMap<>();
        for ( int i=0; i< relations.length; i++) {
            StringBuilder builder = new StringBuilder();
            for(int j=0; j < columns.size(); j++) {
                builder.append(relations[i][columns.get(j)]);
            }

            String key = builder.toString();
            Log.e(i + " : ", key);
            if(map.containsKey(key) || StringUtils.isEmpty(key))
                return false;
            else
                map.put(key, true);
        }

        return true;
    }

    private void powerSet(int k) {
        if(k == relations.length) {

        } else {
            powerSet(k+1);
        }
    }
}
