package BOJ.random;

import java.io.*;
import java.util.*;

class Loc implements Comparable<Loc> {

    int s;
    int e;

    public Loc(final int s, final int e) {
        this.s = s;
        this.e = e;
    }


    @Override
    public int compareTo(final Loc o) {
        if (s == o.s) {
            return e - o.e;
        }
        return s - o.s;
    }
}

public class BOJ2170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.add(new Loc(s, e));
        }

        long sum = 0;
        Loc first = pq.poll();
        int prevE = first.e;
        sum += first.e - first.s;
        while (!pq.isEmpty()) {
            Loc cur = pq.poll();
            if (prevE >= cur.s) {
                if (cur.e - prevE > 0) {
                    sum += cur.e - prevE;
                    prevE = cur.e;
                }
            } else {
                sum += cur.e - cur.s;
                prevE = cur.e;
            }
        }

        System.out.println(sum);
    }

}
