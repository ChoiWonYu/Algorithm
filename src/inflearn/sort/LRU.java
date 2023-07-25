package inflearn.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LRU {

  public static int[] solution(int n,int[] arr){
    List<Integer> answer = new ArrayList<>();
    for(int i=0;i<arr.length;i++){
      if(answer.contains(arr[i])){
        for(int j=0;j<answer.size();j++){
          if(answer.get(j)==arr[i]) {
            answer.remove(j);
            break;
          }
        }
      }
      else if(answer.size()>=n){
        answer.remove(0);
      }
      answer.add(arr[i]);
    }
    int[] answerArr=new int[n];
    for(int i=0;i<n;i++)answerArr[i]=answer.get(n-i-1);
    return answerArr;
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
