package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinCard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] amounts = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            amounts[i] = Integer.parseInt(st.nextToken());
        }

        int[] dy = new int[n + 1];
        Arrays.fill(dy, 99999999);
        dy[0] = 0;

        for (int i = 1; i <= amounts.length; i++) {
            for (int j = i; j <= n; j++) {
                dy[j] = Math.min(dy[j], dy[j - i] + amounts[i - 1]);
            }
        }

        System.out.println(dy[n]);
    }

}
