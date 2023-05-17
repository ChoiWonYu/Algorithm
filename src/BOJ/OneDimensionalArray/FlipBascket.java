package BOJ.OneDimensionalArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlipBascket {

    public static void swap(int[] numArray,int rIdx,int lIdx){
        int storeValue=numArray[rIdx];
        numArray[rIdx]=numArray[lIdx];
        numArray[lIdx]=storeValue;
    }
    public static void revertArray(int[] numArray,int rIdx,int lIdx){
        int tmp=0;
        while(rIdx<lIdx){
            swap(numArray,rIdx,lIdx);
            rIdx++;
            lIdx--;
        }
    }



    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] numArray=new int[N];
        for(int i=0;i<N;i++)numArray[i]=i+1;

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());

            int rIdx=Integer.parseInt(st.nextToken())-1;
            int lIdx=Integer.parseInt(st.nextToken())-1;

            revertArray(numArray,rIdx,lIdx);
        }

        for(int n:numArray){
            sb.append(n).append(' ');
        }

        System.out.println(sb.toString());

    }
}
