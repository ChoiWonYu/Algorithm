package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] heights = new int[257];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                heights[h]++;
                max = Math.max(max, h);
                min = Math.min(min, h);
            }
        }

        int[] ans = new int[]{Integer.MAX_VALUE, 0};
        for (int i = min; i <= max; i++) {
            int remain = b;
            int time = 0;
            for (int j = min; j <= max; j++) {
                if (heights[j] == 0) {
                    continue;
                }

                if (i < j) {
                    time += 2 * heights[j] * (j - i);
                    remain += heights[j] * (j - i);
                } else {
                    time += heights[j] * (i - j);
                    remain -= heights[j] * (i - j);
                }
            }
            if (remain < 0) {
                break;
            }
            if (time <= ans[0]) {
                ans[0] = time;
                ans[1] = i;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
