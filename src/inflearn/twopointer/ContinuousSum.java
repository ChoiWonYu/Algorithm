package inflearn.twopointer;

import java.util.*;

public class ContinuousSum {

  public static int solution(int n) {
    int[] arr = new int[n];
    for (int i = 1; i < n; i++) {
      arr[i] = i;
    }
    int cnt = 0;
    int sum = 0;
    int p1 = 0;
    int p2 = 0;
    while (p2 < arr.length) {
      if (sum == n) {
        cnt++;
        sum -= arr[p1++];
        sum += arr[p2++];
      } else if (sum > n) {
        sum -= arr[p1++];
      } else {
        sum += arr[p2++];
      }
    }
    while (p1 < arr.length) {
      if (sum == n) {
        cnt++;
        break;
      } else {
        sum -= arr[p1++];
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int result = solution(n);
    System.out.println(result);
  }

}
