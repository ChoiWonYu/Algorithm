package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Stall {


  public static boolean isValid(int[] arr, int k,int n) {
    int ep=0,cnt=1;
    for(int i=0;i<arr.length;i++){
      if(arr[i]-arr[ep]>=n){
        cnt++;
        ep=i;
      }
      if(cnt>=k)return true;
    }
    return cnt>=k?true:false;
  }

  public static int solution(int[] arr, int k) {
    Arrays.sort(arr);
    int rf=arr[arr.length-1]-arr[0];
    int mid=0;
    int lf=1;

    while(lf<=rf){
      mid=(lf+rf)/2;
      if(isValid(arr,k,mid))lf=mid+1;
      else rf=mid-1;
    }
    return lf-1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();

    int[] arr = new int[n];
    for(int i=0;i<n;i++)arr[i]=sc.nextInt();

    int answer = solution(arr, k);
    System.out.println(answer);
  }

}
