package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1005 {

    public static int[] dp, times;
    public static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n, k, dest, start, i, z, end;
        int[] enterCnt;
        StringTokenizer st;

        for (z = 0; z < t; z++) {
            st = new StringTokenizer(br.readLine());

            // 건물 총 개수
            n = Integer.parseInt(st.nextToken());
            // 규칙 개수
            k = Integer.parseInt(st.nextToken());

            dp = new int[n + 1];
            Arrays.fill(dp, Integer.MIN_VALUE);

            times = new int[n + 1];
            enterCnt = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (i = 1; i <= n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList<>();
            for (i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());

                graph.get(start).add(end);
                enterCnt[end]++;
            }

            dest = Integer.parseInt(br.readLine());

            Deque<Integer> d = new LinkedList<>();
            for (i = 1; i <= n; i++) {
                if (enterCnt[i] == 0) {
                    dp[i] = times[i];
                    d.offer(i);
                }
            }

            while (!d.isEmpty()) {
                for (i = 0; i < d.size(); i++) {
                    int cur = d.pollFirst();
                    for (int target : graph.get(cur)) {
                        dp[target] = Math.max(dp[target], dp[cur] + times[target]);
                        enterCnt[target]--;
                        if (enterCnt[target] == 0) {
                            d.offer(target);
                        }
                    }
                }
            }

            System.out.println(dp[dest]);
        }
    }
}
