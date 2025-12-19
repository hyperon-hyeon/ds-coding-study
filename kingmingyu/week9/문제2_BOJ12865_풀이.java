package kingmingyu.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제2_BOJ12865_풀이 {

    public static int[] WArr;
    public static int[] VArr;
    public static Integer[][] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        WArr = new int[N];
        VArr = new int[N];
        answer = new Integer[N][K + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            WArr[i] = Integer.parseInt(st.nextToken());
            VArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N - 1, K));
    }

    public static int knapsack(int i, int k){
        // 더 이상 물건이 존재 하지 않는 경우
        if(i < 0){
            return 0;
        }

        // 메모이제이션 이용 (이미 계산된 값이라면 그대로 반환)
        if(answer[i][k] != null){
            return answer[i][k];
        }

        //물건이 남은 배낭의 무게보다 무거운 경우
        if(WArr[i] > k){
            answer[i][k] = knapsack(i-1, k);
        }

        else{
            answer[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-WArr[i]) + VArr[i]);
        }
        return answer[i][k];
    }
}