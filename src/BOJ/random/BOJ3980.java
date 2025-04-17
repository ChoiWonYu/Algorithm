package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3980 {

    static int[][] players;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x = Integer.parseInt(br.readLine());
        for (int t = 0; t < x; t++) {
            answer = 0;
            players = new int[11][11];
            StringTokenizer st;
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    players[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, new int[11]);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int idx, int[] power) {
        if (idx == 11) {
            int sum = 0;
            for (int i = 0; i < 11; i++) {
                if (power[i] == 0) {
                    return;
                }
                sum += power[i];
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (players[idx][i] != 0 && power[i] == 0) {
                power[i] = players[idx][i];
                dfs(idx + 1, power);
                power[i]= 0;
            }
        }
    }
}
