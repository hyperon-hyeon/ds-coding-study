import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int left = 1; 
        int right = houses[N - 1] - houses[0];
        
        int maxMinDistance = 0; 
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (canInstall(houses, mid, C)) {
                maxMinDistance = mid; 
                left = mid + 1;      
            } else {
                right = mid - 1;  
            }
        }

        System.out.println(maxMinDistance);
    }

    public static boolean canInstall(int[] houses, int distance, int C) {
        int count = 1;
        int lastInstall = houses[0]; 
        for (int i = 1; i < houses.length; i++) {
            int currentHouse = houses[i];
            
            if (currentHouse - lastInstall >= distance) {
                count++;
                lastInstall = currentHouse; 
            }
        }
        
        return count >= C;
    }
}