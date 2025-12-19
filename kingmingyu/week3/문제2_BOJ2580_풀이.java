package kingmingyu.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제2_BOJ2580_풀이 {
    static int[][] sudo = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < 9; j++){
                sudo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }
    public static boolean isTrue(int r, int c, int value){
        //세로 줄 확인
        for(int i = 0; i < 9; i++){
            if(sudo[i][c] == value){
                return false;
            }
        }

        //가로 줄 확인
        for(int i = 0; i < 9; i++){
            if(sudo[r][i] == value){
                return false;
            }
        }

        //같은 칸 확인
        int cellR = (r / 3) * 3;
        int cellC = (c / 3) * 3;
        for(int i = cellR; i < cellR + 3; i ++){
            for(int j = cellC; j < cellC + 3; j++){
                if(sudo[i][j] == value){
                    return false;
                }
            }
        }

        return true;
    }

    public static void dfs(int r, int c){
        if(c == 9){
            dfs(r + 1, 0);
            return;
        }

        if(r == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(sudo[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0); //가장 처음 답만 찾고 종료
        }

        //0이 아닌 경우는 pass
        if (sudo[r][c] != 0) {
            dfs(r, c + 1);
            return;
        }

        //0인 경우 채울 수 있는 값을 찾아 채우고 넘어가기
        for(int i = 0; i < 9; i++){
            if(isTrue(r, c, i + 1)){
                sudo[r][c] = i + 1;
                dfs(r, c+1);
            }
        }

        sudo[r][c] = 0;
    }
}
