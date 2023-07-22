package inflearn.stackqueue;

import java.util.*;

public class Bracket {
  public static boolean solution(String b){
      Stack<Character>s=new Stack<>();
      for(char c:b.toCharArray()){
        if(c==')'){
          if(s.isEmpty())return false;
          s.pop();
        }
        else{
          s.push('(');
        }
      }
      return s.isEmpty()?true:false;
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    String answer=solution(s)?"YES":"NO";
    System.out.println(answer);
  }

}
