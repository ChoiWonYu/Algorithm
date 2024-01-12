package BOJ.graph;

import java.util.*;
import java.io.*;

public class ABCDE {

    static int n, m;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n];

        Deque<Integer> d = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            d.add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            recursion(i, 1);
            visited[i] = false;
        }

        System.out.println(0);
    }

    private static void recursion(final int idx, final int cnt) {
        if (cnt == 5) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 0; i < graph.get(idx).size(); i++) {
            int target = graph.get(idx).get(i);
            if (visited[target]) {
                continue;
            }
            visited[target] = true;
            recursion(target, cnt + 1);
            visited[target] = false;
        }
    }

}
