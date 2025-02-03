package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1389 {

    public static int n, m;
    public static int[] dp;
    public static List<Set<Integer>> graph = new ArrayList<>();
    public static Deque<Integer> d = new LinkedList<>();
    public static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        int num = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            int kevinNum = getKevinNum(i);
            if (kevinNum < num) {
                num = kevinNum;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    private static int getKevinNum(final int start) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        dp[start] = 0;
        visited[start] = true;
        d.add(start);
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.pollFirst();
                for (int friend : graph.get(cur)) {
                    if (visited[friend]) {
                        continue;
                    }
                    visited[friend] = true;
                    dp[friend] = dp[cur] + 1;
                    d.add(friend);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dp[i];
        }

        return sum;
    }

}
