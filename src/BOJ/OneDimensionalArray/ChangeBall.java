package BOJ.OneDimensionalArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChangeBall {
    public static void swap(int[] array,int rIdx,int lIdx){
        int storeValue=array[rIdx];
        array[rIdx]=array[lIdx];
        array[lIdx]=storeValue;
    }


    public static void main(String[] args)throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numArray = new int[N];

        for (int i = 0; i < N; i++) numArray[i] = i+1;

        for( int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int rIdx = Integer.parseInt(st.nextToken())-1;
            int lIdx = Integer.parseInt(st.nextToken())-1;
            swap(numArray,rIdx,lIdx);
        }

        for(int num:numArray){
            sb.append(num).append(' ');
        }

        System.out.println(sb.toString());
    }
}
