package inflearn.dfsbfs;

import java.util.*;

public class SameSum {

  static String answer="NO";
  static int sum=0,last;
  static int[] set;
  public static void dfs(int n,int s) {
    if(n==last|s*2>sum)return;
    if(s*2==sum) {
      answer = "YES";
      return;
    };
    dfs(n+1,s+set[n+1]);
    dfs(n+1,s);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    set=new int[n+1];
    for (int i = 1; i <= n; i++) {
      set[i]=sc.nextInt();
      sum += set[i];
    }
    last= n;
    dfs(0,0);
    System.out.println(answer);
  }
}
