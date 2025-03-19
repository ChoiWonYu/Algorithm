package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1911 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long l = Integer.parseInt(st.nextToken());

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int)(a[0] - b[0]));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Integer.parseInt(st.nextToken());
            long e = Integer.parseInt(st.nextToken());
            pq.add(new long[]{s, e});
        }

        long prev = -1;
        int cnt = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long s = cur[0];
            long e = cur[1];
            if (prev >= s) {
                if (prev >= e) {
                    continue;
                }
                s = prev + 1;
            }

            long mul = (e - s) % l == 0 ? (e - s) / l : (e - s) / l + 1;
            cnt += mul;
            prev = s + l * mul - 1;
        }
        System.out.println(cnt);
    }
}
