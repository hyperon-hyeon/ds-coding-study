package kingmingyu.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제2_BOJ1987_풀이 {

    static boolean visited[] = new boolean[26];
    static char[][] alpha; // 입력받은 알파벳 map 그래프
    static int dx[] = {-1, 0, 1, 0}; // x방향으로 이동
    static int dy[] = {0, 1, 0, -1}; // y방향으로 이동
    static int n, m; // 그래프의 최대 크기
    static int max; // 가장 깊게 이동한 경우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        alpha = new char[n][m];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                alpha[i][j] = line.charAt(j);
            }
        }

        max = 0;
        dfs(0, 0, 1);

        System.out.print(max);

    }
    static public void dfs(int x, int y, int dist){
        visited[alpha[x][y] - 'A'] = true;

        if(dist > max){
            max = dist;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                if(visited[alpha[nx][ny] - 'A'] == false){
                    dfs(nx, ny, dist+1);
                    visited[alpha[nx][ny] - 'A'] = false;
                }
            }
        }
    }
}
