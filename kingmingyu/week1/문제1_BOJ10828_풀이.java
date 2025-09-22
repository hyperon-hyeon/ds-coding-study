package kingmingyu.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제1_BOJ10828_풀이{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        String command; // 명령어 공간 할당

        for(int i = 0; i < n; i++) {
            command = br.readLine();

            //push
            if (command.split(" ")[0].equals("push")) {
                stack.push(Integer.parseInt(command.split(" ")[1]));
            }

            //pop
            else if (command.split(" ")[0].equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            }

            //top
            else if (command.split(" ")[0].equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }

            //empty
            else if (command.split(" ")[0].equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            //size
            else if (command.split(" ")[0].equals("size")) {
                System.out.println(stack.size());
            }
        }
    }
}