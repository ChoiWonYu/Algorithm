package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ5567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        Deque<Integer> d = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        ;
        d.add(1);
        set.add(1);
        int depth = 0;
        while (!d.isEmpty() && depth < 2) {
            int len = d.size();
            depth++;
            for (int i = 0; i < len; i++) {
                int cur = d.pollFirst();
                for (int j : graph.get(cur)) {
                    if (set.contains(j)) {
                        continue;
                    }
                    set.add(j);
                    d.addLast(j);
                }
            }
        }

        System.out.println(set.size() - 1);
    }
}
