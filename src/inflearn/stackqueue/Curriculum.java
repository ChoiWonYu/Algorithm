package inflearn.stackqueue;

import java.util.*;

public class Curriculum {

  public static boolean solution(String p, String c) {
    Queue<Character> q = new LinkedList<>();
    boolean answer = true;
    for (char ch : p.toCharArray()) {
      q.offer(ch);
    }

    for (char ch : c.toCharArray()) {
      if (q.contains(ch)) {
        if (ch != q.poll()) {
          return false;
        }
      }
    }
    if (!q.isEmpty()) {
      answer = false;
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String p = sc.nextLine();
    String c = sc.nextLine();
    String answer = solution(p, c) ? "YES" : "NO";
    System.out.println(answer);
  }

}
