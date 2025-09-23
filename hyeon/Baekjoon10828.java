import java.io.*;

public class Baekjoon10828{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int num = Integer.parseInt(bf.readLine());
        int array[]=new int[num];
        int top=-1;

        for(int i=0;i<num;i++){
            String str = bf.readLine();
            String arr[]=str.split(" ");

            if(arr[0].equals("push")){
                int x = Integer.parseInt(arr[1]);
                top++;
                array[top]=x;                
            }
            else if(arr[0].equals("pop")){
                if(top!=-1){
                    bw.write(array[top]+"\n");
                    array[top]=0;
                    top--;
                }
                else{
                    bw.write(-1+"\n");
                }
            }
            else if(arr[0].equals("size")){
                bw.write((top+1)+"\n");
            }
            else if(arr[0].equals("empty")){
                if(top==-1){
                    bw.write(1+"\n");
                }
                else{
                    bw.write(0+"\n");
                }
            }
            else if(arr[0].equals("top")){
                if(top==-1){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(array[top]+"\n");
                }
            }
        }



        bw.flush();
        bw.close();
    }
}
