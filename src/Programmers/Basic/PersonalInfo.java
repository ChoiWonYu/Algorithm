package Programmers.Basic;
import java.util.*;

public class PersonalInfo {
    public static boolean isExpired(String today,String startDate,int term){

        String[] d=startDate.split("[.]");
        String[] t=today.split("[.]");
        int[] todayDate=new int[3];
        int[] expiredDate=new int[3];
        for(int i=0;i<3;i++){
            todayDate[i]=Integer.parseInt(t[i]);
            expiredDate[i]=Integer.parseInt(d[i]);
        }
        int now=todayDate[0]*12*28+todayDate[1]*28+todayDate[2];
        int expired=expiredDate[0]*12*28+expiredDate[1]*28+expiredDate[2]+term*28;

        if(now>=expired)return true;
        return false;
    }


    public static int[] solution(String today, String[] terms, String[] privacies) {
        Map<String,Integer>t=new HashMap<String,Integer>();
        List<Integer>answer=new ArrayList<Integer>();

        for(String s:terms){
            StringTokenizer st=new StringTokenizer(s);
            t.put(st.nextToken(),Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<privacies.length;i++){
            StringTokenizer st=new StringTokenizer(privacies[i]);
            String startDate=st.nextToken();
            String privacy=st.nextToken();
            if(!isExpired(today,startDate,t.get(privacy)))continue;
            answer.add(i+1);
        }

        int[]a=new int[answer.size()];
        for(int i=0;i<answer.size();i++)a[i]=answer.get(i);
        return a;
    }

    public static void main(String[] args){
        String today="2020.01.01";
        String[] terms= {"A 1"};
        String[] privacies={"2019.12.01 A"};
        int[] answer=solution(today,terms,privacies);
        for(int i:answer)System.out.println(i);
    }

}
