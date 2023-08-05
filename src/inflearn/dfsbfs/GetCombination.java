package inflearn.dfsbfs;

import java.util.*;

public class GetCombination {

  static int N, M;
  static int[] comb, nums;

  static boolean[] visited;

  public static void dfs(int idx) {
    if (idx == M) {
      System.out.println(Arrays.toString(comb));
      return;
    }

    for (int i = 0; i < N; i++) {
      if(visited[i]) continue;
      if(idx>0&&comb[idx-1]>nums[i])continue;
      comb[idx] = nums[i];
      visited[i] = true;
      dfs(idx + 1);
      visited[i] = false;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    nums = new int[N];
    comb = new int[M];
    visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      nums[i] = i + 1;
    }
    dfs(0);
  }

}
