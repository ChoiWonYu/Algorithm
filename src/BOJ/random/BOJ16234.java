package BOJ.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ16234 {

    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean isMerged = true;
        Deque<int[]> d = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        List<int[]> merged = new ArrayList<>();
        int answer = 0;

        while (isMerged) {
            isMerged = false;
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    merged.clear();
                    if (visited[i][j]) {
                        continue;
                    }
                    int sum = 0;
                    d.add(new int[]{i, j, arr[i][j]});
                    sum += arr[i][j];
                    visited[i][j] = true;
                    while (!d.isEmpty()) {
                        int[] cur = d.poll();
                        int curPrice = cur[2];
                        for (int k = 0; k < 4; k++) {
                            int nextR = cur[0] + dr[k];
                            int nextC = cur[1] + dc[k];
                            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n
                                && !visited[nextR][nextC]
                                && Math.abs(arr[nextR][nextC] - curPrice) >= l
                                && Math.abs(arr[nextR][nextC] - curPrice) <= r) {
                                d.add(new int[]{nextR, nextC, arr[nextR][nextC]});
                                visited[nextR][nextC] = true;
                                sum += arr[nextR][nextC];
                            }
                        }
                        merged.add(cur);
                    }

                    int size = merged.size();
                    if (size > 1) {
                        isMerged = true;
                    }
                    for (int[] cur : merged) {
                        arr[cur[0]][cur[1]] = sum / size;
                    }
                }
            }
            if (isMerged) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}
