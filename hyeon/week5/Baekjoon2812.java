import java.io.*;
import java.util.*;

public class Baekjoon2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());        
        String number = br.readLine();        
        Stack<Character> result = new Stack<>();        
        int deleteCount = K;

        for (int i = 0; i < N; i++) {
            char currentNum = number.charAt(i);
            
            while (deleteCount > 0 && !result.isEmpty() && result.peek() < currentNum) {
                result.pop();
                deleteCount--;
            }
            
            result.push(currentNum);
        }

        while (deleteCount > 0) {
            result.pop();
            deleteCount--;
        }

        StringBuilder sb = new StringBuilder();
        for (char digit : result) { 
            sb.append(digit);
        }
        
        System.out.println(sb.toString());
    }
}