package Programmers.stackqueue;

import java.util.*;

public class Process {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q=new LinkedList<Integer>();
        int l=location;
        int count=0;
        for(Integer i:priorities){
            q.add(i);
        }
        while(q.peek()!=null){
            int popValue=q.poll();
            boolean flag=true;
            for(Integer num:q){
                if(num>popValue){
                    q.add(popValue);
                    if(l==0)l=q.size()-1;
                    else l--;
                    flag=false;
                    break;
                }
            }
            if(flag){
                count++;
                if(l==0)return count;
                l--;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Queue<Integer> q=new LinkedList<Integer>();
    }
}
