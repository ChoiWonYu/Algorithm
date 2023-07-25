package inflearn.sort;

import java.util.Scanner;

public class BubbleSort {

  public static int[] solution(int[] arr) {
    int tmp=0;
    for(int i=0;i<arr.length-1;i++){
      for(int j=0;j<arr.length-i-1;j++){
        if(arr[j]>arr[j+1]){
          tmp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=tmp;
        }
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
