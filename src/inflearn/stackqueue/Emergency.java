package inflearn.stackqueue;

import java.util.*;

public class Emergency {
  public static boolean isMax(Queue<Integer> q){
    int x=q.peek();
    for(int i:q)if(i>x)return false;
    return true;
  }


  public static int solution(int[] p,int k){
    Queue<Integer> q=new LinkedList<Integer>();
    for(int i:p)q.offer(i);
    int num=k;
    int cnt=0;
    while(true){
      if(isMax(q)){
        cnt++;
        if(num==0)break;
        q.poll();
      }
      else{
       if(num==0)num=q.size();
       q.offer(q.poll());
      }
      num--;
    }
    return cnt;
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int[] p=new int[n];
    for(int i=0;i<n;i++)p[i]=sc.nextInt();
    int result=solution(p,k);
    System.out.println(result);
  }

}
