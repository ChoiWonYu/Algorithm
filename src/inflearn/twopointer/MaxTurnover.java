package inflearn.twopointer;

import java.util.*;

public class MaxTurnover {
  public static int solution(int[]turnover,int d){
    int max=-1;
    for(int i=0;i<=turnover.length-d;i++){
      int n=0;
      for(int j=i;j<i+d;j++)n+=turnover[j];
      if(max<n)max=n;
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int d=sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++)arr[i]=sc.nextInt();

    int result = solution(arr, d);
    System.out.println(result);
  }

}
