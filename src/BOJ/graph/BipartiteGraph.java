package BOJ.graph;

import java.io.*;
import java.util.*;

public class BipartiteGraph {

    static boolean flag = false;
    static List<List<Integer>> graph;
    static int v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        for (int t = 0; t < k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            flag = false;
            for (int i = 0; i < e; i++) {

                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }

            int[] color = new int[v + 1];

            Deque<Integer> d = new LinkedList<>();
            for (int i = 1; i <= v; i++) {
                if (color[i] != 0) {
                    continue;
                }
                color[i] = 1;
                d.add(i);
                while (!d.isEmpty() && !flag) {
                    int cur = d.poll();
                    for (int j = 0; j < graph.get(cur).size(); j++) {
                        int target = graph.get(cur).get(j);
                        if (color[cur] == color[target]) {
                            flag = true;
                            break;
                        }

                        if (color[target] == 0) {
                            color[target] = color[cur] * -1;
                            d.add(target);
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
            String answer = flag ? "NO" : "YES";

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
