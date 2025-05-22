package sw.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SW1860 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] arrive = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt();
                arrive[i] = cur;
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            int remain = 0;
            Arrays.sort(arrive);
            int max = arrive[n - 1];
            boolean answer = true;
            for (int i = 0; i <= max; i++) {
                if (i != 0 && i % m == 0) {
                    remain += k;
                }

                if (map.containsKey(i)) {
                    remain -= map.get(i);
                    if (remain < 0) {
                        answer = false;
                        break;
                    }
                }
            }
            System.out.print("#" + test_case + " ");
            String answerSt = answer ? "Possible" : "Impossible";
            System.out.println(answerSt);
        }
    }
}
