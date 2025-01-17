package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189 {

    public static int[] dx = new int[]{0, 0, -1, 1};
    public static int[] dy = new int[]{1, -1, 0, 0};
    public static boolean[][] visited, canGo;
    public static int r, c, k, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행
        r = Integer.parseInt(st.nextToken());
        // 열
        c = Integer.parseInt(st.nextToken());
        // 거쳐야하는 점의 수
        k = Integer.parseInt(st.nextToken());

        canGo = new boolean[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                if (input.charAt(j) == 'T') {
                    canGo[i][j] = false;
                } else {
                    canGo[i][j] = true;
                }
            }
        }

        answer = 0;
        visited[r - 1][0] = true;
        dfs(r - 1, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int count) {
        if (count == k) {
            if (x == 0 && y == c - 1) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && !visited[nextX][nextY]
                && canGo[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, count + 1);
                visited[nextX][nextY] = false;
            }
        }
    }
}
