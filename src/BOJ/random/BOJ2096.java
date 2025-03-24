package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] minDp = new int[3];
        int[] maxDp = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                minDp[0] = maxDp[0] = n1;
                minDp[1] = maxDp[1] = n2;
                minDp[2] = maxDp[2] = n3;
            } else {
                // max
                int prevMax1 = maxDp[0];
                int prevMax3 = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + n1;
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + n3;
                maxDp[1] = Math.max(maxDp[1], Math.max(prevMax1, prevMax3)) + n2;

                // min
                int prevMin1 = minDp[0];
                int prevMin3 = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + n1;
                minDp[2] = Math.min(minDp[1], minDp[2]) + n3;
                minDp[1] = Math.min(minDp[1], Math.min(prevMin1, prevMin3)) + n2;
            }
        }

        int minResult = Integer.MAX_VALUE;
        int maxResult = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            minResult = Math.min(minResult, minDp[i]);
            maxResult = Math.max(maxResult, maxDp[i]);
        }

        System.out.println(maxResult + " " + minResult);

        br.close();
    }
}
