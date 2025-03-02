package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], -1);
            graph[i][i] = 0;
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[p1][p2] = dist;
            graph[p2][p1] = dist;
        }

        Deque<int[]> d = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        for (int z = 0; z < m; z++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            d.add(new int[]{start, 0});
            visited[start] = true;

            while (!d.isEmpty()) {
                int len = d.size();
                for (int i = 0; i < len; i++) {
                    int[] curArr = d.pollFirst();
                    int cur = curArr[0];
                    int curDist = curArr[1];
                    if (cur == end) {
                        sb.append(curDist).append("\n");
                        d.clear();
                        Arrays.fill(visited, false);
                        break;
                    }

                    for (int j = 1; j <= n; j++) {
                        if (graph[cur][j] != -1 && !visited[j]) {
                            visited[j] = true;
                            d.add(new int[]{j, curDist + graph[cur][j]});
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }

}
