package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1890 {

    public static int n;
    public static long answer = 0;
    public static int[][] game;
    public static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        game = new int[n][n];
        memo = new long[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(memo[i], -1);
            for (int j = 0; j < n; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int r, int c) {
        if (r == n - 1 && c == n - 1) {
            answer++;
            return;
        }
        if (game[r][c] == 0) {
            return;
        }
        long prev = answer;
        if(memo[r][c] == -1){
            int nextR = r + game[r][c];
            int nextC = c + game[r][c];

            if (nextR >= 0 && nextR < n) {
                dfs(nextR, c);
            }
            if (nextC >= 0 && nextC < n) {
                dfs(r, nextC);
            }
            memo[r][c] = answer - prev;
        } else {
            answer += memo[r][c];
        }
    }
}
