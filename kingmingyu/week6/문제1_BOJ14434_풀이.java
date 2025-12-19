package kingmingyu.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제1_BOJ14434_풀이 {

    static int N, M, K, Q;
    static int[] playMachine;
    static int[][] kid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫번째 줄 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 아이들의 수
        N = Integer.parseInt(st.nextToken());
        // 놀이기구의 수
        M = Integer.parseInt(st.nextToken());
        // 기간
        K = Integer.parseInt(st.nextToken());
        // 질문의 개수
        Q = Integer.parseInt(st.nextToken());

        //두번째 줄 입력받기
        // 놀이기구 키 제한 입력받기
        st = new StringTokenizer(br.readLine());
        playMachine = new int[M + 1];
        for(int i = 1; i <= M; i++){
            playMachine[i] = Integer.parseInt(st.nextToken());
        }

        //세번째 줄 입력받기
        // 아이들 키[아이][날짜]
        kid = new int[N + 1][K + 1];
        st = new StringTokenizer(br.readLine());
        for(int day = 1; day <= K; day++){
            int kidNum = Integer.parseInt(st.nextToken());
            kid[kidNum][day] += 1;
            for(int i = day; i <= K; i++){
                kid[kidNum][i] = kid[kidNum][day];
            }
        }


        //네번째 줄 입력받기
        // i + j >= k 입력받기
        int[][] tryPlay = new int[4][Q + 1];
        for(int i = 1; i <= Q; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++){
                tryPlay[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ans = new int[Q + 1];
        for(int i = 1; i <= Q; i++){
            int a = tryPlay[1][i]; //첫번째 아이
            int b = tryPlay[2][i]; //두번째 아이
            int ride = tryPlay[3][i];
            int limit = playMachine[ride]; //놀이기구 키제한

            int s = 1;
            int e = K;
            while(s <= e){
                int mid = (s + e) / 2;
                if(canRide(a, b, limit, mid)){
                    ans[i] = mid;
                    e -= 1;
                }
                else{
                    s = mid + 1;
                }
            }
        }
        // 정답 출력
        int[] counts = new int[K + 1];

        for (int day : ans) {
            if (day >= 1 && day <= K) {
                counts[day]++;
            }
        }

        int[] sum = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            sum[i] = sum[i - 1] + counts[i];
        }

        for (int i = 1; i <= K; i++) {
            System.out.println(sum[i]);
        }

    }

    public static boolean canRide(int a, int b, int limit, int day) {
        return kid[a][day] + kid[b][day] >= limit;
    }

}
