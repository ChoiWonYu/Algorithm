package BOJ.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MaxHeap {
    public static void main(String[] args)throws Exception{
        PriorityQueue<Integer>maxH=new PriorityQueue<Integer>(Collections.reverseOrder());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                int printNum;
                if(maxH.isEmpty())printNum=0;
                else printNum=maxH.poll();
                System.out.println(printNum);
            }
            else{
                maxH.add(num);
            }
        }
    }
}
