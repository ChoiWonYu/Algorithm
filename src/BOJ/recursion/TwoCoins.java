package BOJ.recursion;

import java.io.*;
import java.util.*;

public class TwoCoins {

    static int n, m;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        //동전 : 1, 빈 칸 : 0, 벽 : -1

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<int[]> loc = new ArrayList<>();
        visited = new boolean[n][m][n][m];
        int board[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char target = input.charAt(j);
                if (target == 'o') {
                    board[i][j] = 1;
                    loc.add(new int[]{i, j});
                } else if (target == '#') {
                    board[i][j] = -1;
                } else {
                    board[i][j] = 0;
                }
            }
        }

        Deque<int[]> d = new LinkedList<>();
        int[] firstCoins = new int[]{loc.get(0)[0], loc.get(0)[1], loc.get(1)[0], loc.get(1)[1]};
        d.add(firstCoins);

        int cnt = 1;
        int coinR1, coinC1, coinR2, coinC2, nextR1, nextC1, nextR2, nextC2;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.poll();
                coinR1 = cur[0];
                coinC1 = cur[1];
                coinR2 = cur[2];
                coinC2 = cur[3];

                for (int j = 0; j < dx.length; j++) {
                    nextR1 = coinR1 + dx[j];
                    nextC1 = coinC1 + dy[j];
                    nextR2 = coinR2 + dx[j];
                    nextC2 = coinC2 + dy[j];

                    if (isValid(nextR1, nextC1) && board[nextR1][nextC1] == -1) {
                        nextR1 = coinR1;
                        nextC1 = coinC1;
                    }

                    if (isValid(nextR2, nextC2) && board[nextR2][nextC2] == -1) {
                        nextR2 = coinR2;
                        nextC2 = coinC2;
                    }

                    if (nextR1 == nextR2 && nextC1 == nextC2) {
                        continue;
                    }

                    if (!isValid(nextR1, nextC1) && !isValid(nextR2, nextC2)) {
                        continue;
                    }

                    if ((!isValid(nextR1, nextC1) && isValid(nextR2, nextC2)) || (
                        isValid(nextR1, nextC1) && !isValid(nextR2, nextC2))) {
                        System.out.println(cnt);
                        return;
                    }

                    if (visited[nextR1][nextC1][nextR2][nextC2]) {
                        continue;
                    }

                    visited[nextR1][nextC1][nextR2][nextC2] = true;
                    d.add(new int[]{nextR1, nextC1, nextR2, nextC2});
                }
            }
            cnt++;
            if (cnt > 10) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(-1);
    }

    private static boolean isValid(final int r, final int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }


}
