package kingmingyu.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 문제2_BOJ2812_풀이 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int now = str.charAt(i) - '0';

            // 현재 숫자가 스택 마지막보다 크면 이전 숫자 제거
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < now) {
                stack.pollLast();
                k--;
            }
            stack.addLast(now);
        }

        // 아직 제거 안 한 k가 남으면 뒤에서 제거
        while (k-- > 0) {
            stack.pollLast();
        }

        // 출력
        for (int num : stack) {
            System.out.print (num);
        }
    }
}