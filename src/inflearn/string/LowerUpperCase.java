package inflearn.string;

import java.util.*;

public class LowerUpperCase {
    public static String solution(String s){
        StringBuilder sb=new StringBuilder();
        s.chars()
                .map(ch->Character.isUpperCase(ch)?Character.toLowerCase(ch):Character.toUpperCase(ch))
                .forEach(ch->sb.append((char)ch));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String result=solution(sc.next());
        System.out.println(result);
    }
}
