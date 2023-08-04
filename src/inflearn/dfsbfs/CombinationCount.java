package inflearn.dfsbfs;

import java.util.*;

public class CombinationCount {
  static int[][]memo;

  public static int dfs(int n,int r){
    if(n==r||r==0)return 1;
    if(memo[n][r]!=0)return memo[n][r];
    return  memo[n][r]=dfs(n-1,r)+dfs(n-1,r-1);
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int r=sc.nextInt();
    memo=new int[n+1][r+1];
    System.out.println(dfs(n,r));
  }
}
