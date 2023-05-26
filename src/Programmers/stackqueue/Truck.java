package Programmers.stackqueue;
import java.util.*;

public class Truck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer>busQ=new LinkedList<Integer>();
        Queue<Integer>bridgeQ=new LinkedList<Integer>();

        for(int i:truck_weights){
            busQ.add(i);
        }

        int time=0;
        Integer bridgeSum=0;
        while(busQ.peek()!=null||bridgeSum!=0){
            if(bridgeQ.size()==bridge_length){
                bridgeSum-=bridgeQ.poll();
            }

            if(busQ.peek()!=null&&bridgeSum+busQ.peek()<=weight){
                Integer w=busQ.poll();
                bridgeQ.add(w);
                bridgeSum+=w;
            }
            else{
                bridgeQ.add(0);
            }

            time++;
        }

        return time;
    }
    public static void main(String[] args){
        int[] truck_weight={10};
        int t=solution(100,100,truck_weight);

        System.out.println(t);
    }
}
