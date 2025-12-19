## DP(Dynamic Programing)란?

기본적인 아이디어로 **하나의 큰 문제를 여러 개의 작은 문제로 나누어서 그 결과를 저장하여 다시 큰 문제를 해결할 때 사용**하는 것(특정한 알고리즘이 아닌 하나의 문제해결 패러다임)

→ 큰 문제를 작은 문제로 쪼개서 그 답을 저장해두고 재활용('기억하며 풀기'라고 부르기도 한다.**)**

## **2. DP를 쓰는 이유**

**일반적인 재귀를 단순히 사용 시 동일한 작은 문제들이 여러 번 반복 되어 비효율적인 계산**

ex) 피보나치 수열

피보나치 수열: 1,  1,  2,  3,  5,  8,  13,  21,  34,  55,  89,  144 ...

재귀로 피보나치 함수 구성 → `return f(n) = f(n-1) + f(n-2)`

100번째 피보나치 수를 구하기 위해 호출되는 함수의 횟수는 기하급수 적으로 증가(약 7해, #,###경 #,###조 ... 번 이상 함수 호출)

![                                                피보나치 수열 함수 호출 트리](https://blog.kakaocdn.net/dna/t3PF0/btqSgLZbXTp/AAAAAAAAAAAAAAAAAAAAAETm90hgWpL-K1qfYhR7v1TJURb4tI6pCfS4zllWhYqE/img.png?credential=yqXZFxpELC7KVnFOS48ylbz2pIh7yKj8&expires=1767193199&allow_ip=&allow_referer=&signature=HRC8jM2ZMuHEgnfj0gl2xSxnacE%3D)

                                                피보나치 수열 함수 호출 트리

그러나 한 번 구한 작은 문제의 결과 값을 저장해두고 재사용

→약 200회 내에 계산(앞에서 계산된 값을 다시 반복 X)

**O(n^2) → O(f(n)) 로 개선**

## **3. DP의 사용 조건(2가지)**

**1) Overlapping Subproblems(겹치는 부분 문제)**

**2) Optimal Substructure(최적 부분 구조)**

### **① Overlapping Subproblems(겹치는 부분 문제)**

**동일한 작은 문제들이 반복하여 나타나는 경우에 사용이 가능(**DP는 기본적으로 문제를 나누고 그 문제의 결과 값을 재활용해서 전체 답을 구하기 때문)

ex) **이진 탐색 &** **피보나치 수열**

**이진 탐색**은 특정 데이터를 정렬된 배열 내에서 그 위치를 찾기 때문에 그 위치를 찾은 후 바로 반환할 뿐 그것을 재사용하는 과정을 거치지 않는다.

반면, **피보나치 수열**은 f(n) = f(n-1) + f(n-2) 인데, 아래와 같은 트리 구조로 함수가 호출되게 된다.

![](https://blog.kakaocdn.net/dna/t3PF0/btqSgLZbXTp/AAAAAAAAAAAAAAAAAAAAAETm90hgWpL-K1qfYhR7v1TJURb4tI6pCfS4zllWhYqE/img.png?credential=yqXZFxpELC7KVnFOS48ylbz2pIh7yKj8&expires=1767193199&allow_ip=&allow_referer=&signature=HRC8jM2ZMuHEgnfj0gl2xSxnacE%3D)

**f(3), f(2), f(1)과 같이 동일한 부분 문제가 중복** → 저장된 값을 재활용 가능

### **② Optimal Substructure(최적 부분 구조)**

**부분 문제의 최적 결과 값을 사용해 전체 문제의 최적 결과를 낼 수 있는 경우**

ex) A - B까지 X를 거쳐 가장 짧은 경로 찾기

A - X / X - B가 많은 경로 중 가장 짧은 경로라면 전체 최적 경로도 A - X - B가 정답이 된다.

