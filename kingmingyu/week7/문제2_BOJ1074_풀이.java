package kingmingyu.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제2_BOJ1074_풀이 {

    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.print(dnc(N, c, r));
    }

    public static int dnc(int N, int x, int y){
        if(N == 1){
            //System.out.println("종료" + x + y);
            if(x == 1 && y == 1){
                cnt += 3;
                return cnt;
            }
            cnt = cnt + x + 2*y;
            return cnt;
        }

        //제 1사분면
        if(x < Math.pow(2, N-1) && y < Math.pow(2, N-1)){
            dnc(N -1, x, y);
            //System.out.println("1: "+ cnt);
        }

        //제 2사분면
        else if(x >= Math.pow(2, N-1) && y < Math.pow(2, N-1)){
            cnt += Math.pow(Math.pow(2, N-1), 2);
            x -= Math.pow(2, N-1);
            //System.out.println("2: "+ cnt);
            dnc(N-1, x, y);
        }

        //제 3사분면
        else if(x < Math.pow(2, N-1) && y >= Math.pow(2, N-1)){
            cnt += Math.pow(Math.pow(2, N-1), 2) * 2;
            y -= Math.pow(2, N-1);
            //System.out.println("3: " + cnt);
            dnc(N-1, x, y);
        }

        //제 4사분면
        else if(x >= Math.pow(2, N-1) && y >= Math.pow(2, N-1)){
            cnt += Math.pow(Math.pow(2, N-1), 2) * 3;
            x -= Math.pow(2, N-1);
            y -= Math.pow(2, N-1);
            //System.out.println("4: "+ cnt);
            dnc(N-1, x, y);
        }
        return cnt;
    }
}
