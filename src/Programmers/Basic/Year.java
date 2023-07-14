package Programmers.Basic;

import java.util.*;

public class Year {
    public int getTotalDateUntilPrev(int month){
        if(month==1)return 0;
        Map<Integer,Integer>m=new HashMap();
        for(int i=1;i<=12;i++)m.put(i,31);
        m.put(2,29);
        m.put(4,30);
        m.put(6,30);
        m.put(9,30);
        m.put(11,30);

        return m.keySet().stream().filter(k->k<month)
                .mapToInt(k->m.get(k)).sum();
    }

    public String solution(int a, int b) {
        String[] Day={"FRI","SAT","SUN","MON","TUE","WED","THU"};

        return Day[(getTotalDateUntilPrev(a)+b-1)%7];
    }

    public static void main(String[] args) {

    }
}
