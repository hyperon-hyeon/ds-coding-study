package kingmingyu.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제1_BOJ1260_풀이 {

    // 그래프
    static ArrayList<Integer>[] graph;
    // DFS 방문 배열
    static boolean[] dfsVisited;
    // BFS 방문 배열
    static boolean[] bfsVisited;
    // BFS를 위한 큐
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        //그래프 초기화
        graph = new ArrayList[node + 1];
        for(int i = 1; i <= node; i++){
            graph[i] = new ArrayList<>();
        }
        //DFS visited
        dfsVisited = new boolean[node + 1];
        //BFS visited
        bfsVisited = new boolean[node + 1];
        queue = new LinkedList<>();

        for(int i = 1; i <= edge; i++){
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for (int i = 1; i <= node; i++) {
            Collections.sort(graph[i]);  // 오름차순 정렬
        }

        DFS(start);
        System.out.println();
        BFS(start);
    }

    public static void DFS(int node){
        if(dfsVisited[node]){
            return;
        }

        dfsVisited[node] = true;
        System.out.print(node + " ");

        for(int i : graph[node]){
            DFS(i);
        }
    }

    public static void BFS(int start){
        queue.offer(start);
        bfsVisited[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next : graph[cur]){
                if(!bfsVisited[next]){
                    queue.offer(next);
                    bfsVisited[next] = true;
                    System.out.print(next + " ");
                }
            }
        }
    }
}
