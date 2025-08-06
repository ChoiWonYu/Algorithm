package BOJ.random;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(input);
            }
        }
    }

}
