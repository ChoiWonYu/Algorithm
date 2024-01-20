package BOJ.bfs;

import java.io.*;
import java.util.*;

public class HideAndSeek4 {

    static int n;
    static int[] from;
    static boolean[] visited;
    static Deque<Integer> d = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        visited[n] = true;
        from = new int[100001];
        from[n] = -1;
        d.add(n);

        int cnt = 0;
        while (!d.isEmpty()) {
            int len = d.size();
            cnt++;
            for (int i = 0; i < len; i++) {
                int cur = d.poll();
                if (cur == k) {
                    System.out.println(cnt - 1);
                    printResult(cur);
                    return;
                }

                int forward = cur + 1;
                int back = cur - 1;
                int multi = cur * 2;

                if (cur < k && forward <= 100000 && !visited[forward]) {
                    addNum(forward, cur);
                }

                if (back >= 0 && !visited[back]) {
                    addNum(back, cur);
                }

                if (cur < k && multi <= 100000 && !visited[multi]) {
                    addNum(multi, cur);
                }
            }
        }
    }

    private static void printResult(final int cur) {
        Stack<Integer> s = new Stack<>();
        int next = cur;
        while (next != -1) {
            s.push(next);
            next = from[next];
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }

        System.out.println(sb);
    }

    private static void addNum(final int num, final int cur) {
        from[num] = cur;
        visited[num] = true;
        d.add(num);
    }
}
