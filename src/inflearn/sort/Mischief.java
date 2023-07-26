package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Mischief {

  public static int[] solution(int[] arr) {
    int[] answer = new int[2];
    int idx=0;
    int[] copyArr=new int[arr.length];
    for(int i=0;i<arr.length;i++)copyArr[i]=arr[i];
    Arrays.sort(copyArr);
    for(int i=0;i<arr.length;i++){
      if(arr[i]!=copyArr[i])answer[idx++]=i+1;
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int[] result = solution(arr);
    System.out.print(result[0] + " " + result[1]);
  }

}
