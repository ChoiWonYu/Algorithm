package Programmers.Basic;
import java.util.*;

public class Fruit {
    public static int solution(int k, int m, int[] score) {
        ArrayList l=new ArrayList();
        int answer = 0;


        for(int i:score){
            l.add(i);
        }
        Collections.sort(l);

        while(l.size()%m!=0){
            l.remove(0);
        }
        for(int i=0;i<l.size();i+=m){
            answer+=(int)l.get(i)*m;
        }
        return answer;
    }

    public static void main(String[] args){
        int result=solution(4,15, new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
        System.out.println(result);
    }

}
