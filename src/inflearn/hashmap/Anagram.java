package inflearn.hashmap;

import java.util.*;

public class Anagram {

  public static boolean solution(String a, String b) {
    Map<Character, Integer> aMap = new HashMap<>();
    Map<Character, Integer> bMap = new HashMap<>();

    for (int i = 0; i < a.length(); i++) {
      char targetA=a.charAt(i);
      char targetB=b.charAt(i);

      aMap.put(targetA,aMap.getOrDefault(targetA,0)+1);
      bMap.put(targetB,bMap.getOrDefault(targetB,0)+1);
    }

    for(char c:aMap.keySet()){
      if(aMap.get(c)!=bMap.getOrDefault(c,-1))return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.nextLine();
    String b = sc.nextLine();

    String result = solution(a.toUpperCase(), b.toUpperCase()) ? "Yes" : "No";
    System.out.println(result);
  }

}
