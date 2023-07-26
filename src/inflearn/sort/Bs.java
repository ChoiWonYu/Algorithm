package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Bs {

  public static int solution(int[] arr, int k) {
    Arrays.sort(arr);
    int lf = 0, rf = arr.length - 1, mid = 0;
    while (lf <= rf) {
      mid = (lf + rf) / 2;
      if (arr[mid] == k) {
        return mid + 1;
      }
      if (arr[mid] < k) {
        lf = mid + 1;
      } else {
        rf = mid - 1;
      }
    }
    return mid + 1;
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
