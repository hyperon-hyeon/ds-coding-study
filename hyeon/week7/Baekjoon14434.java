import java.io.*;
import java.util.*;

public class Baekjoon14434 {
    static List<Integer>[] growthDays;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] limits = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            limits[i] = Integer.parseInt(st.nextToken());
        }

        growthDays = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            growthDays[i] = new ArrayList<>();
        }
        
        st = new StringTokenizer(br.readLine());
        for (int d = 1; d <= K; d++) {
            int grownChild = Integer.parseInt(st.nextToken());
            growthDays[grownChild].add(d); 
        }

        int[] differenceArray = new int[K + 2];
        
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int requiredLimit = limits[k];

            int minDay = findMinDay(i, j, requiredLimit, K);

            if (minDay != 0) {
                differenceArray[minDay]++;
                differenceArray[K + 1]--;
            }
        }
        
        int currentRides = 0;
        StringBuilder sb = new StringBuilder();
        for (int d = 1; d <= K; d++) {
            currentRides += differenceArray[d];
            sb.append(currentRides).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static int findMinDay(int i, int j, int requiredLimit, int K) {
        int left = 1;
        int right = K;
        int minDay = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int heightI = getGrowthCount(i, mid);
            int heightJ = getGrowthCount(j, mid);
            int currentSum = heightI + heightJ;
            
            if (currentSum >= requiredLimit) {
                minDay = mid; 
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        return minDay;
    }

    public static int getGrowthCount(int childIndex, int midDay) {
        List<Integer> days = growthDays[childIndex];
        int low = 0;
        int high = days.size() - 1;
        int count = 0; 
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (days.get(mid) <= midDay) {
                count = mid + 1; 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }
}