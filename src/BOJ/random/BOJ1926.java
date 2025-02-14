package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1926 {

    public static int n, m;
    public static int[][] picture;
    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picture = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCnt = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 1) {
                    max = Math.max(max, bfs(i, j));
                    pictureCnt++;
                }
            }
        }

        System.out.println(pictureCnt);
        System.out.println(max);
    }

    public static int bfs(int r, int c) {
        Deque<int[]> d = new LinkedList<>();
        d.add(new int[]{r, c});
        picture[r][c] = 0;
        int cnt = 0;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.pollFirst();
                cnt++;
                for (int j = 0; j < 4; j++) {
                    int nextR = cur[0] + dx[j];
                    int nextC = cur[1] + dy[j];

                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m
                        && picture[nextR][nextC] == 1) {
                        picture[nextR][nextC] = 0;
                        d.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
        return cnt;
    }

}
