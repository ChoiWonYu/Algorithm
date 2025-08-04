package BOJ.random;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ2217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
        int k = 1;
        int max = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            max = Math.max(max, cur * k);
            k++;
        }

        System.out.println(max);
    }

}
