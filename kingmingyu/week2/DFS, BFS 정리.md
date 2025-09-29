# DFS(Depth-First-Search): 깊이 우선 탐색
- 모든 노드를 방문하고자 할 때 사용(**그래프 완전 탐색)**
- 그래프의 시작 노드에서 출발하여 탐색할 한 쪽 분기를 정해서 **최대 깊이까지 탐색**을 마친 후,**다른 쪽 분기로 이동**하여 다시 탐색을 수행하는 알고리즘
- **재귀함수** 또는 **Stack** 자료구조를 이용
- 재귀함수를 이용하므로 **stack overflow**에 유의해야 한다.

## DFS 핵심 이론

### 1. 방문 여부 확인용 배열

- `static boolean[] visited = new boolean[7];`
- DFS는 한번 방문한 노드를 다시 방문하면 안되므로 노드 방문 여부를 체크할 배열이 필요
- 예를들어 1~6의 노드를 가진 그래프가 있으면, `boolean[] arr = new boolean[7];`으로 배열을 만들어 준다.
(0번 인덱스는 사용하지 않는다.)
- 해당 노드를 방문하면 해당 인덱스의 값을 `TRUE`

### 2. 원본 그래프 -> 자료구조 초기화 (인접 리스트)
<img width="1166" height="367" alt="Image" src="https://github.com/user-attachments/assets/ea6aee6f-4923-46d6-92e7-15f893660f58" />

1. 시작할 노드를 정한다.
2. 각 노드에서 갈수있는 다른 노드를 확인 후 인접리스트로 초기화 한다.
3. 시작점을 정했기 때문에 시작점의 방문배열을 T로바꿔주고, 스택에 시작점을 더한다.

### 3. 스택(재귀함수)에서 꺼낸 노드의 인접 노드를 스택에 삽입
<img width="1161" height="414" alt="Image" src="https://github.com/user-attachments/assets/4ab4a3b3-c9fd-4c5f-b05a-735c5e1c9924" />

1. 맨 처음에 넣었던 시작노드 1을 스택에서 pop 한다. ( pop 할때, 해당 값의 방문배열은 T로 변경 )
2. 1의 인접노드 2,3을 스택에 삽입한다.
3. 이 과정을 **스택이 비워질 때까지 반복** 한다.

### 4. 반복
<img width="1231" height="474" alt="Image" src="https://github.com/user-attachments/assets/2061785c-7877-41ab-aa3a-9c49eb7d9862" />

1. 위에서 1이 pop되고, 2,3이 스택에 들어있는 상황
2. `pop(3)` -> 3의 방문배열 True -> 3의 인접노드 `push(4)`
3. `pop(4)` -> 4의 방문배열 True -> 4의 인접노드 `push(6)`
4. `pop(6)` -> 6의 방문배열 True -> 6은 인접노드가 없기 때문에 push할 노드는 없다.
5. `pop(2)` -> 2의 인접노드는 5,6이지만 6의 방문배열은 True 이므로 `push(5)`만 할수 있다.
6. `pop(5)` -> 5의 방문배열 True
7. `stack.isEmpty() == true`

→ 탐색 순서는 [ 1 - 3 - 4 - 6 - 2 - 5 ]

## 구현
- 인접 리스트 초기화
<img width="384" height="251" alt="Image" src="https://github.com/user-attachments/assets/06a90282-27ce-4a6a-a4c1-6bc09c64816d" />

```java
    //방문 배열
    static boolean[] visited = new boolean[7]; 
    
    //ArrayList타입 배열
    static ArrayList<Integer>[] A = new ArrayList[7];
    
    //탐색 순서 list (탐색 과정을 기록하고 확인하기 위해서)
    static ArrayList<Integer> procedure = new ArrayList<>(); 


    public static void main(String[] args){
    
			 	//배열의 각 요소마다 ArrayList를 가진다.
        for(int i=1;i<=6;i++) {
            A[i] = new ArrayList<>();
        }
        A[1].add(2);
        A[1].add(3);
        A[2].add(5);
        A[2].add(6);
        A[3].add(4);
        A[4].add(6);
        
        // 오름 차순 탐색이 필요한 경우 인접 리스트 원소를 정렬
        //for (int i = 1; i <= 6; i++) {
        //    Collections.sort(A[i]);  // 오름차순 정렬
        // }
        
        //1번노드에서 DFS 실행
        DFS(1);

        System.out.println(procedure.toString()); 
        // [1, 3, 4, 6, 2, 5] (스택)
        // [1, 2, 6, 5, 3, 4] (재귀)
        // 인접리스트에 들어있는 값의 순서에 따라 탐색 순서가 달라질 수 있으나, 두가지 경우 모두 DFS가 맞다.
    }
```

