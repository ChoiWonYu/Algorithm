package inflearn.sort;

import java.util.Scanner;

public class LRU {

  public static int[] solution(int n,int[] arr){
    int[] answer=new int[n];
    int hitIdx=0;
    for(int i:arr){
      hitIdx=-1;
      for(int j=0;j<answer.length;j++)if(answer[j]==i)hitIdx=j;
      if(hitIdx==-1){
        for(int j=n-2;j>=0;j--){
          answer[j+1]=answer[j];
        }
      }
      else{
        for(int j=hitIdx-1;j>=0;j--){
          answer[j+1]=answer[j];
        }
      }
      answer[0]=i;
    }

    return answer;
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int s=sc.nextInt();
    int[] arr = new int[s];
    for(int i=0;i<s;i++)arr[i]=sc.nextInt();
    int[] answer = solution(n, arr);
    for(int i=0;i<n;i++)System.out.print(answer[i]+" ");
  }

}
