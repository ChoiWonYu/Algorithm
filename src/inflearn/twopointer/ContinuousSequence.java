package inflearn.twopointer;

import java.util.*;

public class ContinuousSequence {

  public static int solution2(int n, int[] arr) {
    int lt = 0, sum = 0, answer = 0;
    for (int rt = 0; rt < arr.length; rt++) {
      if (sum >= n) {
        while (sum >= n) {
          sum -= arr[lt++];
          if (sum == n) {
            answer++;
          }
        }
      }
      sum += arr[rt++];
    }
    return answer;
  }


  public static int solution(int n, int[] arr) {
    if (arr.length == 1) {
      return n == arr[0] ? 1 : 0;
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
    int m = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int result = solution(m, arr);
    System.out.println(result);
  }

}
