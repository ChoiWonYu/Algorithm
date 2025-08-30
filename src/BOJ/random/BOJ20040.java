package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20040 {

    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n];
        for(int i=0; i<n; i++) {
            unf[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if (union(n1, n2)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
        br.close();
    }

    public static boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) {
            return true;
        }
        unf[p1] = p2;
        return false;
    }

    public static int find(int n) {
        if (n == unf[n]) {
            return n;
        }
        return unf[n] = find(unf[n]);
    }
}
