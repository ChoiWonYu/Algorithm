package inflearn.dfsbfs;

import java.util.*;

public class CustomNumPermutation {
  static int M,N;
  static int[] nums,pt;
  static boolean[] visited;

  public static void dfs(int idx){
    if(idx>=M){
      for (int i : pt) {
        System.out.print(i+" ");
      }
      System.out.println();
      return;
    }
    for(int i=0;i<N;i++){
      if(visited[i])continue;
      pt[idx]=nums[i];
      visited[i]=true;
      dfs(idx+1);
      visited[i]=false;
    }
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N=sc.nextInt();
    M=sc.nextInt();
    nums=new int[N];
    Arrays.sort(nums);
    pt=new int[M];
    visited=new boolean[N];
    for(int i=0;i<N;i++)nums[i]=sc.nextInt();

    dfs(0);
  }
}
