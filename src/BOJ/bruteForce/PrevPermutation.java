package BOJ.bruteForce;

import java.util.*;
import java.io.*;

public class PrevPermutation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(-1);
            return;
        }

        int idx = n - 1;
        while (idx > 0 && nums[idx] > nums[idx - 1]) {
            idx--;
        }

        if (idx == 0) {
            System.out.println(-1);
            return;
        }

        int maxNum = -1;
        int maxIdx = 0;

        for (int i = idx; i < n; i++) {
            if (maxNum < nums[i] && nums[i] < nums[idx - 1]) {
                maxNum = nums[i];
                maxIdx = i;
            }
        }

        int t = nums[maxIdx];
        nums[maxIdx] = nums[idx-1];
        nums[idx - 1] = t;

        Arrays.sort(nums, idx, nums.length, (a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            sb.append(nums[i]).append(" ");
        }

        System.out.println(sb);
    }
}
