package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ14502 {

    static int n, m, totalCnt, maxSafetyArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<Integer> virus = new ArrayList<>();
        List<Integer> roads = new ArrayList<>();

        totalCnt = n * m - 3;

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    totalCnt--;
                }
                if (arr[i][j] == 0) {
                    roads.add(locToNum(i, j));
                }

                if (arr[i][j] == 2) {
                    virus.add(locToNum(i, j));
                }
            }
        }

        int roadLen = roads.size();
        for (int i = 0; i < roadLen; i++) {
            for (int j = i + 1; j < roadLen; j++) {
                for (int z = j + 1; z < roadLen; z++) {
                    calculateSafetyArea(virus, Set.of(roads.get(i), roads.get(j), roads.get(z)),
                        arr);
                }
            }
        }

        System.out.println(maxSafetyArea);
    }

    private static void calculateSafetyArea(final List<Integer> virus, final Set<Integer> plusRoads,
        final int[][] board) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        Deque<Integer> d = new LinkedList<>(virus);
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = numToLoc(d.pollFirst());
                int r = cur[0];
                int c = cur[1];
                cnt++;

                for (int j = 0; j < dx.length; j++) {
                    int curR = r + dx[j];
                    int curC = c + dy[j];

                    if (!isValid(visited, curR, curC, board, plusRoads)) {
                        continue;
                    }

                    visited[curR][curC] = true;
                    d.offerLast(locToNum(curR, curC));
                }
            }
        }
        maxSafetyArea = Math.max(maxSafetyArea, totalCnt - cnt);
    }

    private static boolean isValid(final boolean[][] visited, final int curR, final int curC,
        final int[][] board,
        final Set<Integer> plusRoads) {
        return curR >= 0 && curR < n && curC >= 0 && curC < m && !visited[curR][curC]
            && board[curR][curC] == 0
            && !plusRoads.contains(locToNum(curR, curC));
    }

    private static int locToNum(final int r, final int c) {
        return r * m + c;
    }

    private static int[] numToLoc(final int num) {
        return new int[]{num / m, num % m};
    }
}
