package Programmers.Basic;
import java.util.*;

public class Partner {

    public static String solution(String X, String Y) {
        Map<Character,Integer> m=new HashMap();
        for(int i=0;i<X.length();i++){
            m.put(X.charAt(i),m.getOrDefault(X.charAt(i),0)+1);
        }
        List<Integer> l=new ArrayList();
        for(int i=0;i<Y.length();i++){
            Character c=Y.charAt(i);
            if(m.getOrDefault(c,0)<=0)continue;
            m.put(c,m.get(c)-1);
            l.add(Character.getNumericValue(c));
        }
        l.sort(Collections.reverseOrder());
        if(l.size()==0)return "-1";
        if(l.get(0)==0)return "0";
        StringBuilder sb=new StringBuilder();
        for(int i:l)sb.append(i);
        return sb.toString();
    }

    public static void main(String[] args){
        String result=solution("100","203045");
        System.out.println(result);
    }

}
