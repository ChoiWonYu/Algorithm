package BOJ.recursion;

import java.util.*;
import java.io.*;

public class InequalitySign {

    static int n;
    static String[] signs;
    static int[] cur;
    static boolean[] visited;
    static String max = String.valueOf(Integer.MIN_VALUE);
    static String min = "10000000000";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        signs = new String[n];
        cur = new int[n + 1];
        visited = new boolean[10];
        for (int i = 0; i < n; i++) {
            signs[i] = st.nextToken();
        }

        recursion(0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void recursion(final int depth) {
        if (depth == n + 1) {
            for (int i = 0; i < n; i++) {
                if (signs[i].equals("<") && cur[i] > cur[i + 1]) {
                    return;
                }
                if (signs[i].equals(">") && cur[i] < cur[i + 1]) {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();

            Arrays.stream(cur)
                .forEach(sb::append);

            String n = String.join("", sb);

            if (Long.parseLong(max) < Long.parseLong(n)) {
                max = n;
            }
            if (Long.parseLong(min) > Long.parseLong(n)) {
                min = n;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            cur[depth] = i;
            recursion(depth + 1);
            visited[i] = false;
        }
    }

}
