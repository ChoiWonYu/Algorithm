package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ16928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] memo = new boolean[101];

        Deque<Integer> d = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.put(start, end);
        }

        d.add(1);
        memo[1] = true;
        int cnt = 0;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.pollFirst();
                if (cur == 100) {
                    System.out.println(cnt);
                    return;
                }
                for (int j = 1; j <= 6; j++) {
                    if (!isValid(cur + j, memo)) {
                        continue;
                    }

                    if (map.containsKey(cur + j)) {
                        int next = map.get(cur + j);
                        d.addLast(next);
                        memo[next] = true;
                    } else {
                        d.addLast(cur + j);
                        memo[cur + j] = true;
                    }
                }
            }
            cnt++;
        }
    }

    private static boolean isValid(final int num, final boolean[] memo) {
        return num >= 1 && num <= 100 && !memo[num];
    }

}
