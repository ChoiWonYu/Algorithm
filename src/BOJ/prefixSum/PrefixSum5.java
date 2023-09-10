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
        int i,j,x1,y1,x2,y2,sum,num;

        for ( i = 1; i <= n; i++) {
            st=new StringTokenizer(br.readLine());
            for ( j = 1; j <= n; j++) {
                num=Integer.parseInt(st.nextToken());
                numArr[i][j]=num+numArr[i-1][j]+numArr[i][j-1]-numArr[i-1][j-1];
            }
        }

        for ( i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());

            sum=numArr[x2][y2]-numArr[x1-1][y2]-numArr[x2][y1-1]+numArr[x1-1][y1-1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
