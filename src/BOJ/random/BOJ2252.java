package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] degree = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            degree[b]++;
            graph.get(a).add(b);
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                deque.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int a = deque.poll();
            sb.append(a).append(" ");
            for (int next : graph.get(a)) {
                degree[next]--;
                if (degree[next] == 0) {
                    deque.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}
