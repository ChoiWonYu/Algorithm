package inflearn.dfsbfs;

import java.util.*;

class Location {

  private int row;
  private int col;

  public Location(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public int getRow(){
    return row;
  }

  public int getCol(){
    return col;
  }

  public boolean isFinish(int max) {
    return row == max - 1 && col == max - 1;
  }
}

public class MazeShortestRoute {

  static final int MAX = 7;
  static int[][] maze = new int[MAX][MAX];
  static int[] rowMove = new int[]{0, 0, 1, -1}, colMove = new int[]{1, -1, 0, 0};

  private static int bfs(int row, int col) {
    Queue<Location> Q = new LinkedList<>();
    Q.offer(new Location(row, col));
    int count=0;

    while (!Q.isEmpty()) {
      int len = Q.size();
      for (int i = 0; i < len; i++) {
        Location cur = Q.poll();
        if (cur.isFinish(MAX)) {
          return count;
        }
        for (int j=0;j<4;j++) {
          int x=cur.getRow()+rowMove[j];
          int y=cur.getCol()+colMove[j];
          if (!canGo(x,y)) {
            continue;
          }
          Q.offer(new Location(x,y));
          maze[x][y] = 1;
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
    int answer = bfs(0, 0);
    System.out.println(answer);
  }

  private static boolean canGo(int row, int col) {
    return row < MAX && col < MAX && row >= 0 && col >= 0 && maze[row][col] != 1;
  }

}
