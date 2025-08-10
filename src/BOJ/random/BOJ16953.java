package BOJ.random;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ16953 {

    static final long MAX_VALUE = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        Deque<Long> d = new ArrayDeque<>();
        d.add((long) start);

        int level = 1;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                long cur = d.pollFirst();
                if (cur == end) {
                    System.out.println(level);
                    return;
                }

                long n1 = cur * 2;
                long n2 = cur * 10 + 1;

                if (n1 <= MAX_VALUE) {
                    d.addLast(n1);
                }

                if (n2 <= MAX_VALUE) {
                    d.addLast(n2);
                }
            }
            level++;
        }

        System.out.println(-1);
    }

}
