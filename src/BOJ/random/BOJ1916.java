package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[]{e, c});
        }

        st = new StringTokenizer(br.readLine());
        int rs = Integer.parseInt(st.nextToken());
        int re = Integer.parseInt(st.nextToken());

        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[rs] = 0;

        PriorityQueue<int[]> d = new PriorityQueue<>((a,b)->a[1] - b[1]);
        d.add(new int[]{rs, 0});

        while (!d.isEmpty()) {
            int[] curArr = d.poll();
            int cur = curArr[0];
            long curCost = curArr[1];
            if (curCost > dp[cur]) {
                continue;
            }
            for (int[] nextArr : graph.get(cur)) {
                int next = nextArr[0];
                int nextCost = nextArr[1];
                if (dp[next] > dp[cur] + nextCost) {
                    dp[next] = dp[cur] + nextCost;
                    d.offer(nextArr);
                }
            }
        }

        System.out.println(dp[re]);
    }

}
