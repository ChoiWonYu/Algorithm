package inflearn.stackqueue;

import java.util.*;

public class Postfix {
  public static int solution(String s){
    Stack<Integer> st=new Stack<>();
    for(char c:s.toCharArray()){
      if(Character.isDigit(c)){
        st.push(Character.getNumericValue(c));
      }
      else{
        int x=st.pop();
        int y=st.pop();
        switch(c){
          case '+':
            st.push(x+y);
            break;
          case '-':
            st.push(y-x);
            break;
          case '*':
            st.push(x*y);
            break;
          case '/':
            st.push(y/x);
            break;
          default:return -1;
        }
      }
    }
  return st.pop();
  }


  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    int answer=solution(s);
    System.out.println(answer);
  }
}
