package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (!pq.isEmpty()) {
                if (cur > 0 && pq.peek() * cur > cur) {
                    cur *= pq.poll();
                } else if (cur <= 0 && pq.size() % 2 == 1) {
                    cur *= pq.poll();
                }
            }
            sum += cur;
        }
        System.out.println(sum);
    }
}
