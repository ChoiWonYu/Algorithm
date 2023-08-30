package BOJ.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Balloon{
    private boolean isBomb=false;
    public int num;
    public int idx;

    public Balloon(int num,int idx){
        this.num=num;
        this.idx=idx;
    }

    public boolean getIsBomb(){
        return isBomb;
    }

    public void setBombTrue() {
        isBomb=true;
    }

    public int getNum() {
        return num;
    }

    public int getIdx() {
        return idx;
    }
}

public class Balloons {
    public static void main(String[] args)throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Balloon> d = new ArrayDeque<>();

        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            d.offerLast(new Balloon(Integer.parseInt(nums[i]), i));
        }
        int bombCnt = 0;
        int idx, num;

        while (true) {
            Balloon target=d.getFirst();

            target.setBombTrue();
            idx = target.getIdx();
            num = target.getNum();

            sb.append(idx+1).append(" ");

            bombCnt++;

            if(bombCnt>=n)break;
            moveBalloon(num, d);
        }
        System.out.println(sb.toString());
    }

    private static void moveBalloon(int num, Deque<Balloon> d) {

        while(num!=0){
            if(num>0){
                Balloon target=d.pollFirst();
                d.offerLast(target);
                if(!d.getFirst().getIsBomb())num--;
            }
            else{
                Balloon target=d.pollLast();
                d.offerFirst(target);
                if(!d.getFirst().getIsBomb())num++;
            }
        }
    }

}
