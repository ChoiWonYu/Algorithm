package sw.random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SW24001 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String input = sc.next();
            Set<Integer> current = new HashSet<>();
            current.add(0);
            int answer = 0;

            for (char ch : input.toCharArray()) {
                Set<Integer> next = new HashSet<>();
                for (int pos : current) {
                    if (ch == 'L') {
                        next.add(pos - 1);
                    } else if (ch == 'R') {
                        next.add(pos + 1);
                    } else {
                        next.add(pos - 1);
                        next.add(pos + 1);
                    }
                }
                for (int pos : next) {
                    answer = Math.max(answer, Math.abs(pos));
                }
                current = next;
            }

            System.out.println(answer);
        }
    }
}
