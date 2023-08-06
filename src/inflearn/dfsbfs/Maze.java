package inflearn.dfsbfs;

import java.util.*;

public class Maze {

  static final int MAX = 7;
  static int[][] maze = new int[MAX][MAX], route = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  static boolean[][] visited = new boolean[MAX][MAX];
  static int count = 0;

  public static void dfs(int row, int col) {
    if (isFinish(row, col)) {
      count++;
    }
    for (int[] r : route) {
      if (!canGo(row + r[0], col + r[1])) {
        continue;
      }
      visited[row + r[0]][col + r[1]] = true;
      dfs(row + r[0], col + r[1]);
      visited[row + r[0]][col + r[1]] = false;
    }
  }

  public static boolean canGo(int row, int col) {
    return row < MAX && col < MAX && row >= 0 && col >= 0 && maze[row][col] != 1
        && !visited[row][col];
  }

  public static boolean isFinish(int row, int col) {
    return row == MAX - 1 && col == MAX - 1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < MAX; i++) {
      for (int j = 0; j < MAX; j++) {
        maze[i][j] = sc.nextInt();
      }
    }
    visited[0][0] = true;
    dfs(0, 0);
    System.out.println(count);

  }
}
