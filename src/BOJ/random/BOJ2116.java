package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2116 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] peerArr = new int[]{5, 3, 4, 1, 2, 0};
        int[][] nums = new int[n][6];
        int[][] dp = new int[n + 1][6];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                int cur = Integer.parseInt(st.nextToken());
                nums[i][j] = cur;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                int cur = nums[i][j];
                int peer = nums[i][peerArr[j]];
                dp[i + 1][cur - 1] = dp[i][peer - 1] + getMax(cur, peer);
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            answer = Math.max(dp[n][i], answer);
        }

        System.out.println(answer);
    }

    public static int getMax(int n1, int n2) {
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= 6; i++) {
            if (i == n1 || i == n2) {
                continue;
            }
            answer = Math.max(answer, i);
        }
        return answer;
    }

}
