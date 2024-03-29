package inflearn.sort;

import java.util.Scanner;

public class InsertionSort {

  public static int[] solution(int[] arr) {
    int tmp=0;
    for(int i=1;i<arr.length;i++){
      tmp=arr[i];
      int j;
      for(j=i-1;j>=0;j--){
        if(arr[j]>tmp)arr[j+1]=arr[j];
        else break;
      }
      arr[j+1]=tmp;
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
