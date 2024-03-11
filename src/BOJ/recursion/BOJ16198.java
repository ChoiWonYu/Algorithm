package BOJ.recursion;

import java.io.*;
import java.util.*;

public class BOJ16198 {

    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursion(arr, 0);
        System.out.println(max);
    }

    private static void recursion(int[] arr, int result) {
        max = Math.max(max, result);
        int len = arr.length;
        int prev = arr[0];

        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1 || visited[i]) {
                continue;
            }

            visited[i] = true;
            int next = i;
            while (visited[next] && next < len - 1) {
                next++;
            }
            recursion(arr, result + arr[next] * prev);
            visited[i] = false;
            prev = arr[i];
        }
    }

}
