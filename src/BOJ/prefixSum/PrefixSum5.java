package BOJ.prefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PrefixSum5 {

    public static void main(String[] args)throws Exception {
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] numArr=new int[n+1][n+1];
        int i,j,x1,y1,x2,y2,sum;

        for ( i = 1; i <= n; i++) {
            sum=0;
            st=new StringTokenizer(br.readLine());
            for ( j = 1; j <= n; j++) {
                sum+=Integer.parseInt(st.nextToken());
                numArr[i][j]=sum;
            }
        }

        for ( i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());

            sum=0;

            for (j = x1; j <= x2; j++) {
                sum+=numArr[j][y2]-numArr[j][y1-1];
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
