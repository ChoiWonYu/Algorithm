package inflearn.string;

import java.util.*;

public class FindString {
    public static int solution(String str,char t){
        return str.chars().filter(c->Character.toLowerCase(c)==Character.toLowerCase(t)).toArray().length;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int result=solution(sc.next(),sc.next().charAt(0));
        System.out.println("result = " + result);
    }
}
