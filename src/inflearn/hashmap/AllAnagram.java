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
}
