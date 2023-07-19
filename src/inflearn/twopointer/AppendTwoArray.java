package inflearn.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class AppendTwoArray {
  public static int[] solution(int[]a,int[]b){
    int length=a.length+b.length;
    int[] answer=new int[length];
    for(int i=0;i<a.length;i++)answer[i]=a[i];
    for(int i=0;i<b.length;i++)answer[i+a.length]=b[i];
    Arrays.sort(answer);
    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int[]a=new int[n];
    for(int i=0;i<n;i++)a[i]=sc.nextInt();

    n=sc.nextInt();
    int[]b=new int[n];
    for(int i=0;i<n;i++)b[i]=sc.nextInt();

    int[] result=solution(a,b);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i]+" ");
    }
  }

}
