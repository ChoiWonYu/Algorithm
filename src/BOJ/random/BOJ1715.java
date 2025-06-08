package BOJ.random;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1715 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (int) (a - b));
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }
        long answer = 0;
        while (pq.size() > 1) {
            long n1 = pq.poll();
            long n2 = pq.poll();
            answer += (n1 + n2);
            pq.offer(n1 + n2);
        }
        System.out.println(answer);
    }

}
