package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ24479 {

    static List<PriorityQueue<Integer>> graph;
    static boolean[] visited;
    static int[] answer;
    static int order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        answer = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new PriorityQueue<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        order = 1;
        visited[start] = true;
        answer[start] = order++;

        dfs(start);
        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int num) {
        while (!graph.get(num).isEmpty()) {
            int next = graph.get(num).poll();
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            answer[next] = order++;
            dfs(next);
        }
    }
}
