package BOJ.recursion;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class LinkStart {

    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0);

        System.out.println(result);
    }

    private static void recursion(final int index) {

        if (result == 0) {
            return;
        }

        if (index == n) {
            int cur = 0;
            int opposite = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] != visited[j]) {
                        continue;
                    }

                    if (visited[i]) {
                        cur += graph[j][i];
                    } else {
                        opposite += graph[j][i];
                    }
                }
            }
            result = Math.min(Math.abs(opposite - cur), result);
            return;
//            StringBuilder sb = new StringBuilder();
//            IntStream.range(0, n)
//                .filter(num -> visited[num])
//                .forEach(num -> sb.append(num + 1));
//
//            System.out.println(sb);
//            return;
        }

        visited[index] = true;
        recursion(index + 1);
        visited[index] = false;
        recursion(index + 1);
    }
}

