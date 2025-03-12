package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {

    static int[] uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        uf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (flag == 1) {
                if (find(n1) == find(n2)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            } else {
                union(n1, n2);
            }
        }

        System.out.println(sb);
    }

    public static void union(int n1, int n2) {
        if (n1 == n2) {
            return;
        }
        uf[find(n1)] = find(n2);
    }

    public static int find(int n1) {
        if (uf[n1] == n1) {
            return n1;
        }
        return uf[n1] = find(uf[n1]);
    }
}
