package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int amount = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dy = new int[amount + 1];
        Arrays.fill(dy, 999999);
        dy[0] = 0;

        Arrays.sort(coins);

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dy[j] = Math.min(Math.abs(dy[j - coins[i]] + 1), dy[j]);
            }
        }

        int result = dy[amount] == 999999 ? -1 : dy[amount];
        System.out.println(result);
    }
}
