package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1326 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stones = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        Deque<Integer> d = new LinkedList<>();
        dp[start] = 0;
        d.add(start);

        while (!d.isEmpty()) {
            int cur = d.pollFirst();
            for (int next = cur - stones[cur]; next > 0; next -= stones[cur]) {
                if (dp[next] == -1) {
                    dp[next] = dp[cur] + 1;
                    d.addLast(next);
                }
            }

            for (int next = cur + stones[cur]; next <= n; next += stones[cur]) {
                if (dp[next] == -1) {
                    dp[next] = dp[cur] + 1;
                    d.addLast(next);
                }
            }
        }

        System.out.println(dp[end]);
    }
}
