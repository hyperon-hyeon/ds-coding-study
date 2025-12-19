package kingmingyu.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제1_BOJ1182_풀이 {
    static int[] arr;
    static int n;
    static int s;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if(s == 0) cnt--; // 공집합 제외
        System.out.print(cnt);
    }

    public static void dfs(int d, int sum){
        if(d == n){
            if(sum == s){
                cnt++;
            }
            return;
        }

        //현재 원소를 선택하는 경우
        dfs(d + 1, sum + arr[d]);
        //현재 원소를 선택하지 않는 경우
        dfs(d + 1, sum);
    }
}
