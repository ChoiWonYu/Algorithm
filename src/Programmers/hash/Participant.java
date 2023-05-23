package Programmers.hash;

import java.util.*;

class Solution2 {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        HashMap<String,Integer> map=new HashMap<String,Integer>();

        for(String s:participant){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String s:completion){
            map.put(s,map.get(s)-1);
        }

        Set<String>s=map.keySet();
        for(String t:s){
            if(map.get(t)>0)answer=t;
        }
        return answer;
    }
}

public class Participant {
    public static void main(String[] args){
    }
}

