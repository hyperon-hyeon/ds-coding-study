import java.io.*;
import java.util.*;

public class Baekjoon1987 {
    static int R, C; 
    static char[][] board; 
    static int max_count = 0; 
    
    static boolean[] visitedAlphabet = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        int startCharIndex = board[0][0] - 'A';
        
        visitedAlphabet[startCharIndex] = true;
        
        dfs(0, 0, 1);

        System.out.println(max_count);
    }

    static void dfs(int r, int c, int count) {
        max_count = Math.max(max_count, count);

        if (max_count == R * C) {
            return;
        }

        if (r - 1 >= 0) {
            int nextCharIndex = board[r - 1][c] - 'A';
            if (!visitedAlphabet[nextCharIndex]) {
                visitedAlphabet[nextCharIndex] = true;
                dfs(r - 1, c, count + 1);
                visitedAlphabet[nextCharIndex] = false;
            }
        }
        
        if (r + 1 < R) {
            int nextCharIndex = board[r + 1][c] - 'A';
            if (!visitedAlphabet[nextCharIndex]) {
                visitedAlphabet[nextCharIndex] = true;
                dfs(r + 1, c, count + 1);
                visitedAlphabet[nextCharIndex] = false;
            }
        }
        
        if (c - 1 >= 0) {
            int nextCharIndex = board[r][c - 1] - 'A';
            if (!visitedAlphabet[nextCharIndex]) {
                visitedAlphabet[nextCharIndex] = true;
                dfs(r, c - 1, count + 1);
                visitedAlphabet[nextCharIndex] = false;
            }
        }

        if (c + 1 < C) { 
            int nextCharIndex = board[r][c + 1] - 'A';
            if (!visitedAlphabet[nextCharIndex]) {
                visitedAlphabet[nextCharIndex] = true;
                dfs(r, c + 1, count + 1);
                visitedAlphabet[nextCharIndex] = false;
            }
        }
    }
}