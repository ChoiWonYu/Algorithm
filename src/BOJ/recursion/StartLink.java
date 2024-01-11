package BOJ.recursion;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class StartLink {

    static int[] nums;
    static int[][] graph;
    static boolean[] visited;
    static int n, result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nums = new int[n];
        visited = new boolean[n];

        recursion(0, 0);

        System.out.println(result);
    }

    private static void recursion(final int index, final int cnt) {

        if (result == 0) {
            return;
        }

        if (index == n && cnt == n / 2) {
            int start = 0;
            int link = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] != visited[j]) {
                        continue;
                    }

                    if (visited[i]) {
                        start += graph[j][i];
                    } else {
                        link += graph[i][j];
                    }
                }

            }
            result = Math.min(result, Math.abs(start - link));
            return;
//
//            StringBuilder sb = new StringBuilder();
//            IntStream.range(0, n)
//                .filter(num -> visited[num])
//                .forEach(num -> sb.append(num + 1));
//
//            System.out.println(sb);
//            return;
        }

        if (index >= n) {
            return;
        }

        visited[index] = true;
        recursion(index + 1, cnt + 1);
        visited[index] = false;
        recursion(index + 1, cnt);
    }
}



