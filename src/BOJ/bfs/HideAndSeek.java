package BOJ.bfs;

import java.io.*;
import java.util.*;

public class HideAndSeek {

    private static final int MAX_DIS = 100000;
    private static final int MIN_DIS = -100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] visited = new boolean[200001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }

        Deque<Integer> d = new LinkedList<>();
        d.add(n);
        visited[n + MAX_DIS] = true;
        int cnt = 0;
        int[] next = new int[3];
        while (!d.isEmpty()) {
            int len = d.size();
            cnt++;
            for (int i = 0; i < len; i++) {
                int cur = d.poll();
                next[0] = cur + 1;
                next[1] = cur - 1;
                next[2] = cur * 2;

                for (int j = 0; j < next.length; j++) {
                    int nextLoc = next[j];
                    if (nextLoc == k) {
                        System.out.println(cnt);
                        return;
                    }
                    if (nextLoc > MAX_DIS || nextLoc < MIN_DIS || visited[nextLoc + MAX_DIS]) {
                        continue;
                    }
                    visited[nextLoc + MAX_DIS] = true;
                    d.add(nextLoc);
                }
            }
        }
    }

}
