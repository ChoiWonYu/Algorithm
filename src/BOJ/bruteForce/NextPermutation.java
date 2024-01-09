package BOJ.bruteForce;

import java.util.*;
import java.io.*;

public class NextPermutation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(-1);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int[] tmp = new int[n - i];
                int min = 10001;
                int minIdx = 0;
                for (int j = i; j < n; j++) {
                    tmp[j - i] = nums[j];
                    if (min > tmp[j - i] && nums[i - 1] < tmp[j - i]) {
                        min = tmp[j - i];
                        minIdx = j - i;
                    }
                }
                int t = nums[i - 1];
                nums[i - 1] = tmp[minIdx];
                tmp[minIdx] = t;

                Arrays.sort(tmp);
                for (int j = 0; j < i; j++) {
                    sb.append(nums[j]).append(" ");
                }
                for (int j = 0; j < tmp.length; j++) {
                    sb.append(tmp[j]).append(" ");
                }
                System.out.println(sb);
                return;
            }

            if (i == 1) {
                System.out.println(-1);
                return;
            }
        }
    }

}
