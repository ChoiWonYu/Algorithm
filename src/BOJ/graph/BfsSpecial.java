package BOJ.graph;

import java.util.*;
import java.io.*;

public class BfsSpecial {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
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

        Deque<Integer> answer = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            answer.add(Integer.parseInt(st.nextToken()));
        }

        if (answer.pollFirst() != 1) {
            System.out.println(0);
            return;
        }

        Deque<Integer> d = new LinkedList<>();
        visited[1] = true;
        d.add(1);
        while (!answer.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.pollFirst();
                List<Integer> curList = graph.get(cur);
                Set<Integer> s = new HashSet<>();

                for (int j = 0; j < curList.size(); j++) {
                    int target = curList.get(j);
                    if (visited[target]) {
                        continue;
                    }
                    visited[target] = true;
                    s.add(target);
                }

                while (!s.isEmpty()) {
                    int target = answer.pollFirst();
                    if (!s.contains(target)) {
                        System.out.println(0);
                        return;
                    }
                    s.remove(target);
                    d.add(target);
                }
            }
        }

        System.out.println(1);
    }
}
