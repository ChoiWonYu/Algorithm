package Programmers.random_2nd;

import java.util.*;

public class Pr12973 {

    public int solution(String s)
    {
        Deque<Character> d = new LinkedList<>();
        d.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char target = s.charAt(i);
            if(d.isEmpty()){
                d.push(target);
            } else {
                if(d.peekLast() == target){
                    d.pollLast();
                } else {
                    d.addLast(target);
                }
            }
        }

        return d.isEmpty() ? 1 : 0;
    }
}
