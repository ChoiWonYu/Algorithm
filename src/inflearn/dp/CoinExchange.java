package inflearn.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinExchange {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int amount = Integer.parseInt(br.readLine());
        int[] dy = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dy[i] = Integer.MAX_VALUE;
        }
        dy[0] = 0;

        Arrays.sort(coins);

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dy[j] = Math.min(dy[j - coins[i]] + 1, dy[j]);
            }
        }

        System.out.println(dy[amount]);
    }

}
