package inflearn.string;

import java.util.Scanner;

public class ExtractInt {
    public static boolean isNumber(int ch){
        return ch>=48&&ch<=57?true:false;
    }

    public static int solution(String s){
        StringBuilder sb=new StringBuilder();
        s.chars()
                .filter(ch->isNumber(ch))
                .forEach(ch->sb.append((char)ch));
        return sb.length()>0?Integer.valueOf(sb.toString()):-1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(solution(sc.next()));
    }
}
