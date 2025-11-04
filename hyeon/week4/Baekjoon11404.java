import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11404 {
    private static final int INF = 1000000000; 

    /**
     * 다익스트라 알고리즘 핵심 로직
     * @param start 시작 정점 (0-based index)
     * @param n 전체 정점의 개수
     * @param weight 인접 행렬 (가중치 정보)
     * @return 시작 정점으로부터 각 정점까지의 최소 거리 배열
     */

    private static int[] dijkstra(int start, int n, int[][] weight) {
        int[] distance = new int[n];
        boolean[] found = new boolean[n]; 
                
        // 1. 초기화
        Arrays.fill(distance, INF);
        distance[start] = 0;

        // 2. n-1번 반복하며 최단 경로 찾기
        for (int i = 0; i < n - 1; i++) {
            
            // 2-1. 방문하지 않은 정점 중 distance가 가장 작은 정점(u) 선택 (choose 함수 역할)
            int u = -1;
            int minDistance = INF;
            for (int j = 0; j < n; j++) {
                if (!found[j] && distance[j] < minDistance) {
                    minDistance = distance[j];
                    u = j;
                }
            }

            if (u == -1) break; // 더 이상 연결된 경로가 없으면 종료
            
            found[u] = true; // 선택한 정점 방문 표시

            // 2-2. 선택된 정점 u를 거쳐 다른 정점(w)으로 가는 거리 갱신
            for (int w = 0; w < n; w++) {
                // u에서 w로 가는 간선이 있고, w가 방문되지 않았으며, 더 짧은 경로가 발견된 경우
                if (!found[w] && weight[u][w] != INF) {
                    // distance[u]가 INF가 아닌 경우에만 갱신 (INF + 가중치 오버플로우 방지)
                    if (distance[u] != INF && distance[u] + weight[u][w] < distance[w]) {
                        distance[w] = distance[u] + weight[u][w];
                    }
                }
            }
        }
        
        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int n = sc.nextInt(); // 도시 개수
        int m = sc.nextInt(); // 버스 개수

        // 2. 인접 행렬 (가중치 행렬) 초기화
        // 도시 번호 1 ~ N을 배열 인덱스 0 ~ N-1에 대응
        int[][] weight = new int[n][n]; 
        for (int i = 0; i < n; i++) {
            Arrays.fill(weight[i], INF);
            weight[i][i] = 0; // 자기 자신으로의 거리는 0
        }

        // 3. 버스 정보 입력 및 인접 행렬 업데이트
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // 시작 도시 (1-based)
            int b = sc.nextInt(); // 도착 도시 (1-based)
            int c = sc.nextInt(); // 비용

            // 0-based indexing으로 변환
            int u = a - 1;
            int v = b - 1;

            // 시작 도시와 도착 도시를 연결하는 노선이 여러 개일 수 있으므로, 최소 비용만 저장
            weight[u][v] = Math.min(weight[u][v], c);
        }
        
        sc.close();

        // 4. 모든 도시를 시작점으로 다익스트라 실행 (N번 반복)
        int[][] result = new int[n][n];

        for (int startCity = 0; startCity < n; startCity++) {
            // startCity를 시작점으로 다익스트라 실행하여 최단 거리 배열 획득
            int[] distances = dijkstra(startCity, n, weight);
            
            // 결과 행렬에 저장
            result[startCity] = distances;
        }

        // 5. 결과 출력 (StringBuilder 사용으로 성능 최적화)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) { // 시작 도시
            for (int j = 0; j < n; j++) { // 도착 도시
                int cost = result[i][j];
                
                // 갈 수 없는 경우 (거리가 INF인 경우) 0을 출력
                if (cost == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(cost).append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}