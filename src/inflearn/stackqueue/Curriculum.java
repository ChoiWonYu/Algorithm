package inflearn.stackqueue;

import java.util.*;

public class Curriculum {
  public static boolean solution(String p,String c){
    Queue<Character> q=new LinkedList<>();
    for(char ch:p.toCharArray())q.add(ch);

    for (char ch : c.toCharArray()) {
      if(q.isEmpty())return true;
      if (q.peek() == ch)q.poll();
    }
    return q.isEmpty()?true:false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String p=sc.nextLine();
    String c=sc.nextLine();
    String answer = solution(p, c) ? "YES" : "NO";
    System.out.println(answer);
  }

}
