package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r][c];
        int[] blocks = new int[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < c; i++) {
            int cnt = blocks[i];
            for (int j = 0; j < cnt; j++) {
                arr[j][i] = 1;
            }
        }

        int rp, lp = -1;
        int sum = 0;
        for (int t = 0; t < r; t++) {
            for (rp = 0; rp < c; rp++) {
                int cur = arr[t][rp];
                if (cur == 0) {
                    continue;
                }
                if (lp == -1) {
                    lp = rp;
                    continue;
                }

                if(rp - lp <= 1){
                    lp = rp;
                }else{
                    sum += (rp - lp - 1);
                    lp = rp;
                }
            }
        }

        System.out.println(sum);
    }
}
