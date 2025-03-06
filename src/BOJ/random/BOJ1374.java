package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> spq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            spq.add(new int[]{id, start, end});
        }

        PriorityQueue<int[]> epq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        epq.add(spq.poll());

        int answer = 1;
        while (!spq.isEmpty()) {
            int[] cur = spq.poll();
            while (!epq.isEmpty() && epq.peek()[2] <= cur[1]) {
                epq.poll();
            }
            epq.add(cur);
            answer = Math.max(answer, epq.size());
        }

        System.out.println(answer);
    }

}
