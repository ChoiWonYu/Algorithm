package inflearn.string;

import java.util.*;

public class Longest {
    public static String solution(String s){
        int maxLength=Arrays.stream(s.split(" "))
                .mapToInt(st->st.length())
                .max()
                .getAsInt();
        for(String str:s.split(" "))if(str.length()==maxLength)return str;
        return "";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String result=solution(sc.nextLine());
        System.out.println(result);
    }
}
