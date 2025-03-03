package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1245 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> d = new LinkedList<>();
        int[][] height = new int[n][m];

        int[] dr = new int[]{-1,-1,-1, 0, 0, 1, 1, 1};
        int[] dc = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || height[i][j] == 0) {
                    continue;
                }

                int h = height[i][j];
                visited[i][j] = true;
                d.add(new int[]{i, j});
                boolean isMax = true;

                while (!d.isEmpty()) {
                    int len = d.size();
                    for (int p = 0; p < len; p++) {
                        int[] cur = d.pollFirst();
                        int curR = cur[0];
                        int curC = cur[1];
                        for (int q = 0; q < dr.length; q++) {
                            int nextR = curR + dr[q];
                            int nextC = curC + dc[q];
                            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || height[nextR][nextC] == 0) {
                                continue;
                            }
                            int nextH = height[nextR][nextC];
                            if (nextH > h) {
                                isMax = false;
                            }
                            if (!visited[nextR][nextC] && nextH == h) {
                                d.add(new int[]{nextR, nextC});
                                visited[nextR][nextC] = true;
                            }
                        }
                    }
                }
                if (isMax) {
                    answer ++;
                }
            }
        }
        System.out.println(answer);
    }

}
