package inflearn.hashmap;

import java.util.*;

public class ClassPresident {

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    sc.nextLine();
    String s=sc.nextLine();
    char c=solution(s);
    System.out.println(c);
  }

  private static char solution(String s) {
    Map<Character,Integer>m=new HashMap<>();
    char answer=' ';
    s.chars().forEach(c->{
      m.put((char)c,m.getOrDefault((char)c,0)+1);
    });
     int max=Integer.MIN_VALUE;
     for(char c:m.keySet()){
       if(m.get(c)>max) {
         max = m.get(c);
         answer = c;
       }
     }

     return answer;
  }
}
