# **분할 정복(Divide and Conquer) 알고리즘**

**→ 문제를 더 작은 하위 문제로 나누고(Divide)**, 각각을 **독립적으로 해결한 후(Conquer)**, 그 **결과를 합쳐서(Merge)** 원래 문제의 해답을 도출하는 방식의 알고리즘(**재귀**(Recursion)를 활용하여 문제를 단계적으로 해결하는 것이 특징)

1. **분할(Divide)**: 문제를 동일한 유형의 작은 하위 문제로 나누기
2. **정복(Conquer)**: 나눈 하위 문제를 개별적으로 해결(보통 재귀적으로 호출)
3. **결합(Merge)**: 해결된 하위 문제들을 합쳐서 최종적인 결과를 도출

대부분 시간 복잡도 **O(n log n)**

ex)  병합 정렬(Merge Sort)

**분할(**배열 절반 나누기): O(log n) * **정복**(n개의 요소를 정렬): O(n)

→ O(n log n)

## 분할 정복 예시: **병합 정렬(Merge Sort)**

[38, 27, 43, 3, 9, 82, 10]

### **1. 분할(Divide)**

→ 배열이 더 이상 쪼개질 수 없을 때 까지 분할

```less
1. [38, 27, 43, 3]  |  [9, 82, 10]
2. [38, 27]  |  [43, 3]  |  [9, 82]  |  [10]
3. [38]  |  [27]  |  [43]  |  [3]  |  [9]  |  [82]  |  [10]
```

### **2. 정복(Conquer)**

- 크기가 1인 배열은 이미 정렬된 상태이므로, 두 개씩 묶어 정렬을 수행

```less
1. [27, 38]  |  [3, 43]  |  [9, 82]  |  [10]
2. [3, 27, 38, 43]  |  [9, 10, 82]
3. [3, 9, 10, 27, 38, 43, 82]
```

## **코드 (Merge Sort)**

```java
public class MergeSort {
    void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
}
```

## **분할 정복 알고리즘의 주요 사용처**

### **1. 정렬 문제 (Sorting)**

- **병합 정렬(Merge Sort)**: 데이터를 정렬할 때 사용되는 대표적인 분할 정복 알고리즘
- **퀵 정렬(Quick Sort)**: 피벗을 기준으로 배열을 나누고 정렬하는 방식

### **2. 탐색 문제 (Searching)**

- **이진 탐색(Binary Search)**: 정렬된 배열에서 특정 값을 찾을 때, 탐색 범위를 절반으로 줄여가는 방식

### **3. 행렬 연산(Matrix Multiplication)**

- **스트라센 알고리즘(Strassen’s Algorithm)**: 행렬 곱셈을 더 빠르게 수행하기 위한 알고리즘

### **4. 그래프 알고리즘**

- **최소 비용 신장 트리(Minimum Spanning Tree) - 크루스칼 알고리즘**: 분할 정복을 활용하여 최소 비용 신장 트리 찾기

### **5. 최근접 쌍 문제 (Closest Pair of Points)**

- **평면상의 점들 중에서 가장 가까운 두 점을 찾는 문제**에서 분할 정복을 활용

---

## **6. 분할 정복 알고리즘의 장단점**

### **장점**

- **효율적인 시간 복잡도**: O(N log N) 혹은 그 이상의 성능을 보이는 경우가 많음.
- **재귀를 활용한 직관적인 문제 해결**: 문제를 단계별로 나누어 해결할 수 있음.
- **병렬 처리 가능성**: 독립적인 하위 문제들을 동시에 처리할 수 있어 병렬 처리에 적합함.

### **단점**

- **추가적인 메모리 사용**: 병합 정렬과 같은 경우 추가적인 공간이 필요할 수 있음.
- **재귀 호출에 따른 오버헤드**: 함수 호출이 많아지면 오버헤드가 증가할 수 있음.
- **적용 가능한 문제의 제한**: 모든 문제에 적용할 수 있는 것은 아니며, 특정 문제 유형에 적합함.

---

- 참고 문헌

[분할 정복(Divide and Conquer) 알고리즘 총 정리 - 개념, 원리, 동작예시, 장단점, 시간복잡도, C언어, Java, Python 예시코드](https://best-coding.tistory.com/88)