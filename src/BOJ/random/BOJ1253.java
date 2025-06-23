package BOJ.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BOJ1253 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        Set<Long> sumSet = new HashSet<>();
        Set<Long> arrSet = new HashSet<>();
        Map<Long, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            arrSet.add(arr[i]);
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long n1 = Math.abs(arr[i]) < Math.abs(arr[j]) ? arr[i] : arr[j];
                long n2 = n1 == arr[j] ? arr[i] : arr[j];
                if (n1 == 0L) {
                    if (n2 == 0L && m.get(0L) <= 2) {
                        continue;
                    } else if (n2 != 0L && m.get(n2) < 2) {
                        continue;
                    }
                }
                sumSet.add(arr[j] + arr[i]);
            }
        }
//        System.out.println(sumSet);

        int answer = 0;
        for (long num : arr) {
            if (sumSet.contains(num)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
