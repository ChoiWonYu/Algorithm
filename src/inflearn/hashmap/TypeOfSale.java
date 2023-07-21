package inflearn.hashmap;

import java.util.*;

public class TypeOfSale {

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    sc.nextLine();
    String[] arr=sc.nextLine().split(" ");

    int[] result=solution(arr,k);
    for (int i : result) {
      System.out.print(i+" ");
    }
  }

  private static int[] solution(String[] arr, int k) {
    Map<String,Integer>m=new HashMap<>();
    int[] answer=new int[arr.length-k+1];
    for(int i=0;i<k;i++){
      m.put(arr[i],m.getOrDefault(arr[i],0)+1);
    }

    answer[0]=m.keySet().size();
    int idx=1;

    for(int i=k;i<arr.length;i++){
      m.put(arr[i],m.getOrDefault(arr[i],0)+1);

      int discountValue=m.getOrDefault(arr[i-k],0)-1;
      if(discountValue==0)m.remove(arr[i-k]);
      else m.put(arr[i-k],discountValue);
      answer[idx++]=m.keySet().size();
    }
    return answer;
  }

}
