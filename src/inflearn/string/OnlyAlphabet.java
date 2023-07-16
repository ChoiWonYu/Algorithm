package inflearn.string;

import java.util.*;

public class OnlyAlphabet {
    public static String solution(String st){
        StringBuilder sb=new StringBuilder();
        st.chars()
                .filter(ch->Character.isAlphabetic(ch))
                .forEach(ch->sb.append((char)ch));
        sb.reverse();
        for(int i=0;i<st.length();i++){
            int targetAlph=st.charAt(i);
            if(!Character.isAlphabetic(targetAlph)) {
                sb.insert(i, (char) targetAlph);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String result=solution(sc.next());
        System.out.println(result);
    }
}
