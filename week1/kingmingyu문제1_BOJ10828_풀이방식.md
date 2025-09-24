# 문제
각 stack 연산에 따른 결과 출력하기
- push X: 정수 X를 스택에 넣는 연산이다.
- pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- size: 스택에 들어있는 정수의 개수를 출력한다.
- empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
- top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

-> java의 stack 이용하여 구현

### push
```java
if (command.split(" ")[0].equals("push")) {
                stack.push(Integer.parseInt(command.split(" ")[1]));
            }
```
### pop
```java
else if (command.split(" ")[0].equals("pop")) {
    if (stack.isEmpty()) {
        System.out.println(-1);
    } else {
        System.out.println(stack.pop());
    }
}
```

### size
```java
else if (command.split(" ")[0].equals("size")) {
    System.out.println(stack.size());
}
```

### empty
```java
else if (command.split(" ")[0].equals("empty")) {
    if (stack.isEmpty()) {
        System.out.println(1);
    } else {
        System.out.println(0);
    }
}
```

### top
```java
else if (command.split(" ")[0].equals("top")) {
    if (stack.isEmpty()) {
        System.out.println(-1);
    } else {
        System.out.println(stack.peek());
    }
}
```


# 시간 초과 발생
- Scanner -> BufferReader로 변경

# 전체 코드
```java
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
```
