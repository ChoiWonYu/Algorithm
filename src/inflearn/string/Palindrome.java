package inflearn.string;

import java.util.*;

public class Palindrome {
    public static boolean solution(String s){
        StringBuilder sb=new StringBuilder();
        return s.toLowerCase().equals(sb.append(s.toLowerCase()).reverse().toString());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String answer=solution(sc.next())?"YES":"NO";
        System.out.println(answer);
    }
}
