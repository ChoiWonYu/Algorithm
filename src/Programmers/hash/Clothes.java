package Programmers.hash;

import java.util.*;

class Solution4 {
    public int solution(String[][] clothes) {
        int answer=1;
        HashMap<String,Integer>map=new HashMap<String,Integer>();
        for(String[]s: clothes){
            map.put(s[1],map.getOrDefault(s[1],0)+1);
        }

        Set<Map.Entry<String,Integer>> m=map.entrySet();
        for(Map.Entry<String,Integer> e:m){
            answer*=(e.getValue()+1);
        }
        return answer-1;
    }
}


public class Clothes {
    public static void main(String[] args) {
    }
}
