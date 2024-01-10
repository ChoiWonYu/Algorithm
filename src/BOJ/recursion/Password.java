package BOJ.recursion;

import java.util.*;
import java.io.*;

public class Password {

    static StringBuilder sb = new StringBuilder();
    static Character[] cur;
    static List<Character> chars = new ArrayList<>();
    static List<Character> special = List.of('a', 'e', 'i', 'o', 'u');
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[m];
        cur = new Character[n];

        String target = br.readLine();

        for (int i = 0; i < target.length(); i++) {
            chars.add(target.charAt(i++));
        }
        chars.sort((a, b) -> a - b);

        recursion(0, 0, 0, 0);

        System.out.println(sb);
    }

    private static void recursion(final int depth, final int specialCnt, final int commonCnt,
        final int index) {
        if (depth == n) {
            if (specialCnt >= 1 && commonCnt >= 2) {
                Arrays.stream(cur)
                    .forEach(sb::append);
                sb.append("\n");
            }
            return;
        }

        for (int i = index; i < m; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            cur[depth] = chars.get(i);
            boolean isContain = special.contains(chars.get(i));
            recursion(depth + 1, isContain ? specialCnt + 1 : specialCnt,
                isContain ? commonCnt : commonCnt + 1, i + 1);
            visited[i] = false;
        }
    }

}
