package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BitonicNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] rdp = new int[n];
        int[] ldp = new int[n];

        for (int i = 0; i < n; i++) {
            int rMax = 0;
            int lMax = 0;
            for (int j = 0; j <= i; j++) {

                if (nums[i] > nums[j]) {
                    rMax = Math.max(rMax, rdp[j]);
                }
                if (nums[n - i - 1] > nums[n - j - 1]) {
                    lMax = Math.max(lMax, ldp[n - j - 1]);
                }
            }

            rdp[i] = rMax + 1;
            ldp[n - i - 1] = lMax + 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, rdp[i] + ldp[i] - 1);
        }

        System.out.println(result);
    }

}
