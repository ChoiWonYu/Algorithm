package BOJ.graph;

import java.io.*;
import java.util.*;

public class DfsSpecial {

    static boolean[] visited;
    static List<List<Integer>> graph;
    static Deque<Integer> answer = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(st.nextToken());
            answer.add(target);
        }

        if (answer.pollFirst() != 1) {
            System.out.println(0);
            return;
        }
        dfs(1, 1);

        System.out.println(1);
    }

    private static void dfs(final int num, final int parent) {
        if (answer.isEmpty() || visited[num]) {
            return;
        }

        visited[num] = true;
        Set<Integer> s = new HashSet<>();
        for (int n : graph.get(num)) {
            if (n != parent) {
                s.add(n);
            }
        }

        while (!s.isEmpty()) {
            int target = answer.pollFirst();
            if (!s.contains(target)) {
                System.out.println(0);
                System.exit(0);
            }
            s.remove(target);
            dfs(target, num);
        }
    }

}
