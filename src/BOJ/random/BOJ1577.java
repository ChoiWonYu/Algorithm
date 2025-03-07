package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1577 {

    public static final String SEPARATOR = ",";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xMax = Integer.parseInt(st.nextToken());
        int yMax = Integer.parseInt(st.nextToken());
        long[][] dp = new long[yMax + 1][xMax + 1];

        int k = Integer.parseInt(br.readLine());
        Set<String> s = new HashSet<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            s.add(x1 + SEPARATOR + y1 + SEPARATOR + x2 + SEPARATOR + y2);
            s.add(x2 + SEPARATOR + y2 + SEPARATOR + x1 + SEPARATOR + y1);
        }

        for (int i = 1; i <= xMax; i++) {
            if (s.contains((i - 1) + SEPARATOR + 0 + SEPARATOR + i + SEPARATOR + 0)) {
                break;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i <= yMax; i++) {
            if (s.contains(0 + SEPARATOR + (i - 1) + SEPARATOR + 0 + SEPARATOR + i)) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i <= yMax; i++) {
            for (int j = 1; j <= xMax; j++) {
                int prevX = j - 1;
                int prevY = i - 1;

                if (!s.contains(j + SEPARATOR + i + SEPARATOR + prevX + SEPARATOR + i)) {
                    dp[i][j] += dp[i][prevX];
                }

                if (!s.contains(j + SEPARATOR + i + SEPARATOR + j + SEPARATOR + prevY)) {
                    dp[i][j] += dp[prevY][j];
                }
            }
        }

        System.out.println(dp[yMax][xMax]);
    }

}
