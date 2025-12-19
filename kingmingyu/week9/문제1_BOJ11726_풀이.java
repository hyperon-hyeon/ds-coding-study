package kingmingyu.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제1_BOJ11726_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fib(n));
    }

    public static int fib(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;

        int sum = 0;
        int f1 = 1;
        int f2 = 2;

        for(int i = 2; i < n; i++){
            sum = (f1 + f2) % 10007;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }
}
