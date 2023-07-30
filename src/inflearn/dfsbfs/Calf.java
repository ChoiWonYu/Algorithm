package inflearn.dfsbfs;

import java.util.*;

public class Calf {

  public static int solution(int start, int end) {
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(start);
    int minLen=Integer.MAX_VALUE;
    int level=0;
    int minDis=0;
    while (minLen>0) {
      int len=Q.size();
      System.out.println(Q.toString());
      for(int i=0;i<len;i++){
        int cur=Q.poll();
        if(Math.abs(end-cur)<minLen) {
          minDis = cur;
          minLen = Math.abs(end - cur);
        }
      }
      Q.offer(minDis+1);
      Q.offer(minDis-1);
      Q.offer(minDis+5);
      level++;
    }
    return level-1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int s=sc.nextInt();
    int e=sc.nextInt();

    int answer = solution(s, e);
    System.out.println(answer);
  }

}
