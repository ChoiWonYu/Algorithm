package inflearn.hashmap;

import java.util.*;

public class Kth {

  public static int solution(int[] arr, int k) {
    Set<Integer> s = new TreeSet(Collections.reverseOrder());
    int answer = -1;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int l = j + 1; l < arr.length; l++) {
          s.add(arr[i] + arr[j] + arr[l]);
        }
      }
    }
    int cnt = 1;
    for (int i : s) {
      if (cnt++ == k) {
        return i;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int answer = solution(arr, k);
    System.out.println(answer);
  }

}
