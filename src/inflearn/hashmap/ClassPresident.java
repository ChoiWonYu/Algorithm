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
    s.chars().forEach(c->{
      m.put((char)c,m.getOrDefault((char)c,0)+1);
    });
     int max=0;
     for(int c:m.values()){
       max=Math.max(max,c);
     }

     for(char c:m.keySet()){
       if(m.getOrDefault(c,0)==max)return c;
     }
     return 'z';
  }
}
