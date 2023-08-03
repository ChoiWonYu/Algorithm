package inflearn.dfsbfs;

import java.sql.SQLOutput;
import java.util.*;

public class Permutation {

  static int[] answer;
  static int N;
  static int M;

  public static void dfs(int index){
    if(index==M){
      for(int i:answer){
        System.out.print(i+" ");
      }
      System.out.println();
      return;
    }

    for(int i=1;i<=N;i++){
      answer[index]=i;
      dfs(index+1);
    }
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    answer=new int[m];

    N=n;
    M=m;

    dfs(0);

  }
}
