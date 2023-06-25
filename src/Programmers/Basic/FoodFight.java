package Programmers.Basic;
import java.util.*;

public class FoodFight {
    public static String solution(int[] food) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<food.length;i++){
            sb.append(Integer.toString(i).repeat(food[i]/2));
        }
        return sb.toString()+"0"+sb.reverse().toString();
    }

    public static void main(String[] args){
        String answer=solution(new int[] {1, 3, 4, 6});
        System.out.println(answer);
    }
}
