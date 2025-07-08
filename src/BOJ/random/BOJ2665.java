package BOJ.random;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ2665 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int i = 0; i < dr.length; i++) {
                int nextR = cur[0] + dr[i];
                int nextC = cur[1] + dc[i];
                if(nextR == n - 1 && nextC == n - 1) {
                    System.out.println(cur[2]);
                    return;
                }
                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || visited[nextR][nextC]) {
                    continue;
                }
                int nextCnt = cur[2];
                if (arr[nextR][nextC] == 0) {
                    nextCnt++;
                }
                pq.offer(new int[]{nextR, nextC, nextCnt});
                visited[nextR][nextC] = true;
            }
        }
    }

}
