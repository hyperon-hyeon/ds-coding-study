package kingmingyu.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제2_BOJ20922_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int maxLeng = 1;
        int[] cnt = new int[100001];

        cnt[arr[0]]++;

        while(end < N){
            int next = end + 1;
            if(next >= N) break;
            if(cnt[arr[next]] < X){
                cnt[arr[next]]++;
                end = next;
                maxLeng = Math.max(maxLeng, end - start + 1);
            }
            else {
                while(cnt[arr[next]] >= X){
                    cnt[arr[start]]--;
                    start++;
                }
            }
        }

        System.out.println(maxLeng);
    }
}
