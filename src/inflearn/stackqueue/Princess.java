package inflearn.stackqueue;

import java.util.*;

public class Princess {

  public static int solution(int n, int k) {
    Queue<Integer> q = new LinkedList<>();
    int answer=0;
    for(int i=1;i<=n;i++)q.offer(i);
    while(!q.isEmpty()){
      for(int i=1;i<k;i++)q.offer(q.poll());
      q.poll();
      if(q.size()==1)answer=q.poll();
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int answer = solution(n, k);
    System.out.println(answer);
  }

}