![](https://blog.kakaocdn.net/dna/dfnwTm/btqSsRROqcY/AAAAAAAAAAAAAAAAAAAAAFQ9OzX_d94_iNA5N4KHuVfsf1W3bkaP9V9q4FST8yrY/img.png?credential=yqXZFxpELC7KVnFOS48ylbz2pIh7yKj8&expires=1767193199&allow_ip=&allow_referer=&signature=v2dKL1h5cEzc9GRMTs%2BCqUiBARU%3D)

위의 그림에서 A - X 사이의 최단 거리는 AX2, X - B는 BX2이다. 전체 최단 경로는 AX2 - BX2이다.

이와 같이 부분 문제에서 구한 최적 결과가 전체 문제에서도 동일하게 적용되어 결과가 변하지 않을 때 DP를 사용

## **4. DP 사용하기**

1. **DP 적용 가능 여부 확인**

   문제가 최적 부분 구조(Optimal Substructure)를 가지는지 확인.

   중복되는 부분 문제(Overlapping Subproblems)가 발생하는지 확인.

2. **변수 파악**

   문제의 상태를 나타내는 핵심 변수를 설정.

3. **점화식 만들기 (Recurrence Relation)**

   변수 간의 관계를 수식으로 정의

   피보나치 수열: `f(n) = f(n-1) + f(n-2)`

4. **기저 상태 파악**

   가장 작은 문제의 상태이자, 종료 조건 설정.

   피보나치 수열: f(0) = 0, f(1) = 1과 같은 방식

5. **구현 방식 결정 및 코딩**

   Top-Down (Memoization) 또는 Bottom-Up (Tabulation) 중 선택.


### **구현 방식 비교: Bottom-Up vs Top-Down**

### **① Bottom-Up 방식 (Tabulation)**

- **개념:** 아래에서부터 계산을 수행하고 누적시켜 전체 큰 문제를 해결하는 방식.
- **구현:** **반복문(Iteration)** 사용.
- **특징:**
    - `dp[0]`(기저 상태)부터 시작하여 `dp[n]`(목표)까지 점화식을 통해 값을 채워나감.
    - **Tabulation(태뷸레이션):** 반복문을 통해 테이블(배열)을 처음부터 하나씩 채우는 과정("Table-filling")에서 유래.
    - 재귀 호출 오버헤드가 없어 일반적으로 더 효율적일 수 있음.

### **② Top-Down 방식 (Memoization)**

- **개념:** 위에서부터 바로 호출을 시작하여 기저 상태까지 내려간 뒤, 결과 값을 재활용하는 방식.
- **구현:** **재귀(Recursion)** 사용.
- **특징:**
    - `dp[n]`(목표)을 구하기 위해 `dp[n-1]`, `dp[n-2]`를 호출하며 `dp[0]`까지 내려감.
    - **Memoization(메모이제이션):** 이전에 계산 완료된 결과를 메모리에 저장해두고, 필요할 때 꺼내 씀(가장 최근 상태 값을 메모).
    - 점화식의 형태를 그대로 직관적으로 코드로 옮기기 좋음.

## 코드(Java)

피보나치 수열 (30번째 항 구하기) → 일반 재귀 vs Top-Down vs Bottom-Up

```java
package com.test;

public class Fibonacci {
    // 메모이제이션 & 태뷸레이션을 위한 배열 (인덱스 n까지 담기 위해 n+1 크기 할당)
    static int[] topDown_memo;
    static int[] bottomUp_table;

    public static void main(String[] args) {
        int n = 30;
        topDown_memo = new int[n + 1];
        bottomUp_table = new int[n + 1];

        // 1. 일반 재귀 (Naive Recursion)
        long startTime = System.currentTimeMillis();
        System.out.println("일반 재귀 결과: " + naiveRecursion(n));
        long endTime = System.currentTimeMillis();
        System.out.println("소요 시간: " + (endTime - startTime) + "ms");

        System.out.println("-------------------------");

        // 2. Top-Down DP
        startTime = System.currentTimeMillis();
        System.out.println("Top-Down 결과: " + topDown(n));
        endTime = System.currentTimeMillis();
        System.out.println("소요 시간: " + (endTime - startTime) + "ms");

        System.out.println("-------------------------");

        // 3. Bottom-Up DP
        startTime = System.currentTimeMillis();
        System.out.println("Bottom-Up 결과: " + bottomUp(n));
        endTime = System.currentTimeMillis();
        System.out.println("소요 시간: " + (endTime - startTime) + "ms");
    }

    // [1] 일반 재귀: 동일 계산 반복으로 매우 비효율적
    public static int naiveRecursion(int n) {
        if (n <= 1) return n;
        return naiveRecursion(n - 1) + naiveRecursion(n - 2);
    }

    // [2] Top-Down (Memoization): 재귀 + 메모
    public static int topDown(int n) {
        // 기저 상태
        if (n < 2) return topDown_memo[n] = n;
        
        // 메모(Cache)에 계산된 값이 있으면 바로 반환 (핵심)
        if (topDown_memo[n] > 0) return topDown_memo[n];

        // 없으면 계산 후 저장
        topDown_memo[n] = topDown(n - 1) + topDown(n - 2);
        
        return topDown_memo[n];
    }

    // [3] Bottom-Up (Tabulation): 반복문 + 테이블 채우기
    public static int bottomUp(int n) {
        // 기저 상태 미리 저장
        bottomUp_table[0] = 0;
        bottomUp_table[1] = 1;

        // 작은 값부터 차곡차곡 채워나감 (Table-filling)
        for (int i = 2; i <= n; i++) {
            bottomUp_table[i] = bottomUp_table[i - 1] + bottomUp_table[i - 2];
        }
        return bottomUp_table[n];
    }
}
```

**성능 비교 결과**

- **일반 재귀:** 9ms (중복 계산으로 인해 `O(2^n)` 시간 복잡도 발생)
- **Top-Down / Bottom-Up:** 0ms (중복 계산 제거로 `O(n)` 시간 복잡도 달성)
- **결론:** DP를 사용하면 지수 시간 O(2^n)을 선형 시간 O(n)으로 단축 가능

## 참고 문헌

[알고리즘 - Dynamic Programming(동적 계획법)](https://hongjw1938.tistory.com/47)