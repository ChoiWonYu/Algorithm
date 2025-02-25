package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1038 {

    public static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            dfs(i, i);
        }

        long answer = 0;
        for (int i = 0; i <= n; i++) {
            if (pq.isEmpty()) {
                answer = -1;
                break;
            }
            answer = pq.poll();
        }
        System.out.println(answer);
    }

    public static void dfs(long n, int last) {
        pq.add(n);
        for (int i = 0; i < last; i++) {
            dfs(n * 10 + i, i);
        }
    }
}
