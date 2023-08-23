package inflearn.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Island {
  static int N;
  static int[]r=new int[]{0,0,1,1,1,-1,-1,-1};
  static int[]c=new int[]{1,-1,1,0,-1,1,0,-1};

  static Integer[][] island;
  static boolean[][] visited;

  public static void dfs(int row, int col){
    if(!isValid(row,col)||visited[row][col]||island[row][col]==0)return;
    visited[row][col]=true;
    for(int i=0;i<8;i++){
      dfs(row+r[i],col+c[i]);
    }
  }

  public static int solution(){
    int result=0;
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(!visited[i][j]&&island[i][j]==1) {
          result++;
          dfs(i, j);
        }
        visited[i][j]=true;
      }
    }
    return result;
  }

  public static void main(String[] args)throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    N=Integer.parseInt(br.readLine());
    island=new Integer[N][N];
    visited=new boolean[N][N];
    for (int i = 0; i < N; i++) {
      island[i]= Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    int result=solution();
    System.out.println(result);
  }

  private static boolean isValid(int row, int col) {
    return row>=0&&row<N&&col>=0&&col<N;
  }

}
