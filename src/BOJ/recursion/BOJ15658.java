package BOJ.recursion;

import java.io.*;
import java.util.*;

public class BOJ15658 {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] ops = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        recursion(nums, nums[0], ops, 1);

        System.out.println(max + "\n" + min);
    }

    public static void recursion(int[] nums, int result, int[] ops, int depth) {
        if (depth == nums.length) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] <= 0) {
                continue;
            }
            ops[i]--;
            if (i == 0) {
                recursion(nums, result + nums[depth], ops, depth + 1);
            } else if (i == 1) {
                recursion(nums, result - nums[depth], ops, depth + 1);
            } else if (i == 2) {
                recursion(nums, result * nums[depth], ops, depth + 1);
            } else {
                recursion(nums, result / nums[depth], ops, depth + 1);
            }
            ops[i]++;
        }
    }

}
