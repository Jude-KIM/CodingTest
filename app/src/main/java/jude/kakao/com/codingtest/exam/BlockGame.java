package jude.kakao.com.codingtest.exam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jude.kakao.com.codingtest.ToastUtils;

public class BlockGame extends AppCompatActivity {

//    int[][] relations = {   {0,0,0,0,0,0,0,0,0,0},
//                            {0,0,0,0,0,0,0,0,0,0},
//                            {0,0,0,0,0,0,0,0,0,0},
//                            {0,0,0,0,0,0,0,0,0,0},
//                            {0,0,0,0,0,4,4,0,0,0},
//                            {0,0,0,0,0,0,4,0,0,0},
//                            {0,0,0,0,3,4,4,0,0,0},
//                            {0,0,0,2,3,0,0,0,5,5},
//                            {1,2,2,2,3,3,0,0,0,5},
//                            {1,1,1,0,0,0,0,0,0,5}};

    int[][] relations = {   {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,4,0,0,0},
                            {0,0,0,0,0,0,4,0,0,0},
                            {0,0,0,0,3,4,4,6,0,0},
                            {1,1,0,2,3,0,0,6,0,5},
                            {1,2,2,2,3,3,0,6,6,5},
                            {1,1,1,0,0,0,0,0,5,5}};

    int max_blocks = (relations.length*relations.length)/4;
    Set<Integer> blocks = new HashSet<>(max_blocks);
    Set<Integer> failure = new HashSet<>(max_blocks);
    Set<Integer> test = new HashSet<>(max_blocks);


    Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
    Map<Pair<Integer, Integer>, Integer> map2 = new HashMap<>();

    int[][] board;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        for(int i=0; i< relations.length; i++) {
            for(int j=0; j< relations[0].length; j++) {
                int value = relations[i][j];
                if(value == 0) {


//                    failure.remove(0);
                } else {
                    if(!blocks.contains(value))
                        blocks.add(value);
                }

                if(value > 0) {
                    if(!blocks.contains(value))
                        blocks.add(value);
                }

                int[] matrix = getMatrix(i, j);
                if(matrix[1] > 0) {
                    if(matrix[1] == matrix[6])
                        if(matrix[1] != value)
                            failure.add(matrix[1]);
                    else if(matrix[6] > 0) {
                        if(failure.contains(matrix[1]) || failure.contains(value))
                            failure.add(matrix[6]);
                    } else if(matrix[6] == 0) {
                        if(matrix[3] == matrix[1] || matrix[4] == matrix[1]) {
                            failure.add(matrix[1]);
                        }
                    }
                }

                if(matrix[3] > 0 && matrix[5] > 0) {
                    if(matrix[3] != matrix[5] && failure.contains(matrix[3]))
                        failure.add(matrix[5]);
                }

                if (matrix[4] > 0 && matrix[7] > 0) {
                    if (matrix[4] != matrix[7] && failure.contains(matrix[4]))
                        failure.add(matrix[7]);
                }


//                if(value == 0) {
//                    if(vector[1] > 0 && vector[6] >0) {
//                        if(vector[1] == vector[6]) {
//                            failure.add(vector[1]);
//                        } else if(failure.contains(vector[1])) {
//                            failure.add(vector[6]);
//                        }
//                    } else if(vector[1] > 0) {
//                        if(vector[1] == vector[3] || vector[1] == vector[4]) {
//                            failure.add(vector[1]);
//                        }
//                    }
//                }
            }
        }

        Log.e("blocks : ", blocks.toString());
        Log.e("fail : ", failure.toString());


        ToastUtils.show(this, "result : " + (blocks.size() - failure.size()), ToastUtils.LENGTH_SHORT);
    }

    private int[] getMatrix(int i, int j) {
        int[] matrix = new int[8];
        if(i == 0) {
            if(j == 0) {
                matrix[0] = -1;
                matrix[1] = -1;//up
                matrix[2] = -1;
                matrix[3] = -1;//left
                matrix[4] = relations[i][j+1];//right
                matrix[5] = -1;
                matrix[6] = relations[i+1][j];//down
                matrix[7] = relations[i+1][j+1];
            } else if(j == relations[0].length-1) {
                matrix[0] = -1;
                matrix[1] = -1;//up
                matrix[2] = -1;
                matrix[3] = relations[i][j-1];//left
                matrix[4] = -1;//right
                matrix[5] = relations[i+1][j-1];
                matrix[6] = relations[i+1][j];//down
                matrix[7] = -1;
            } else {
                matrix[0] = -1;
                matrix[1] = -1;//up
                matrix[2] = -1;
                matrix[3] = relations[i][j-1];//left
                matrix[4] = relations[i][j+1];//right
                matrix[5] = relations[i+1][j-1];
                matrix[6] = relations[i+1][j];//down
                matrix[7] = relations[i+1][j+1];
            }
        } else if(i == relations.length -1) {
            if(j == 0) {
                matrix[0] = -1;
                matrix[1] = relations[i-1][j];//up
                matrix[2] = relations[i-1][j+1];
                matrix[3] = -1;//left
                matrix[4] = relations[i][j+1];//right
                matrix[5] = -1;
                matrix[6] = -1;//down
                matrix[7] = -1;
            } else if (j == relations[0].length -1) {
                matrix[0] = relations[i-1][j-1];
                matrix[1] = relations[i-1][j];//up
                matrix[2] = -1;
                matrix[3] = relations[i][j-1];//left
                matrix[4] = -1;
                matrix[5] = -1;
                matrix[6] = -1;//down
                matrix[7] = -1;
            } else {
                matrix[0] = relations[i-1][j-1];
                matrix[1] = relations[i-1][j];//up
                matrix[2] = relations[i-1][j+1];
                matrix[3] = relations[i][j-1];//left
                matrix[4] = relations[i][j+1];//right
                matrix[5] = -1;
                matrix[6] = -1;//down
                matrix[7] = -1;
            }
        } else {
            if(j == 0) {
                matrix[0] = -1;
                matrix[1] = relations[i-1][j];//up
                matrix[2] = relations[i-1][j+1];
                matrix[3] = -1;//left
                matrix[4] = relations[i][j+1];//right
                matrix[5] = -1;
                matrix[6] = relations[i+1][j];//down
                matrix[7] = relations[i+1][j+1];
            } else if (j == relations[0].length -1) {
                matrix[0] = relations[i-1][j-1];
                matrix[1] = relations[i-1][j];//up
                matrix[2] = -1;
                matrix[3] = relations[i][j-1];//left
                matrix[4] = -1;//right
                matrix[5] = relations[i+1][j-1];
                matrix[6] = relations[i+1][j];//down
                matrix[7] = -1;
            } else {
                matrix[0] = relations[i-1][j-1];
                matrix[1] = relations[i-1][j];//up
                matrix[2] = relations[i-1][j+1];
                matrix[3] = relations[i][j-1];//left
                matrix[4] = relations[i][j+1];//right
                matrix[5] = relations[i+1][j-1];
                matrix[6] = relations[i+1][j];//down
                matrix[7] = relations[i+1][j+1];
            }
        }

        return matrix;
    }

    private void buildMap(int[][] relations) {
        for(int i =0; i<relations.length; i++) {
            for (int j = 0; j < relations[0].length; j++) {
                int value = relations[i][j];
                board[i][j] = value;
                map2.put(Pair.create(i, j), value);
            }
        }
        Log.e("jude", "map : " + map2.toString());
    }

    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        Set<T> keys = new HashSet<T>();
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}
