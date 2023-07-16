package inflearn.string;

import java.util.*;

public class DuplicateChar {
    public static String solution(String s){
        StringBuilder sb=new StringBuilder();
        s.chars()
                .forEach(ch->{
                    if(sb.indexOf(Character.toString((char)ch))==-1)sb.append((char)ch);
                });
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String result=solution(sc.next());
        System.out.println(result);
    }
}
