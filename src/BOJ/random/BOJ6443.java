package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ6443 {

    static int[] arr;
    static int length;
    static StringBuilder result = new StringBuilder();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, t, T = Integer.parseInt(br.readLine());
        arr = new int[26];
        for (t = 0; t < T; t++) {
            Arrays.fill(arr, 0);
            String input = br.readLine();
            length = input.length();

            for (i = 0; i < length; i++) {
                arr[input.charAt(i) - 'a']++;
            }

            dfs(0);
        }

        System.out.println(result);
    }

    private static void dfs(final int depth) {
        if (depth == length) {
            result.append(sb)
                .append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] <= 0) {
                continue;
            }
            sb.append((char) ('a' + i));
            arr[i]--;
            dfs(depth + 1);
            arr[i]++;
            sb.deleteCharAt(depth);
        }
    }
}
