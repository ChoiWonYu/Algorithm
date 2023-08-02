package inflearn.dfsbfs;

import java.util.*;

public class MaxScore {
  static int maxTime,maxScore=0,last;
  static int[][]scoreTime;

  public static void dfs(int n,int s,int t) {
    if(t>maxTime)return;
    maxScore=Math.max(s,maxScore);
    if(n==last)return;
    dfs(n+1,s+scoreTime[n+1][0],t+scoreTime[n+1][1]);
    dfs(n+1,s,t);
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int q=sc.nextInt();
    int t=sc.nextInt();
    maxTime=t;
    last=q;
    scoreTime=new int[q+1][2];
    for (int i = 1; i <= q; i++) {
      scoreTime[i][0]=sc.nextInt();
      scoreTime[i][1]=sc.nextInt();
    }
    dfs(0,0,0);
    System.out.println(maxScore);
  }

}
