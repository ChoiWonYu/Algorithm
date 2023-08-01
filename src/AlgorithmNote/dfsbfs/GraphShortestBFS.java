package AlgorithmNote.dfsbfs;

import java.util.*;

public class GraphShortestBFS {

  public static int line, last;
  public static int[] dist;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> graph;

  public static void solution() {
    Queue<Integer> Q = new LinkedList<Integer>();
    Q.add(1);
    int level = 0;
    while (!Q.isEmpty()) {
      int len = Q.size();
      for (int i = 0; i < len; i++) {
        int cur = Q.poll();
        visited[cur] = true;
        for (int j : graph.get(cur)) {
          if (!visited[j]) {
            dist[j] = level+1;
            Q.offer(j);
            visited[j]=true;
          }
        }
      }
      level++;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    line = m;
    last = n;
    graph = new ArrayList<ArrayList<Integer>>();
    dist = new int[n + 1];
    visited = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < m; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();

      graph.get(s).add(e);
    }
    solution();
    System.out.println(Arrays.toString(dist));
  }

}
