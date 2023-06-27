package Programmers.Basic;
import java.util.*;

public class Babbling {
    public static boolean canSpeakWord(String babbling){
        String[] canSpeak={"aya", "ye", "woo", "ma"};
        String[] dupSpeak={"ayaaya", "yeye", "woowoo", "mama"};
        for(String s:dupSpeak){
            if(babbling.contains(s))return false;
        }
        for(String s:canSpeak){
            while(babbling.contains(s))babbling=babbling.replace(s,"0");
        }
        if(babbling.replace("0","").equals(""))return true;
        return false;
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        for(String s:babbling){
            if(canSpeakWord(s))answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        String[] q={"ayayeayayeaya"};
        int a=solution(q);
        System.out.println(a);
    }

}
