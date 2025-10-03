import java.io.*;
import java.util.*;

public class Baekjoon1260 {
    static int[][] matrix; 
    static boolean[] visited; 
    static int N; 
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int node) throws IOException {
        visited[node] = true;
        bw.write(node + " ");

        for (int i = 1; i <= N; i++) {
            if (matrix[node][i] == 1 && !visited[i]) {
                dfs(i); 
            }
        }
    }

    public static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        bw.write(start + " ");
        
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 1; i <= N; i++) {
                if (matrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true; 
                    q.add(i);        
                    bw.write(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int V = Integer.parseInt(st.nextToken()); 
        matrix = new int[N + 1][N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        visited = new boolean[N + 1]; 
        dfs(V);
        bw.newLine(); 

        visited = new boolean[N + 1]; 
        bfs(V);

        bw.flush();
        bw.close();
        br.close();
    }
}
