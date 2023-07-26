package inflearn.sort;

import java.util.Scanner;

public class Mv {

  public static boolean isValid(int[] arr, int n, int k) {
    int cnt=0,sum=0;
    for (int i = arr.length-1; i >= 0; i--) {
      if(sum+arr[i]>n){
        cnt++;
        sum=arr[i];
      }
      else sum+=arr[i];

      if(cnt>=k)return false;
    }
    return true;
  }

  public static int solution(int[] arr, int k) {
    int lf=arr[arr.length-1],rf=0,mid=0;
    for(int i=0;i<arr.length;i++)rf+=arr[i];

    while(lf<rf){
      mid=(lf+rf)/2;
      if(isValid(arr,mid,k))rf=mid;
      else lf=mid+1;
    }
    return rf;
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
