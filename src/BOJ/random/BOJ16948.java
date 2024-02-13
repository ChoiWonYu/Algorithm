package BOJ.random;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ16948 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dr = new int[]{-2, -2, 0, 0, 2, 2};
        int[] dc = new int[]{-1, 1, -2, 2, -1, 1};

        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());

        int endR = Integer.parseInt(st.nextToken());
        int endC = Integer.parseInt(st.nextToken());

        Deque<int[]> d = new LinkedList<>();
        int cnt = 0;
        d.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.poll();
                int curR = cur[0];
                int curC = cur[1];
                if (curR == endR && curC == endC) {
                    System.out.println(cnt);
                    return;
                }
                for (int j = 0; j < dr.length; j++) {
                    int nextR = curR + dr[j];
                    int nextC = curC + dc[j];

                    if (!isValid(nextR, nextC, visited)) {
                        continue;
                    }

                    visited[nextR][nextC] = true;
                    d.add(new int[]{nextR, nextC});
                }
            }
            cnt++;
        }

        System.out.println(-1);
    }

    private static boolean isValid(final int nextR, final int nextC, final boolean[][] visited) {
        return nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC];
    }

}
