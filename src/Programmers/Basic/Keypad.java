package Programmers.Basic;

import java.util.*;

public class Keypad {
    public static String getCloserFinger(int left, int right, int num,String hand){
        if(num==1||num==4||num==7)return "L";
        if(num==3||num==6||num==9)return "R";

        int leftDist=getDistance(num,left);
        int rightDist=getDistance(num, right);

        if(leftDist>rightDist)return "R";
        else if(rightDist>leftDist)return "L";
        else{
            return hand.equals("right")?"R":"L";
        }
    }

    public static int getDistance(int num, int fin){
        return Math.abs((num-1)/3-(fin-1)/3)+Math.abs(num%3-fin%3);
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb=new StringBuilder();
        int r=10;
        int l=12;
        for(int num:numbers){
            num=num==0?11:num;
            String finger=getCloserFinger(l,r,num,hand);
            if(finger=="R")r=num;
            else l=num;
            sb.append(finger);

        }
        return sb.toString();
    }

    public static void main(String []args){
        int ldist=getDistance(7,2);
        int rdist=getDistance(6,2);
        System.out.println(ldist);
        System.out.println(rdist);
        int[] numbers={1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand="right";
        String result=solution(numbers,hand);
        System.out.println(result);
    }
}
