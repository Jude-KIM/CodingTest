package jude.codingtest.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstruction {

    /**
     * Suppose you have a random list of people standing in a queue.
     * Each person is described by a pair of integers (h, k),
     * where h is the height of the person and k is the number of people in front of this person
     * who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
     *
     * Note:
     * The number of people is less than 1,100.
     *
     * Example
     * Input:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     *
     * Output:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     *
     *
     * input:
     * [[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]]
     *
     * Output:
     * [[3,0],[6,0],[7,0],[5,2],[3,4],[5,3],[6,2],[2,7],[9,0],[1,9]]
     */







    public static void main(String[] args) {
        int[][] input = {
//                {9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}
                {0,0},{6,2},{5,5},{4,3},{5,2},{1,1},{6,0},{6,3},{7,0},{5,1}
        };

        System.out.println(reconstructQueue(input));


    }

    /**
     * height가 작은 사람의 순서는 전체 큐를 만들기 전에 예측이 불가하지만, height가 가장 큰 사람끼리의 순서는 정할수 있음
     * 1번 예제에서는 7이 가장 큰사람이므로 7끼리 순서는 미리 정할 수 있음 : [7,0] -> [7,1]
     * 이점에 착안해서 큐를 height가 큰 순서 + 같은 height인 경우는 count가 적은 순서로 정렬.
     *
     * 정렬된 큐에서 순서대로 사람을 꺼내서 list에 넣되, 그 사람의 count번째에 넣으면 끝.
     */
    public static int[][] reconstructQueue(int[][] queue) {
        Arrays.sort(queue, (a,b)->{return a[0]==b[0]?a[1]-b[1]:b[0]-a[0];});
        List<int[]> arr = new ArrayList<>();
        for(int i=0; i< queue.length; i++) {
            int[] people = queue[i];
            int count = people[1];
            arr.add(count, people);
        }
        for (int i=0; i<queue.length; i++) queue[i] = arr.get(i);
        return queue;
    }

    /**
     * 처음 큐를 height가 작은순 + count가 작은순으로 정렬.
     * 이렇게 하면 정렬된 리스트의 왼쪽에서부터 현재 pos보다 count가 작거나 같은 person을 넣으면됨
     * 그러나 엔제곱로그엔 이라서 상당히 느림
     *
     */
    private static int[][] solve2(int[][] queue) {
        Arrays.sort(queue, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0]){
                    return a[1]- b[1];
                }else{
                    return a[0]-b[0];
                }
            }
        });
        int[][] result = new int[queue.length][2];
        for(int i=0; i< queue.length; i++) {
            for(int j=0; j<queue.length; j++) {
                int height = queue[j][0];
                int count = queue[j][1];
                if(count <=i && count >= 0) {
                    if(i==0) {
                        result[i][0] = height;
                        result[i][1] = count;
                        queue[j][0] = -1;
                        queue[j][1] = -1;
                        break;
                    } else if(check(result, height, count, i)) {
                        result[i][0] = height;
                        result[i][1] = count;
                        queue[j][0] = -1;
                        queue[j][1] = -1;
                        break;
                    }
                }
            }
        }

        return result;
    }

    private static boolean check(int[][] result, int targetHeight, int targetCount, int end) {
        int cnt = 0;
        for(int i=0; i< end; i++) {
            int height = result[i][0];
            if(height >= targetHeight) {
                cnt++;
            }
        }

        return cnt == targetCount;
    }
}
