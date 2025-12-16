import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1780 {

    static int[] counts = new int[3];
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, N);

        System.out.println(counts[0]); // -1의 개수
        System.out.println(counts[1]); // 0의 개수
        System.out.println(counts[2]); // 1의 개수
    }

    public static void divideAndConquer(int r, int c, int size) {
        if (check(r, c, size)) {
            int value = paper[r][c];
            if (value == -1) {
                counts[0]++;
            } else if (value == 0) {
                counts[1]++;
            } else { // value == 1
                counts[2]++;
            }
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divideAndConquer(r + i * newSize, c + j * newSize, newSize);
            }
        }
    }

    public static boolean check(int r, int c, int size) {
        int standard = paper[r][c]; 
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != standard) {
                    return false;
                }
            }
        }
        return true;
    }
}