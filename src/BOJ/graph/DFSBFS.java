package BOJ.graph;

import java.util.*;
import java.io.*;

public class DFSBFS {

    static int n, m, v;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited[v] = true;
        dfs(v);
        sb.append("\n");

        visited = new boolean[n + 1];

        Deque<Integer> d = new LinkedList<>();
        visited[v] = true;
        d.add(v);
        while (!d.isEmpty()) {
            int cur = d.poll();
            sb.append(cur).append(" ");
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int target = graph.get(cur).get(i);
                if (visited[target]) {
                    continue;
                }
                d.add(target);
                visited[target] = true;
            }
        }

        System.out.println(sb);
    }

    private static void dfs(final int num) {
        sb.append(num).append(" ");

        for (int i = 0; i < graph.get(num).size(); i++) {
            int target = graph.get(num).get(i);
            if (visited[target]) {
                continue;
            }
            visited[target] = true;
            dfs(target);
        }
    }

}
