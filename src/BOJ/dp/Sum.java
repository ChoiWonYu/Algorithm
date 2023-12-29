package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum {

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

        int[] dy = new int[max + 1];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for (int i = 4; i <= max; i++) {
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }

        for (int i = 0; i < t; i++) {
            sb.append(dy[nums[i]]).append("\n");
        }
        System.out.println(sb);
    }

}
