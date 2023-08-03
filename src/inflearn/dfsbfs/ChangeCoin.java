package inflearn.dfsbfs;

import java.util.*;

public class ChangeCoin {
  static int S,N,minCount=Integer.MAX_VALUE;
  static int[] coins;

  public static void dfs(int sum,int count){
    if(count>minCount|sum>S)return;
    if(sum==S&&count<minCount) {
      minCount=count;
      return;
    }

    for (int i = 0; i < N; i++) {
      dfs(sum+coins[i],count+1);
    }

  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    N=n;
    coins=new int[n];
    for(int i=n-1;i>=0;i--){
      coins[i]=sc.nextInt();
    }
    int s=sc.nextInt();
    S=s;
    dfs(0,0);
    System.out.println(minCount);
  }
}
