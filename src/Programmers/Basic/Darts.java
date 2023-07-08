package Programmers.Basic;
import java.util.*;

public class Darts {
    public static int solution(String dartResult) {
        int[] score=new int[dartResult.length()/2];
        int scoreIdx=0;
        int num;
        char bonus;
        for(int i=0;i<dartResult.length();i++){
            System.out.println(dartResult.charAt(i));
            String subString=dartResult.substring(i,i+2);
            if(subString.equals("10")){
                subString=dartResult.substring(i,i+3);
                num=Integer.valueOf(subString.substring(0,2));
                bonus=subString.charAt(2);
                i+=2;
            }
            else {
                num = Integer.valueOf(subString.substring(0, 1));
                bonus=subString.charAt(1);
                i+=1;
            }
            switch(bonus){
                case 'S':
                    break;
                case'D':
                    num*=num;
                    break;
                case 'T':
                    num*=num*num;
                    break;
                default:
                    continue;
            }
            score[scoreIdx]=num;
            if(i+1<dartResult.length()) {
                switch (dartResult.charAt(i + 1)) {
                    case '*':
                        i += 1;
                        score[scoreIdx] *= 2;
                        if (scoreIdx > 0) score[scoreIdx - 1] *= 2;
                        break;
                    case '#':
                        i += 1;
                        score[scoreIdx] *= -1;
                        break;
                    default:
                        break;
                }
            }
            scoreIdx++;
        }


        return Arrays.stream(score).sum();
    }

    public static void main(String[] args){
        int result=solution("1D2S#10S");
        System.out.println(result);
    }

}
