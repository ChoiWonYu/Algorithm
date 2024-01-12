package BOJ.graph;

import java.io.*;
import java.util.*;

public class Connected {

    static boolean[][] graph;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        int result = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            graph[p1][p2] = true;
            graph[p2][p1] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            result++;
            visited[i] = true;
            dfs(i);
        }

        System.out.println(result);
    }

    private static void dfs(final int num) {
        for (int i = 1; i <= n; i++) {
            if (graph[num][i] && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

}
