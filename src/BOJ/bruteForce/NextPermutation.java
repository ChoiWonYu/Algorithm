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
        int idx = n - 1;
        //이전 숫자보다 큰 마지막 인덱스를 찾는다.
        while (idx > 0 && nums[idx] < nums[idx - 1]) {
            idx--;
        }

        int minNum = 100001;
        int minIdx = -1;
        for (int i = idx; i < n; i++) {
            if (minNum > nums[i] && nums[i] > nums[idx - 1]) {
                minNum = nums[i];
                minIdx = i;
            }
        }

        int t = nums[idx - 1];
        nums[idx - 1] = nums[minIdx];
        nums[minIdx] = t;

        Arrays.sort(nums, idx, nums.length);

        for (int i = 0; i < n; i++) {
            sb.append(nums[i]).append(" ");
        }

        System.out.println(sb);
    }

}
