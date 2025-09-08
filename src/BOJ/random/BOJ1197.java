package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, p});
            graph.get(b).add(new int[]{a, p});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n + 1];

        pq.offer(new int[]{1, 0});
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int to = cur[0];
            int price = cur[1];

            if (visited[to]) {
                continue;
            }
            sum += price;
            visited[to] = true;

            for (int[] next : graph.get(to)) {
                if (visited[next[0]]) {
                    continue;
                }
                pq.offer(new int[]{next[0], next[1]});
            }
        }
        System.out.println(sum);
    }
}
