package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1495 {

    static int[] volumes;
    static int n, m, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        volumes = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> d = new LinkedList<>();
        d.add(s);
        boolean[] visited = new boolean[1001];
        int cur, plus, minus, len, curVol, depth = 0;
        while (!d.isEmpty() && depth < n) {
            len = d.size();
            Arrays.fill(visited, false);
            curVol = volumes[depth++];
            for (int i = 0; i < len; i++) {
                cur = d.pollFirst();
                plus = cur + curVol;
                minus = cur - curVol;
                if (isValid(plus) && !visited[plus]) {
                    visited[plus] = true;
                    d.add(plus);
                }
                if (isValid(minus) && !visited[minus]) {
                    visited[minus] = true;
                    d.add(minus);
                }
            }
        }

        int answer = -1;
        for (int v : d) {
            answer = Math.max(answer, v);
        }
        System.out.println(answer);
    }

    public static boolean isValid(int num) {
        return num >= 0 && num <= m;
    }
}
