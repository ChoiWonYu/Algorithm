package Programmers.Basic;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PE {
    public static void main(String[]args){
        int[] lost={2,4};
        int[]reverse={3};
        int result=solution(5,lost,reverse);
        System.out.println(result);
    }

    public static void removeCantBorrow(Map<Integer,Boolean> lost,Map<Integer,Boolean> reserve){
        reserve.keySet().stream()
                .filter(s->lost.getOrDefault(s,true)==false)
                .forEach(n-> {
                    lost.put(n,true);
                    reserve.put(n,true);
                });
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer=n-lost.length;
        Map<Integer,Boolean> lostMap= new HashMap<Integer,Boolean>();
        for(int i:lost)lostMap.put(i,false);
        Map<Integer,Boolean> reserveMap= new HashMap<Integer,Boolean>();
        for(int i:reserve)reserveMap.put(i,false);

        removeCantBorrow(lostMap,reserveMap);

        for(int i:lostMap.keySet()){
            reserveMap.keySet().stream()
                    .filter(st->!reserveMap.get(st)&&Math.abs(st-i)==1)
                    .findFirst()
                    .ifPresent(s->{
                        lostMap.put(i,true);
                        reserveMap.put(s,true);
                    });
        }
        for(int i:lostMap.keySet())if(lostMap.get(i))answer++;

        return answer;
    }
}
