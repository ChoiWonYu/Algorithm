package inflearn.dfsbfs;

import java.util.*;

public class GuessPermutation {
  static int[] nums,comb;
  static boolean[]visited;
  static int N,M;
  static boolean found=false;

  public static boolean isM(int[] arr) {
    Queue<Integer> Q = new LinkedList<>();
    for(int i:arr)Q.offer(i);

    while(Q.size()>1){
      int len=Q.size();
      for (int i = 0; i < len - 1; i++) {
        Q.offer(Q.poll() + Q.peek());
      }
      Q.poll();
    }
    return Q.poll()==M;
  }

  public static void dfs(int idx) {
    if(found)return;

    if (idx == N) {
      if(isM(comb))found=true;
      return;
    }
    for (int i = 0; i < N; i++) {
      if(visited[i])continue;
      comb[idx] = nums[i];
      visited[i]=true;
      dfs(idx+1);
      visited[i]=false;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     N=sc.nextInt();
     M=sc.nextInt();
    nums = new int[N];
    comb = new int[N];
    visited = new boolean[N];
    for(int i=1;i<=N;i++)nums[i-1]=i;
    dfs(0);
    for(int i:comb)System.out.print(i+" ");
  }
}
