package inflearn.twopointer;

import java.util.*;

public class MaxLength {
  public static int solution(int[]arr,int n){
    int lt=0;
    int zCnt=0;
    int cnt=0;
    int max=0;
    for (int i = 0; i < arr.length; i++) {
      if(arr[i]==0) {
        zCnt++;
        if(zCnt>n){
          lt++;
          while(arr[lt]==1)lt++;
          zCnt--;
        }
      }
      cnt=i-lt;
      if(max<cnt)max=cnt;

    }
    return max;
  }


  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++)arr[i]=sc.nextInt();
    int result = solution(arr, m);
    System.out.println(result);

  }
}
