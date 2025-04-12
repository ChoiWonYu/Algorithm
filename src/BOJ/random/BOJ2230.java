package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1 || m == 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(nums);
        int lp = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            while (nums[i] - nums[lp] >= m) {
                min = Math.min(min, nums[i] - nums[lp++]);
            }
        }
        System.out.println(min);
    }

}
