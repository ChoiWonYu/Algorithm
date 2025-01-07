package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13023 {

    public static boolean answer = false;
    public static boolean[] visited;
    public static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
            if (answer) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(answer ? 1 : 0);
    }

    public static void dfs(int n, int depth) {
        if (answer) {
            return;
        }
        if (depth == 5) {
            answer = true;
            return;
        }

        for (int num : graph.get(n)) {
            if (visited[num]) {
                continue;
            }
            visited[num] = true;
            dfs(num, depth + 1);
            visited[num] = false;}

    }
}
