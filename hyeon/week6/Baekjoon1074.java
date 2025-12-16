import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1074 {

    static int N, R, C;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // N (배열 크기 2^N)
        R = Integer.parseInt(st.nextToken()); // 목표 행    
        C = Integer.parseInt(st.nextToken()); // 목표 열

        int size = (int) Math.pow(2, N);

        findZOrder(0, 0, size);

        System.out.println(result);
    }

    public static void findZOrder(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        int area = half * half;

        if (R < r + half && C < c + half) {
            findZOrder(r, c, half);

        } else if (R < r + half && C >= c + half) {
            result += area;
            findZOrder(r, c + half, half);

        } else if (R >= r + half && C < c + half) {
            result += 2 * area;
            findZOrder(r + half, c, half);

        } else { 
            result += 3 * area;
            findZOrder(r + half, c + half, half);
        }
    }
}