package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s, e;
        List<int[]> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            list.add(new int[]{s, e});
        }

        list.sort((a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int[] cur = list.get(i);
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                int[] some = list.get(j);
                if (cur[0] > some[0] && cur[1] > some[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(n - answer);
    }
}
