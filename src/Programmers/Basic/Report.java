package Programmers.Basic;

import java.util.*;

public class Report {
    static Map<String,List<String>>reportUser=new HashMap();
    static Map<String,Integer>reportCnt=new HashMap();

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for(String s:report){
            String[]r=s.split(" ");
            if(reportUser.get(r[0])==null)reportUser.put(r[0],new ArrayList());
            if(reportUser.get(r[0]).contains(r[1]))continue;
            reportUser.get(r[0]).add(r[1]);
            reportCnt.put(r[1],reportCnt.getOrDefault(r[1],0)+1);
        }
        for(int i=0;i<answer.length;i++){
            for(String s:reportUser.getOrDefault(id_list[i],new ArrayList<String>())){
                if(reportCnt.getOrDefault(s,0)>=k)answer[i]++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String[] id_list={"con", "ryan"};
        String[] report={"ryan con", "ryan con", "ryan con", "ryan con"};

        int[] result=solution(id_list,report,2);

        System.out.println(Arrays.toString(result));
    }
}
