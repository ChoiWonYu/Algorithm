package sw.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SW1225 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        Deque<Integer> d = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            d.clear();
            for (int i = 0; i < 8; i++) {
                d.addLast(sc.nextInt());
            }

            int minus = 1;
            while (true) {
                int num = d.pollFirst();
                d.addLast(Math.max(num - minus, 0));
                if (d.peekLast() == 0) {
                    break;
                }
                minus = minus == 5 ? 1 : minus + 1;
            }

            sb.append("#").append(test_case).append(" ");
            while(!d.isEmpty()) {
                sb.append(d.pollFirst()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
