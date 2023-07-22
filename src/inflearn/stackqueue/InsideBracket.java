package inflearn.stackqueue;

import java.util.*;

public class InsideBracket {
  public static String solution(String s) {
    Stack<Character> st = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ')') {
        while(st.peek()!='('){
          st.pop();
        }
        st.pop();
      }
      else{
        st.push(c);
      }
    }
    st.stream().forEach(c->sb.append((char)c));
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    String answer=solution(s);
    System.out.println(answer);
  }

}
