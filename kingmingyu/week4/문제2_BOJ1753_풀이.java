package kingmingyu.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int vertex;
    int cost;

    public Node(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return Integer.compare(this.cost, o.cost);
    }
}

public class 문제2_BOJ1753_풀이 {
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int vN = Integer.parseInt(st.nextToken());
        int eN = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[vN + 1];
        for(int i = 0; i <= vN; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < eN; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        dijkstra(vN, start);

    }

    public static void dijkstra(int n, int start){
        boolean[] visited = new boolean[n + 1];
        int dist[] = new int [n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int current = pq.poll().vertex;

            if(visited[current]) continue;
            visited[current] = true;

            for(Node next : graph[current]){
                if(dist[next.vertex] > dist[current] + next.cost){
                    dist[next.vertex] = dist[current] + next.cost;
                    pq.offer(new Node(next.vertex, dist[next.vertex]));
                }

            }
        }

        for(int i = 1; i <= n; i++){
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
