package kingmingyu.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제1_BOJ21921_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visit = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            visit[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        // 새로운 윈도우 생성
        for(int i = 0; i < X; i++){
            sum += visit[i];
        }

        int answer = sum;
        int count = 1;
        // 윈도우 이동 + count, answer 갱신
        for(int i = X; i < N; i++){
            sum = sum - visit[i - X] + visit[i];
            if(sum > answer){
                count = 1;
                answer = sum;
            }
            else if(answer == sum){
                count ++;
            }
            //System.out.println("i: " + i + " answer: " + answer + "count: " + count);
        }

        //정답 출력
        if(answer == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(answer);
            System.out.println(count);
        }
    }
}
