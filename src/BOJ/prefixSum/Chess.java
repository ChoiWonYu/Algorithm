package BOJ.prefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chess {

    public static void main(String[] args)throws Exception {
        int n,m,k,i,j,firstX,firstY,cnt,minCnt=Integer.MAX_VALUE;
        char[] input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
         n=Integer.parseInt(st.nextToken());
         m=Integer.parseInt(st.nextToken());
         k=Integer.parseInt(st.nextToken());

        int[][]bCntBoard=new int[n+1][m+1];
        int[][]wCntBoard=new int[n+1][m+1];
        int bCnt,wCnt;
        boolean colorFlag;

        for (i = 1; i <= n; i++) {
            input = br.readLine().toCharArray();
            bCnt=0;
            wCnt=0;

            colorFlag= i % 2 != 0;

            for (j = 1; j <= m; j++) {
                if(colorFlag){
                    if(input[j-1]=='W')bCnt=1;
                    else wCnt=1;
                }

                if(!colorFlag) {
                    if(input[j-1]=='B')bCnt=1;
                    else wCnt=1;
                }

                bCntBoard[i][j]=bCnt+bCntBoard[i-1][j]+bCntBoard[i][j-1]-bCntBoard[i-1][j-1];
                wCntBoard[i][j]=wCnt+wCntBoard[i-1][j]+wCntBoard[i][j-1]-wCntBoard[i-1][j-1];

                colorFlag=!colorFlag;
                bCnt=0;
                wCnt=0;
            }
        }

        firstX=n-k+1;
        firstY=m-k+1;

//        if (firstX >= n || firstY >= m) {
//            System.out.println(0);
//            return;
//        }

        for (i = 1; i <= firstX; i++) {
            for (j = 1; j <= firstY; j++) {
                cnt= Math.min(getCnt(bCntBoard,i,j,i+k-1,j+k-1),getCnt(wCntBoard,i,j,i+k-1,j+k-1));
                minCnt = Math.min(minCnt, cnt);
            }
        }

        System.out.println(minCnt);
    }

    private static int getCnt(int[][] arr,int x1,int y1,int x2, int y2) {
        return arr[x2][y2]-arr[x1-1][y2]-arr[x2][y1-1]+arr[x1-1][y1-1];
    }


}
