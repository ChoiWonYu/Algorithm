package inflearn.hashmap;

import java.util.*;

public class Anagram {

  public static boolean solution(String a, String b) {
    Map<Character, Integer> aMap = new HashMap<>();

    for (int i = 0; i < a.length(); i++) {
      aMap.put(a.charAt(i),aMap.getOrDefault(a.charAt(i),0)+1);
    }

    for(char c:b.toCharArray()){
      if(!aMap.containsKey(c)||aMap.get(c)==0)return false;
      aMap.put(c,aMap.get(c)-1);
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
