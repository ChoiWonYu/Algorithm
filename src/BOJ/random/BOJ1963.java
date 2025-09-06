package BOJ.random;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1963 {

    static boolean[] isPrime;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        isPrime = new boolean[10000];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; i * j < 10000; j++) {
                isPrime[i * j] = false;
            }
        }
        set = new HashSet<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            set.clear();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == end) {
                bw.write(0 + "\n");
                continue;
            }

            int answer = bfs(start, end);
            if (answer == -1) {
                bw.write("Impossible\n");
            } else {
                bw.write(answer + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(final int start, final int end) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(start);
        set.clear();
        set.add(start);
        int answer = 0;
        while (!deque.isEmpty()) {
            int len = deque.size();
            answer++;
            for (int k = 0; k < len; k++) {
                int cur = deque.pollFirst();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 10; j++) {
                        int next = change(cur, i, j);
                        if (!isPrime[next] || set.contains(next) || next / 1000 == 0) {
                            continue;
                        }
                        if (next == end) {
                            return answer;
                        }
                        set.add(next);
                        deque.addLast(next);
                    }
                }
            }
        }
        return -1;
    }

    private static int change(final int cur, final int idx, final int num) {
        String result = "";
        String str = String.valueOf(cur);
        for (int i = 0; i < 4; i++) {
            if (i == idx) {
                result += num;
            } else {
                result += str.charAt(i);
            }
        }
        return Integer.parseInt(result);
    }

}
