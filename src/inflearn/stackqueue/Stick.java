package inflearn.stackqueue;

import java.util.*;

public class Stick {
  public static int solution(String s){
    Stack<Character> st=new Stack<>();
    int answer=0;
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='(')st.push('(');
      else{
        st.pop();
        if(s.charAt(i-1)=='(')answer+=st.size();
        else answer+=1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    int answer=solution(s);
    System.out.println(answer);
  }

}
