package kingmingyu.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 문제1_BOJ1931_풀이 {

    static int[][] room;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt (br.readLine ());

        room = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer (br.readLine ());
            room[i][0] = Integer.parseInt (st.nextToken ());
            room[i][1] = Integer.parseInt (st.nextToken ());
        }

        Arrays.sort (room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int cur_end_time = 0;

        for(int i = 0; i < n; i++){
            if(cur_end_time <= room[i][0]){
                cur_end_time = room[i][1];
                count++;
            }
        }
        System.out.println (count);
    }
}
