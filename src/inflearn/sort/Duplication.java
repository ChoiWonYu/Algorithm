package inflearn.sort;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Duplication {
  public static boolean solution(int[] arr){
    Set<Integer> s= new HashSet<>();
    for(int i:arr){
      s.add(i);
    }
    return arr.length>s.size()?true:false;
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++)arr[i]=sc.nextInt();
    String answer=solution(arr)?"D":"U";
    System.out.println(answer);
  }
}
