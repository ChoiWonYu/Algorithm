package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1138 {

    public static int N;
    public static int[] mem, cur;
    public static boolean[] visited;
    public static boolean find = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mem = new int[N];
        visited = new boolean[N];
        cur = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mem[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            cur[0] = i;
            dfs(1);
            visited[i] = false;
        }
    }

    public static void dfs(int idx) {
        if (find) {
            return;
        }
        if (idx == N) {
            if (isValid()) {
                for (int i = 0; i < N; i++) {
                    System.out.print((cur[i] + 1) + " ");
                }
                find = true;
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            cur[idx] = i;
            visited[i] = true;
            dfs(idx + 1);
            visited[i] = false;
        }
    }

    public static boolean isValid() {
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (cur[j] == cur[i]) {
                    break;
                }
                if (cur[j] > cur[i]) {
                    count++;
                }
            }
            if (count != mem[cur[i]]) {
                return false;
            }
        }
        return true;
    }
}
