package BOJ.deque;

import java.io.*;
import java.util.*;

public class JumpRope {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> h = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            h.offer(Integer.parseInt(st.nextToken()));
        }

        if (n <= 2) {
            System.out.println(n);
            return;
        }

        Deque<Integer> right = new LinkedList<>();
        Deque<Integer> left = new LinkedList<>();

        right.offer(h.poll());
        left.offer(h.poll());
        int cnt = 2;
        while (!h.isEmpty()) {
            int target = h.poll();
            if (right.peekLast() >= target && left.peekLast() >= target) {
                continue;
            }
            cnt++;
            if (right.peekLast() < target) {
                right.offer(target);
                continue;
            }

            left.offer(target);

        }
        System.out.println(cnt);
    }

}
