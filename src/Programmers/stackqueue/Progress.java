package Programmers.stackqueue;
import java.util.*;

public class Progress {
    public static int[] solution(int[] progresses, int[] speeds) {
        int l=progresses.length;
        ArrayList<Integer> pro=new ArrayList<Integer>(l);
        ArrayList<Integer> spd=new ArrayList<Integer>(l);
        ArrayList<Integer> result=new ArrayList<Integer>();

        for(int i:progresses){
            pro.add(i);
        }
        for(int i:speeds){
            spd.add(i);
        }

        int day=0;
        boolean flag=false;
        while(!pro.isEmpty()){
            for(int i=0;i<pro.size();i++){
                pro.set(i,pro.get(i)+spd.get(i));
            }
            while(true){
                if(!pro.isEmpty()&&pro.get(0)>=100){
                    pro.remove(0);
                    spd.remove(0);
                    if(!flag){
                        flag=true;
                        result.add(1);
                    }
                    else result.set(day,result.get(day)+1);
                }
                else{
                    if(flag)day++;
                    flag=false;
                    break;
                }
            }
        }
        int[] answer = new int[result.size()];

        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        Queue<Integer> q=new LinkedList<Integer>();
    }
}
