package Programmers.Basic;
import java.util.*;

public class Race {
    public static Map<String,Integer> set=new HashMap<>();

    public static void ChangePlayer(String[] players,int idx){
        String temp=players[idx];
        set.put(players[idx],idx-1);
        set.put(players[idx-1],idx);
        players[idx]=players[idx-1];
        players[idx-1]=temp;
    }

    public static String[] solution(String[] players, String[] callings) {
        for(int i=0;i<players.length;i++){
            set.put(players[i],i);
        }
        for(String s:callings){
            ChangePlayer(players,set.get(s));
        }
        return players;
    }
    public static void main(String[] args){
        String[] players={"mumu", "soe", "poe", "kai", "mine"};
        String[] calling={"kai", "kai", "mine", "mine"};
        solution(players,calling);
        for(String s:players)System.out.println(s);
    }
}
