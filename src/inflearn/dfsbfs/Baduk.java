package inflearn.dfsbfs;

import java.util.*;

public class Baduk {
  static int[] weight;
  static int maxSum=0,maxWeight;

  public static void dfs(int n, int s) {
    if(s<=maxWeight&&s>maxSum)maxSum=s;
    if(n==weight.length|s>maxWeight)return;
    dfs(n+1,s+weight[n]);
    dfs(n+1,s);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c=sc.nextInt();
    maxWeight=c;

    int n=sc.nextInt();
    weight=new int[n+1];
    for(int i=1;i<=n;i++){
      weight[i]=sc.nextInt();
    }

    dfs(0, 0);
    System.out.println(maxSum);
  }

}
