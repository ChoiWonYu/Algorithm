package BOJ.recursion;

import java.util.*;
import java.io.*;

public class Shark {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        long[] sharks = new long[n];
        PriorityQueue<Long> d = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sharks[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(sharks);

        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (sharks[i] >= t) {
                idx = i;
                break;
            }
            d.offer(sharks[i]);
        }

        for (int i = 0; i < k; i++) {
            if (d.isEmpty()) {
                break;
            }
            long prevSize = t;
            t += d.poll();
            for (int j = idx; j < n; j++) {
                long target = sharks[j];
                if (target >= prevSize && target < t) {
                    d.offer(target);
                } else {
                    idx = j;
                    break;
                }
            }
        }

        System.out.println(t);
    }


}
