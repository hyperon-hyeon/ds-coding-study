package kingmingyu.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제1_BOJ1780_풀이 {

    static int N;
    static int[][] paper;
    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dnc(N, 0, 0);
        for(int i = 0; i < 3; i++){
            System.out.println(answer[i]);
        }
    }
    public static void dnc(int n, int x, int y){
        //System.out.println("n: " + n + " x: " + x + " y: " + y);
        //System.out.println("-1answer: " + answer[0] + " 0answer: " + answer[1] + " 1answer: " +answer[2]);
        if(n == 1){
            //System.out.println("***************************");
            //System.out.println("end: " + paper[x][y]);
            answer[paper[x][y] + 1]++;
            return;
        }

        int target = paper[x][y];
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(paper[i][j] != target){
                    dnc(n/3, x, y);
                    dnc(n/3, (x + n/3), y);
                    dnc(n/3, (x + n/3 * 2), y);

                    dnc(n/3, x, (y + n/3));
                    dnc(n/3, (x + n/3), (y + n/3));
                    dnc(n/3, (x + n/3 * 2), (y + n/3));

                    dnc(n/3, x, (y + n/3 * 2));
                    dnc(n/3, (x + n/3), (y + n/3 * 2));
                    dnc(n/3, (x + n/3 * 2), (y + n/3 * 2));
                    return;
                }
            }
        }
        answer[target + 1]++;
    }
}
