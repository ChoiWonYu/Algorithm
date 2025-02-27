package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1068 {

    public static final int REMOVE_NUMBER = -4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tree = new int[n];
        boolean[] leaf = new boolean[n];
        Arrays.fill(leaf, true);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int removeNum = Integer.parseInt(br.readLine());
        tree[removeNum] = REMOVE_NUMBER;
        leaf[removeNum] = false;

        Deque<Integer> d = new LinkedList<>();
        d.add(removeNum);
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.pollFirst();
                for (int j = 0; j < n; j++) {
                    if (tree[j] == cur) {
                        tree[j] = REMOVE_NUMBER;
                        leaf[j] = false;
                        d.add(j);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (tree[i] >= 0) {
                leaf[tree[i]] = false;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (leaf[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
