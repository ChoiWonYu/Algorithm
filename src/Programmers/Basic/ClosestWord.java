package Programmers.Basic;
import java.util.*;

public class ClosestWord {
    public static int[]  solution(String s) {
        Map m=new HashMap<Character,Integer>();
        int[] answer=new int[s.length()];

        for(int i=0;i<s.length();i++){
            if(m.get(s.charAt(i))==null){
                answer[i]=-1;
                m.put(s.charAt(i),i);
                continue;
            }
            answer[i]=i-(int)(m.get(s.charAt(i)));
            m.put(s.charAt(i),i);

        }
        return answer;
    }
    public static void main(String[] main){
        int[] answer=solution("foobar");
        for(int i:answer){
            System.out.println(i);

        }
    }
}
