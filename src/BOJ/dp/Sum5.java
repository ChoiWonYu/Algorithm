package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] nums = new int[t];
        int max = 0;

        for (int i = 0; i < t; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nums[i]);
        }

        long[][] dy = new long[max + 1][4];
        dy[1] = new long[]{0, 1, 0, 0};
        dy[2] = new long[]{0, 0, 1, 0};
        dy[3] = new long[]{0, 1, 1, 1};
        for (int i = 4; i <= max; i++) {
            dy[i][1] = dy[i - 1][2] + dy[i - 1][3] % 1000000009;
            dy[i][2] = dy[i - 2][1] + dy[i - 2][3] % 1000000009;
            dy[i][3] = dy[i - 3][1] + dy[i - 3][2] % 1000000009;
        }

        for (int i = 0; i < t; i++) {
            sb.append((dy[nums[i]][1] + dy[nums[i]][2] + dy[nums[i]][3]) % 1000000009).append("\n");
        }
        System.out.println(sb);
    }
}
