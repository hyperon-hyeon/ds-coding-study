import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1966 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int totalNum = Integer.parseInt(br.readLine());

        for(int j=0;j<totalNum;j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int docNum = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()); 
            Queue<int[]> printer = new LinkedList<>();
            for(int i=0;i<docNum;i++){
                printer.add(new int[]{Integer.parseInt(st.nextToken()), i});
            }
            
            int count = 0;

            while(true){  
                int[] current = printer.poll();
                boolean moreBigger = false;

                for(int[] doc : printer){
                    if(doc[0] > current[0]){
                        moreBigger = true;
                        break;
                    }
                }

                if(moreBigger){
                    printer.add(current);
                } else {
                    count++;
                    if(current[1] == num){
                        bw.write(count + "\n");
                        break;  
                    }
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}