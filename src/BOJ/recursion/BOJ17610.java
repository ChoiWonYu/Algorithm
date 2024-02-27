package BOJ.recursion;

import java.io.*;
import java.util.*;

public class BOJ17610 {

    static Set<Integer> s = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums, 0, 0);
        int sum = Arrays.stream(nums)
            .sum();
        int result = 0;
        for(int i=1;i<=sum;i++){
            if(!s.contains(i))result++;
        }

        System.out.println(result);
    }

    private static void dfs(final int[] nums, final int idx, final int result) {
        if (result > 0) {
            s.add(result);
        }

        for (int i = idx; i < nums.length; i++) {

            dfs(nums, i + 1, result + nums[i]);
            dfs(nums, i + 1, Math.abs(result - nums[i]));
        }
    }

}
