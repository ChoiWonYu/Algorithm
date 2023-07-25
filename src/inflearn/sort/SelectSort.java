package inflearn.sort;

import java.util.Scanner;

public class SelectSort {

  public static int[] solution(int[] arr) {
    int tmp=0, minIdx=0;
    for(int i=0;i<arr.length-1;i++){
      minIdx=i;
      for(int j=i;j<arr.length;j++){
        if(arr[minIdx]>arr[j])minIdx=j;
      }
      if(i!=minIdx){
        tmp=arr[minIdx];
        arr[minIdx]=arr[i];
        arr[i]=tmp;
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++)arr[i]=sc.nextInt();

    int[] result=solution(arr);
    for (int i = 0; i < n; i++) {
      System.out.print(result[i]+" ");
    }
  }

}
