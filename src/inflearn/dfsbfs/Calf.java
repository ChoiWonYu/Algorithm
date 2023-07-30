package inflearn.dfsbfs;

import java.util.*;

public class Calf {

  static int[] dis = {1, -1, 5};
  static boolean[] visited;

  public static int solution(int start, int end) {
    visited = new boolean[10001];
    Queue<Integer> Q = new LinkedList<>();
    visited[start] = true;
    Q.offer(start);
    int level = 0;
    while (!Q.isEmpty()) {
      int len = Q.size();
      for (int i = 0; i < len; i++) {
        int cur = Q.poll();
        for (int j = 0; j < dis.length; j++) {
          int d = cur + dis[j];
          if (d == end) {
            return level + 1;
          }
          if (d >= 1 && d <= 10000 && !visited[d]) {
            visited[d] = true;
            Q.offer(d);
          }
        }
      }
      level++;
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int s = sc.nextInt();
    int e = sc.nextInt();

    int answer = solution(s, e);
    System.out.println(answer);
  }

}
