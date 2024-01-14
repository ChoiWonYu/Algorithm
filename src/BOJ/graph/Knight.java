package BOJ.graph;

import java.io.*;
import java.util.*;

public class Knight {

    static int I;
    static int[] startP, endP;
    static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            I = Integer.parseInt(br.readLine());
            board = new int[I][I];
            visited = new boolean[I][I];
            st = new StringTokenizer(br.readLine());
            startP = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            endP = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            int minMove = calculateMinMove();
            sb.append(minMove).append("\n");
        }
        System.out.println(sb);
    }

    private static int calculateMinMove() {
        Deque<int[]> d = new LinkedList<>();
        d.add(startP);
        int moveCnt = 0;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.poll();
                if (cur[0] == endP[0] && cur[1] == endP[1]) {
                    return moveCnt;
                }
                for (int j = 0; j < dx.length; j++) {
                    int curX = cur[0] + dx[j];
                    int curY = cur[1] + dy[j];

                    if (!isValid(curX, curY)) {
                        continue;
                    }

                    visited[curX][curY] = true;
                    d.add(new int[]{curX, curY});
                }
            }
            moveCnt++;
        }
        return moveCnt;
    }

    private static boolean isValid(final int x, final int y) {
        return x >= 0 && y >= 0 && x < I && y < I && !visited[x][y];
    }

}
