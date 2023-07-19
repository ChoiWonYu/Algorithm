package inflearn.twopointer;

import java.util.*;

public class MaxTurnover {
  public static int solution(int[]turnover,int d){
    int max;
    int sum=0;
    for(int i=0;i<d;i++)sum+=turnover[i];
    max=sum;

    for(int i=d;i<turnover.length;i++){
      sum+=turnover[i];
      sum-=turnover[i-d];
      if(max<sum)max=sum;
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
