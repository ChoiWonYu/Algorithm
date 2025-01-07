package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1707 {

    public static int[] colors;
    public static List<List<Integer>> graph;
    public static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n, m, n1, n2;
        StringTokenizer st;
        for (int z = 0; z < t; z++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            answer = true;
            graph = new ArrayList<>();
            colors = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                n1 = Integer.parseInt(st.nextToken());
                n2 = Integer.parseInt(st.nextToken());

                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            for (int i = 1; i <= n; i++) {
                if (colors[i] == 0) {
                    dfs(i, 1);
                }
            }
            System.out.println(answer ? "YES" : "NO");
        }
    }

    public static void dfs(int num, int color) {
        if (!answer) {
            return;
        }
        colors[num] = color;
        for (int n : graph.get(num)) {
            if (colors[n] == color) {
                answer = false;
                return;
            }

            if (colors[n] == 0) {
                dfs(n, -color);
            }
        }
    }
}
