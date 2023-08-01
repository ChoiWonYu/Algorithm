package AlgorithmNote.dfsbfs;

import java.util.*;

public class SearchRouteArrayList {

  public static int line, last, answer = 0;
  public static ArrayList<ArrayList<Integer>> graph;
  public static boolean[] visited;

  public static void Dfs(int n){
    if(n==last)answer++;
    for(int i:graph.get(n)){
      if(!visited[i]){
        visited[i]=true;
        Dfs(i);
        visited[i]=false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    last=n;
    line=m;
    graph = new ArrayList<ArrayList<Integer>>();
    visited=new boolean[n+1];
    for(int i=1;i<=n+1;i++)graph.add(new ArrayList<Integer>());
    for(int i=0;i<m;i++){
      int s=sc.nextInt();
      int e=sc.nextInt();
      graph.get(s).add(e);
    }
    visited[1]=true;
    Dfs(1);
    System.out.println(answer);
  }

}
