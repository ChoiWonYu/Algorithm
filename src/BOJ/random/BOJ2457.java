package BOJ.random;

import java.io.*;
import java.util.*;

class Flower implements Comparable<Flower> {

    int sm;
    int sd;
    int em;
    int ed;

    public Flower(final int sm, final int sd, final int em, final int ed) {
        this.sm = sm;
        this.sd = sd;
        this.em = em;
        this.ed = ed;
    }

    @Override
    public int compareTo(Flower o) {
        if (sm == o.sm && sd == o.sd && em == o.em) {
            return ed - o.ed;
        }
        if (sm == o.sm && sd == o.sd) {
            return em - o.em;
        }
        if (sm == o.sm) {
            return sd - o.sd;
        }
        return sm - o.sm;
    }
}

public class BOJ2457 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Flower> flowers = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            if (em < 3) {
                continue;
            }
            if (sm > 11) {
                continue;
            }
            if (sm < 3) {
                sm = 3;
                sd = 1;
            }
            if (em >= 12) {
                em = 12;
                ed = 1;
            }
            flowers.add(new Flower(sm, sd, em, ed));
        }

        Deque<Flower> d = new LinkedList<>();
        Flower first = flowers.poll();
        if (isLater(first.sm, first.sd, 3, 2)) {
            System.out.println(0);
            return;
        }
        d.add(first);
        while (!flowers.isEmpty()) {
            Flower cur = flowers.poll();
            Flower prev = d.pollLast();

            if (!isLater(prev.em, prev.ed, cur.sm, cur.sd)) {
                System.out.println(0);
                return;
            }

            if (cur.sm == prev.sm && cur.sd == prev.sd) {
                d.offer(cur);
                continue;
            }

            if (isLater(prev.em, prev.ed, cur.em, cur.ed)) {
                d.offer(prev);
                continue;
            }

            if (!d.isEmpty()) {
                Flower peekFlower = d.peekLast();
                if (isLater(peekFlower.em, peekFlower.ed, cur.sm, cur.sd) &&
                    isLater(cur.em, cur.ed, prev.em, prev.ed)) {
                    d.offer(cur);
                    continue;
                }
            }

            d.offer(prev);
            d.offer(cur);
        }

        Flower last = d.peekLast();
        if (last.em != 12) {
            System.out.println(0);
            return;
        }

        System.out.println(d.size());
    }

    private static boolean isLater(int m1, int d1, int m2, int d2) {
        return m1 > m2 || (m2 == m1 && d1 >= d2);
    }

}
