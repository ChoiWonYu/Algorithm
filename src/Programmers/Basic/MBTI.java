package Programmers.Basic;
import java.util.*;

public class MBTI {
    public static String solution(String[] survey, int[] choices) {
        Map<Character,Integer>m=new HashMap();
        for(int i=0;i<survey.length;i++){
            if(choices[i]==4)continue;
            if(choices[i]>4){
                m.put(survey[i].charAt(1),m.getOrDefault(survey[i].charAt(1),0)+choices[i]-4);
                continue;
            }
            m.put(survey[i].charAt(0),m.getOrDefault(survey[i].charAt(0),0)+4-choices[i]);
        }

        StringBuilder sb=new StringBuilder();
        if(m.getOrDefault('R',0)>m.getOrDefault('T',0))sb.append('R');
        else if(m.getOrDefault('R',0)==m.getOrDefault('T',0))sb.append('R');
        else sb.append('T');

        if(m.getOrDefault('C',0)>m.getOrDefault('F',0))sb.append('C');
        else if(m.getOrDefault('C',0)==m.getOrDefault('F',0))sb.append('C');
        else sb.append('F');

        if(m.getOrDefault('J',0)>m.getOrDefault('M',0))sb.append('J');
        else if(m.getOrDefault('J',0)==m.getOrDefault('M',0))sb.append('J');
        else sb.append('M');

        if(m.getOrDefault('A',0)>m.getOrDefault('N',0))sb.append('A');
        else if(m.getOrDefault('A',0)==m.getOrDefault('N',0))sb.append('A');
        else sb.append('N');

        return sb.toString();
    }

    public static void main(String[] args){
       String[] survey={"TR", "RT", "TR"};
       int[] scores={7, 1, 3};
        String result=solution(survey,scores);
        System.out.println(result);
    }


}
