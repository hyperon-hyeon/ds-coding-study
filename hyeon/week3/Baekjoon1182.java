import java.io.*;
import java.util.*;

public class Baekjoon1182 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int S;
    static int count=0;

    public static void DFS(int[] arr, int index, int current_sum){

        if (index == N){
            if (current_sum == S){count = count + 1;}
            return;
        }

        DFS(arr, index + 1, current_sum + arr[index]);
        DFS(arr, index + 1, current_sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        S = Integer.parseInt(st.nextToken()); 
        int[] arr=new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i]=num;            
        }

        DFS(arr,0,0);

         if (S == 0) {
            bw.write(String.valueOf(count - 1));
        } else {
            bw.write(String.valueOf(count));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
