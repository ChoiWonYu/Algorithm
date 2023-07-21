package inflearn.hashmap;

import java.util.*;

public class AllAnagram {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s=sc.nextLine();
    String a=sc.nextLine();

    int result = solution(s, a);
    System.out.println(result);
  }

  public static int solution(String s, String a) {
    int answer=0;
    for(int i=0;i<=s.length()-a.length();i++){
      if(isAnagram(a,s.substring(i,i+a.length())))answer++;
    }
    return answer;
  }

  public static boolean isAnagram(String a, String b) {
    Map<Character, Integer> aChars = new HashMap<>();
    Map<Character, Integer> bChars = new HashMap<>();

    for (int i = 0; i < a.length(); i++) {
      char aTarget = a.charAt(i);
      char bTarget = b.charAt(i);

      aChars.put(aTarget, aChars.getOrDefault(aTarget, 0) + 1);
      bChars.put(bTarget, bChars.getOrDefault(bTarget, 0) + 1);
    }

    for (char s : aChars.keySet()) {
      if (aChars.get(s) != bChars.getOrDefault(s, -1)) {
        return false;
      }
    }
    return true;
  }
}
