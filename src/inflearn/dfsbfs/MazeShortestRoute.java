package inflearn.dfsbfs;

import java.util.*;

public class MazeShortestRoute {

  static final int MAX = 7;
  static int[][] maze = new int[MAX][MAX], route = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  static boolean[][] visited = new boolean[MAX][MAX];

  private static int bfs(int row, int col) {
    Queue<int[]> Q = new LinkedList<>();
    int count = 0;
    Q.offer(new int[]{row, col});
    while (!Q.isEmpty()) {
      int len = Q.size();
      for (int i = 0; i < len; i++) {
        int[] cur = Q.poll();
        if (isFinish(cur[0], cur[1])) {
          return count;
        }
        for (int[] next : route) {
          int r = cur[0] + next[0], c = cur[1] + next[1];
          if (!canGo(r, c)) {
            continue;
          }
          Q.offer(new int[]{r, c});
          visited[r][c]=true;
        }
      }
      count++;
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < MAX; i++) {
      for (int j = 0; j < MAX; j++) {
        maze[i][j] = sc.nextInt();
      }
    }
    visited[0][0] = true;
    int answer = bfs(0, 0);
    System.out.println(answer);

  }

  private static boolean canGo(int row, int col) {
    return row < MAX && col < MAX && row >= 0 && col >= 0 && maze[row][col] != 1
        && !visited[row][col];
  }

  private static boolean isFinish(int row, int col) {
    return row == MAX - 1 && col == MAX - 1;
  }
}
