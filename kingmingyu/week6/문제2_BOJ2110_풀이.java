package kingmingyu.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제2_BOJ2110_풀이 {

    static List<Integer> homeX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집의 개수
        int N = Integer.parseInt(st.nextToken());
        // 공유기의 개수
        int C = Integer.parseInt(st.nextToken());

        homeX = new ArrayList<>();
        for(int i = 0; i < N; i++){
            homeX.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(homeX);

        //공유기 설치 최소 거리
        int min = 1;
        //공유기 설치 최대 거리
        int max = homeX.getLast() - homeX.getFirst() + 1; // 백준 제출 시 .get으로 바꾸기

        while(min < max){

            //탐색 값
            int mid = (min + max) / 2;

            //설치된 공유기의 수가 주어진 공유기 보다 적다면 반 줄이기
            if(install(mid) < C){
                max = mid;
            }
            //설치된 공유기의 수가 크거나 같다면 정답이거나 더 넓게 설치할 수 있으므로 +1하여 탐색
            else{
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
    public static int install(int dist){
        int count = 1;
        int lastLocate = homeX.getFirst();

        //mid 거리로 공유기 설치
        for(int i = 0; i < homeX.size(); i++){
            int locate = homeX.get(i);

            if(locate - lastLocate >= dist){
                count++;
                lastLocate = locate;
            }
        }
        //설치된 공유기의 수
        return count;
    }
}
// O O X O X X X O O
// 1 2 3 4 5 6 7 8 9