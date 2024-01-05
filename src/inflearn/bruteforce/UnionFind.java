package inflearn.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UnionFind {

    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            union(f1, f2);
        }

        st = new StringTokenizer(br.readLine());
        int q1 = Integer.parseInt(st.nextToken());
        int q2 = Integer.parseInt(st.nextToken());

        if (find(q1) == find(q2)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    private static void union(final int f1, final int f2) {
        int num1 = find(f1);
        int num2 = find(f2);

        unf[num1] = num2;
    }

    private static int find(final int num) {
        if (num == unf[num]) {
            return num;
        }

        return unf[num] = find(unf[num]);
    }

}
