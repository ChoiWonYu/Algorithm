package inflearn.hashmap;

import java.util.*;

public class Kth {
  static Set<Integer>answer=new HashSet<>();

  public static void combination(int[] arr, boolean[] visited, int r,int n) {
    if(r==0){
      int sum=0;
      for (int i = 0; i < visited.length; i++) {
        if(visited[i]) {
          sum += arr[i];
        }
      }
      answer.add(sum);
      return;
    }

    for(int i=n;i<arr.length;i++){
      if(!visited[i]) {
        visited[i] = true;
        combination(arr, visited, r - 1, n + 1);
        visited[i] = false;
      }
    }
  }

  public static int[] solution(int[] arr, int k) {
    boolean[] visited=new boolean[arr.length];
    combination(arr,visited,k,0);
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++)arr[i]=sc.nextInt();
    int[]result=solution(arr,k);

    Arrays.sort(result);
    System.out.println(result[result.length-k]);
  }

}
