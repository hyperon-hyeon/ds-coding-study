import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1753 {
    
    // 문제의 최대 경로 가중치보다 큰 값 (무한대)
    private static final int INF = 200001; 
    
    /**
     * 다익스트라 알고리즘 (우선순위 큐와 람다 표현식 사용)
     * @param start 시작 정점 (0-based index)
     * @param v 정점의 개수
     * @param adj 인접 리스트 (List<int[]>[]) - [도착 정점, 가중치]
     * @return 시작점으로부터 각 정점까지의 최단 거리가 담긴 배열
     */
    private static int[] dijkstra(int start, int v, List<int[]>[] adj) {
        int[] distance = new int[v];
        // 1. 초기화
        Arrays.fill(distance, INF);
        distance[start] = 0;

        // 2. 우선순위 큐 생성 및 시작 정점 삽입
        // PriorityQueue에 int[] (원소: {거리, 정점})을 저장하고,
        // 람다 표현식으로 거리를 기준으로 오름차순 정렬하도록 정의
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // {거리, 정점} 형태로 시작 정점 삽입
        pq.add(new int[]{0, start}); // {가중치, 정점 인덱스}

        // 3. 다익스트라 실행
        while (!pq.isEmpty()) {
            // 현재까지 최단 거리가 확정된 정점(u) 추출
            int[] current = pq.poll();
            int dist = current[0]; // 현재 정점까지의 최단 거리
            int u = current[1];   // 현재 정점 인덱스

            // 이미 더 짧은 경로를 찾았다면 무시
            if (distance[u] < dist) {
                continue;
            }

            // u와 연결된 모든 인접 정점 확인
            for (int[] edge : adj[u]) {
                int nextV = edge[0]; // 도착 정점
                int weight = edge[1]; // 간선 가중치

                // 새로운 경로의 거리
                int newDist = distance[u] + weight;

                // 더 짧은 경로 발견 시 갱신하고 우선순위 큐에 삽입
                if (newDist < distance[nextV]) {
                    distance[nextV] = newDist;
                    // {새로운 최단 거리, 도착 정점} 형태로 큐에 삽입
                    pq.add(new int[]{newDist, nextV});
                }
            }
        }
        
        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int v = sc.nextInt(); // 정점의 개수 (V)
        int e = sc.nextInt(); // 간선의 개수 (E)
        int k = sc.nextInt(); // 시작 정점의 번호 (K) (1-based)
        
        // 0-based indexing으로 변환
        int startNode = k - 1; 

        // 2. 인접 리스트 초기화 (0-based indexing)
        // 경고를 피하기 위해 타입 파라미터를 명시적으로 사용하지 않고 기본 List[]로 선언
        List<int[]>[] adj = (List<int[]>[]) new List[v]; 
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        // 3. 간선 정보 입력 및 인접 리스트 업데이트
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt(); // 시작 정점 (1-based)
            int vv = sc.nextInt(); // 도착 정점 (1-based)
            int w = sc.nextInt(); // 가중치

            // 0-based indexing으로 변환
            int from = u - 1;
            int to = vv - 1;

            // [도착 정점 인덱스, 가중치] 형태로 인접 리스트에 추가
            adj[from].add(new int[]{to, w});
        }
        
        sc.close();

        // 4. 시작 정점 K로부터 다익스트라 실행
        int[] result = dijkstra(startNode, v, adj);

        // 5. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int cost : result) {
            
            // 갈 수 없는 경우 "INF"를 출력
            if (cost == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(cost).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}