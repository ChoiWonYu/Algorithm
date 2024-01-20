package BOJ.bfs;

import java.io.*;
import java.util.*;

public class HideAndSeek3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[100001];

        Deque<Integer> d = new LinkedList<>();
        d.add(n);

        int result = 0;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.poll();
                int mul = 0;
                while (cur != 0 && cur * (int) Math.pow(2, mul) <= 2 * k
                    && cur * (int) Math.pow(2, mul) <= 100000) {
                    int next = cur * (int) Math.pow(2, mul++);
                    if (next == k) {
                        System.out.println(result);
                        return;
                    }

                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    d.add(next);
                }
                d.offer(cur);
            }
            len = d.size();
            result++;
            for (int i = 0; i < len; i++) {
                int cur = d.poll();

                int forward = cur + 1;
                int back = cur - 1;
                if (forward == k || back == k) {
                    System.out.println(result);
                    return;
                }

                if (forward <= 100000 && !visited[forward]) {
                    visited[forward] = true;
                    d.add(forward);
                }

                if (back >= 0 && !visited[back]) {
                    visited[back] = true;
                    d.add(back);
                }
            }
        }
    }

}