1. 스택 이용
```java
public static void DFS(int v){
    Stack<Integer> stack = new Stack<>();

    stack.push(v);;
    
    while(!stack.isEmpty()){
        int cur = stack.pop();
        visited[cur] = true;
        procedure.add(cur);

        //해당 노드의 인접리스트를 검사하며, visited가 false인 경우에만 stack.push
        for (int i : A[cur]) {
            if(!visited[i]){
                stack.push(i);
            }
        }
    }
}
```
2. 재귀함수 이용
```java
public static void DFS(int v){
    //방문배열이 true면 return
    if(visited[v]) return;

    //v 노드에 방문했으므로, 해당 방문배열을 true로 바꿔주고, 탐색순서 리스트에 추가해줌
    visited[v] = true;
    procedure.add(v);

    //해당노드의 ArrayList(인접노드)를 모두 돌며 방문배열이 false인 경우에
    for(int i : A[v]){
        if(!visited[i]){
            DFS(i); //해당 노드에 대해서 DFS를 다시 실행한다.
        }
    }
}
```
---
# BFS(Breadth-Fisrt Search): 너비 우선 탐색
- **그래프 완전 탐색 이론**
- 시작 노드에서 출발해 시작 노드를 기준으로 **가장 가까운 노드를 먼저 방문**하면서 탐색하는 알고리즘이다.
- FIFO 탐색 -> **Queue** 자료구조를 이용한다.
- 목표 노드에 도착하는 경로가 여러 개일 때 **최단 경로를 보장**한다.

## BFS 핵심 이론
### 1. 방문 여부 확인용 배열 

- `static boolean[] arr = new boolean[7];` 
- BFS도 DFS와 마찬가지로 한번 방문한 노드를 다시 방문하면 안되므로 **노드 방문 여부를 체크할 배열**이 필요
- ex) 1~6의 노드를 가진 그래프
  → `boolean[] arr = new boolean[7];`으로 배열 생성 (0번 idx 사용 X)
- 해당 노드를 방문하면 해당 인덱스의 값을 TRUE

### 2. 원본 그래프 → 자료구조 초기화 (인접 리스트)
<img width="805" height="247" alt="Image" src="https://github.com/user-attachments/assets/ad8cd70d-784b-4a8d-8fc9-59a43ed5aa7b" />

1. 시작할 노드를 정한다.
2. 각 노드에서 갈수있는 다른 노드를 확인 후 인접리스트로 초기화 한다.
3. 시작점을 정했기 때문에 시작점의 방문배열을 T로바꿔주고, Queue에 시작점을 더한다.

### 3. 큐에서 꺼낸 노드의 인접 노드를 큐에 삽입
<img width="774" height="280" alt="Image" src="https://github.com/user-attachments/assets/8b81db74-1c5f-482c-8968-0aea42a8d334" />

1. 맨 처음에 넣었던 노드1을 Queue에서 꺼낸다.
2. 꺼낸 노드 1의 인접노드(2,3)을 큐에 삽입한다.
3. 이 과정을 Queue가 비워질 때까지 반복한다.

### 4. 반복
<img width="811" height="279" alt="Image" src="https://github.com/user-attachments/assets/016bc277-4c67-4f98-9e06-14dca9210d78" />

1. 위에서 1을 꺼낸 뒤, 노드2,3을 넣은 상태
2. `poll(2)` -> 2의 방문배열 True -> 2의 인접 리스트 5,6을 넣는다. `offer(5)`, `offer(6)`
3. `poll(3)` -> 3의 방문배열 True -> 3의 인접 리스트 4를 넣는다. `offer(4)`
4. `poll(5)` -> 5의 방문배열 True -> 5의 인접리스트는 없다.
5. `poll(6)` -> 6의 방문배열 True -> 6의 인접리스트는 없다.
6. `poll(4)` -> 4의 방문배열 True -> 4의 인접리스트는 없다.
7. `queue.isEmpty() == true`

## 구현
```java
    //방문 배열 초기화
    static boolean[] visited = new boolean[7]; 
    static Queue<Integer> queue = new LinkedList<>();
    //ArrayList 타입 배열 선언
    static ArrayList<Integer>[] A = new ArrayList[7]; 
    //탐색 순서 출력을 위한 리스트 (탐색 과정을 기록하고 확인하기 위해서)
    static ArrayList<Integer> procedure = new ArrayList<>(); 

    public static void main(String[] args){
        //ArrayList 형 배열 A 초기화
        for(int i=1;i<=6;i++) {
            A[i] = new ArrayList<>();//배열의 각 요소마다 ArrayList를 가진다.
        }
        //위의 예제 인접 리스트 초기화
        A[1].add(2);
        A[1].add(3);
        A[2].add(5);
        A[2].add(6);
        A[3].add(4);
        A[4].add(6);

        BFS(1);

        System.out.println(procedure.toString()); //[1, 2, 3, 5, 6, 4]
    }
    private static void BFS(int start){
        queue.offer(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            // poll() 할때, 탐색순서 리스트에 넣어주고,방문배열을 true로 바꿔준다.
            procedure.add(now); 
            visited[now] = true;

            // 꺼낸 노드의 인접노드를 전부 확인한다.
            for(int i=0;i<A[now].size();i++){
                int node = A[now].get(i);

                //인접노드가 방문한적 없는 노드면 queue에 넣어준다.
                if(!visited[node]){
                    queue.offer(node);
                }
            }
        }
    }
}
```

---
### 참고 자료
- [DFS 깊이 우선 탐색](https://innovation123.tistory.com/71)
- [BFS 너비 우선 탐색](https://innovation123.tistory.com/71)