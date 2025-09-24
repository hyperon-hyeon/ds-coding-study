package kingmingyu.week1;

import java.io.*;
import java.util.*;

public class 문제2_BOJ1966_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위를 저장할 우선순위 큐(큰 수 우선)
            Queue<int[]> queue = new LinkedList<>(); // [문서 인덱스, 문서 우선순위] 저장할 큐

            //문서 자료구조에 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            int docN = Integer.parseInt(st.nextToken());
            int findDocIdx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < docN; j++){
                int doc = Integer.parseInt(st.nextToken());
                pQ.add(doc);
                queue.add(new int[]{j, doc});
            }

            int printDoc = 0; //출력한 문서 개수
            while(!queue.isEmpty()){
                int[] curDoc = queue.poll(); // 현재 출력할 문서
                if(curDoc[1] == pQ.peek()){ // 우선순위가 가장 높다면
                    printDoc++;
                    pQ.poll();
                    if(curDoc[0] == findDocIdx)
                        break;
                }
                else { queue.add(curDoc); }
            }

            System.out.println(printDoc);
        }
    }
}
