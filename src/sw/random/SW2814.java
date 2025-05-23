package sw.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SW2814 {

    static int answer;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            answer = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            visited = new boolean[n + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }

            for (int i = 1; i <= n; i++) {
                Arrays.fill(visited, false);
                visited[i] = true;
                dfs(i, 1);
            }

            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }

    public static void dfs(int cur, int len) {
        answer = Math.max(answer, len);
        for (int n : graph.get(cur)) {
            if (visited[n]) {
                continue;
            }
            visited[n] = true;
            dfs(n, len + 1);
            visited[n] = false;
        }
    }
}
