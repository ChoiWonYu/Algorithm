package BOJ.prefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RemainderSum {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i,remainder;

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        long count=0;

        long[] numArr=new long[n+1];
        long[] remainderArr = new long[m];

        long sum=0;

        st = new StringTokenizer(br.readLine());
        for ( i = 1; i <= n; i++) {
            sum+=Long.parseLong(st.nextToken());
            numArr[i]=sum;
        }

        for ( i = 1; i <= n; i++) {
             remainder=(int)(numArr[i]%m);
            if(remainder==0)count++;
            remainderArr[remainder]++;
        }

        for ( i = 0; i < m; i++) {
            if(remainderArr[i]>1){
                count+=(remainderArr[i]*(remainderArr[i]-1))/2;
            }
        }

        System.out.println(count);
    }
}
