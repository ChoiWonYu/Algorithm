package BOJ.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ11403 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt() != 0;
            }
        }

        boolean[][] answer = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Deque<Integer> deque = new LinkedList<>();
            boolean[] visited = new boolean[n];
            deque.offer(i);
            while (!deque.isEmpty()) {
                int cur = deque.poll();
                for (int j = 0; j < n; j++) {
                    if (visited[j] || !arr[cur][j]) {
                        continue;
                    }
                    visited[j] = true;
                    deque.offer(j);
                    answer[i][j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (answer[i][j]) {
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
