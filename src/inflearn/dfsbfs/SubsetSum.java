package inflearn.dfsbfs;

import java.util.*;

public class SubsetSum {

  static int n;
  static int[] arr;
  static int[] subset;
  static int sum=0;

  public static boolean DFS(int idx){
    if(idx==n){
      int s=0;
      for(int i=0;i<n;i++)if(subset[i]==1)s+=arr[i];
      return sum==2*s;
    }
    subset[idx]=1;
    if(DFS(idx+1))return true;
    subset[idx]=0;
    return DFS(idx+1);
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    arr=new int[n];
    subset=new int[n];

    for(int i=0;i<n;i++) {
      arr[i] = sc.nextInt();
      sum+=arr[i];
    }

    String answer=DFS(0)?"YES":"NO";
    System.out.println(answer);
  }

}
