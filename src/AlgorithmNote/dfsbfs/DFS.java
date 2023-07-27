package AlgorithmNote.dfsbfs;

public class DFS {

  public static void dfs(int n) {

    if(n==0)return;
    System.out.println(n);
    dfs(n-1);
  }

  public static void main(String[] args) {
    dfs(3);
  }
}
