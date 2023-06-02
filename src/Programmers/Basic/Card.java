package Programmers.Basic;

public class Card {

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int gIdx=0;
        int point1=0;
        int point2=0;

        while(gIdx<goal.length){
            String g=goal[gIdx];
            if(point1<cards1.length&&cards1[point1].equals(g)){
                point1++;
            }
            else if(point2<cards2.length&&cards2[point2].equals(g)){
                point2++;
            }
            else return "No";
            gIdx++;
        }
        return "Yes";
    }

    public static void main(String[] args){
        String[] cards1={"drink", "i", "water"};
        String[] cards2={"want", "to"};
        String[] goal={"i", "want", "to", "drink", "water"};
        String ans=solution(cards1,cards2,goal);
        System.out.println(ans);
    }

}
