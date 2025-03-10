package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1660 {

    static final int CANNON_CNT = 121;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cannon = getCannons();


        int n = Integer.parseInt(br.readLine());
        int maxIdx = 0;
        int cur = cannon[0];

        while (cur <= n) {
            cur = cannon[maxIdx++];
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < maxIdx; i++) {
            cur = cannon[i];
            for (int j = 0; j <= n - cur; j++) {
                dp[j + cur] = Math.min(dp[j + cur], dp[j] + 1);
            }
        }
        System.out.println(dp[n]);
    }


    private static int[] getCannons() {
        int[] result = new int[CANNON_CNT];
        int[] nums = new int[776];
        nums[0] = 1;
        int n = 2;
        int cur = 1;
        int cnt = 1;
        while (cur <= 300000) {
            cur += n++;
            nums[cnt] = cur;
            cnt++;
        }

        result[0] = 1;
        cnt = 1;
        int i = 1;
        while (result[i - 1] <= 300000) {
            result[i] = result[i - 1] + nums[i];
            cnt++;
            i++;
        }
        return result;
    }

}
