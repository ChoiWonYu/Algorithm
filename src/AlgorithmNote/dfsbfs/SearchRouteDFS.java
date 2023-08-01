package AlgorithmNote.dfsbfs;

import java.util.*;

public class SearchRouteDFS {
  public static boolean[] visited;
  public static boolean[][] graph;
  public static int line,last,answer=0;

  public static void DFS(int n) {
    if(n==last)answer++;
    for (int i = 1; i <= last; i++) {
      if(graph[n][i]&&!visited[i]){
        visited[i]=true;
        DFS(i);
        visited[i]=false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    line=m;
    last=n;
    graph = new boolean[n+1][n+1];
    visited = new boolean[n+1];
    for (int i = 0; i < m; i++) {
      int s=sc.nextInt();
      int e=sc.nextInt();
      graph[s][e]=true;
    }
    visited[1]=true;
    DFS(1);
    System.out.println(answer);
  }

}
